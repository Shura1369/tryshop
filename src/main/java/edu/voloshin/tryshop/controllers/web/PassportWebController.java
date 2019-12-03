package edu.voloshin.tryshop.controllers.web;


import edu.voloshin.tryshop.forms.PassportForm;
import edu.voloshin.tryshop.models.Passport;
import edu.voloshin.tryshop.models.TypeId;
import edu.voloshin.tryshop.services.conteiner.impl.ConteinerIdServiceImpl;
import edu.voloshin.tryshop.services.pasport.impls.PassportServiceImpl;
import edu.voloshin.tryshop.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/passport")
@CrossOrigin("*")
@Controller
public class PassportWebController {

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    PassportServiceImpl passportService;

    @Autowired
    ConteinerIdServiceImpl conteinerIdService;



    @RequestMapping("/list")
    public String showAll(Model model)
    {
        List<Passport> list = passportService.getAll();
        model.addAttribute("passports", list);
        return "passportlist";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPassport(Model model){
        List<Passport> list = passportService.getAll();
        model.addAttribute("passports", list);

        return "passportSearch";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam(defaultValue = "") String searchName) {
        List<Passport> passports = passportService.getAll();
        List<Passport> filterList = passports.stream()
                .filter(p -> p.getMiddleName().contains(searchName))
                .collect(Collectors.toList());
        model.addAttribute("passports", filterList);
        for (Passport passport:filterList) {
            System.out.println(passport.getMiddleName());
        }
        System.out.println(searchName);
        model.addAttribute("lastSearch", searchName);
        return "passportSearch";
    }

    @RequestMapping("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){
        passportService.delete(id);
        return new RedirectView ("/passport/list");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPassport(Model model){
        PassportForm passportForm = new PassportForm();
        model.addAttribute("passportForm",passportForm);

        return "passportCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  String create(Model model, @ModelAttribute("passportForm") PassportForm passportForm)
    {
        if(conteinerIdService.getContIdService().getTypeId()==TypeId.PERSON&&conteinerIdService!=null){
            passportForm.setPersonId(conteinerIdService.getContIdService().getContId());
            conteinerIdService.clearContIdService();
        }
        Passport newPassport = new Passport(passportForm.getNumber(), passportForm.getFirstName(),
                passportForm.getMiddleName(), passportForm.getLastName(),
                LocalDate.parse(passportForm.getBirthDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                LocalDate.parse(passportForm.getDataObt(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        passportForm.setId( passportService.create(newPassport).getId());
        conteinerIdService.setContIdService(TypeId.PASSPORT,passportForm.getId());
        //System.out.println(passportForm.getPersonId());
        model.addAttribute("passport", newPassport);
        Map modelMap = model.asMap();
        for (Object modelKey : modelMap.keySet()) {
            Object modelValue = modelMap.get(modelKey);
            System.out.println(modelKey + " +++++ " + modelValue.toString());
        }
        if(passportForm.getPersonId()!=null)
        {
                String persId = "redirect:/person/create/" + passportForm.getPersonId();
                return persId;

        }
        else return "redirect:/passport/list";



    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public  String updatePassport(Model model,@PathVariable("id") String id)
    {
        System.out.println("?????????");

        Map modelMap = model.asMap();
        for (Object modelKey : modelMap.keySet()) {
            Object modelValue = modelMap.get(modelKey);
            System.out.println(modelKey + " +++++ " + modelValue.toString());
        }
        System.out.println("?????????");
        PassportForm passportForm = new PassportForm();
        Passport passportUpdate = passportService.get(id);
        passportForm.setId(id);
        if(passportService.getPerson(id)!=null)
        passportForm.setPersonId(passportService.getPerson(id).getId());
        passportForm.setNumber(passportUpdate.getNumber());
        passportForm.setFirstName(passportUpdate.getFirstName());
        passportForm.setMiddleName(passportUpdate.getMiddleName());
        passportForm.setLastName(passportUpdate.getLastName());
        passportForm.setBirthDate(passportUpdate.getBirthDate().
                format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
        passportForm.setDataObt(passportUpdate.getDataObt().
                format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());

        System.out.println(passportForm.getPersonId());
        model.addAttribute("passportForm",passportForm);

        return "passportUpdate";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String updatePassport(Model model,@ModelAttribute("passportForm") PassportForm passportForm,
                          @PathVariable("id") String id )
    {
        Passport passport = new Passport(
           id,passportForm.getNumber(),
           passportForm.getFirstName(),
           passportForm.getMiddleName(),
           passportForm.getLastName(),
                LocalDate.parse(passportForm.getBirthDate(),DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                LocalDate.parse(passportForm.getDataObt(),DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        passportForm.setId( passportService.create(passport).getId());
        conteinerIdService.setContIdService(TypeId.PASSPORT,passportForm.getId());


        if(passportService.getPerson(id)!=null)
        passportForm.setPersonId(passportService.getPerson(id).getId());
        System.out.println(passportForm.getPersonId());

        if( passportService.getPerson(id)!=null){
            String persId="redirect:/person/update/"+passportForm.getPersonId();
            return persId;
        }
        else
        return "redirect:/passport/list";

    }

}
