package edu.voloshin.tryshop.controllers.web;


import edu.voloshin.tryshop.forms.PersonForm;
import edu.voloshin.tryshop.models.Address;
import edu.voloshin.tryshop.models.Gender;
import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.models.TypeId;
import edu.voloshin.tryshop.services.address.impls.AddressServiceImpl;
import edu.voloshin.tryshop.services.conteiner.impl.ConteinerIdServiceImpl;
import edu.voloshin.tryshop.services.pasport.impls.PassportServiceImpl;
import edu.voloshin.tryshop.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/person")
@CrossOrigin("*")
@Controller
public class PersonWebController {

    @Autowired
    PersonServiceImpl personService;
    @Autowired
    PassportServiceImpl passportService;
    @Autowired
    ConteinerIdServiceImpl conteinerIdService;

    @Autowired
    AddressServiceImpl addressService;



    @RequestMapping("/list")
    String showAll(Model model)
    {
        List<Person> list = personService.getAll();
        model.addAttribute("people", list);
        return "personlist";
    }

    @RequestMapping("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){
        personService.delete(id);
        return new RedirectView ("/person/list");
    }

    @RequestMapping(value ="/create/{id}" , method = RequestMethod.GET)
    public String createPerson(Model model, @PathVariable("id") String id){
        PersonForm personForm = new PersonForm();
        Person newPerson;

        System.out.println(conteinerIdService.getContIdService().getTypeId());
        if(conteinerIdService.getContIdService().getContId()!=null && conteinerIdService.getContIdService().getTypeId()==TypeId.PASSPORT ) {
            personForm.setPassport(passportService.get(conteinerIdService.getContIdService().getContId()).getFirstName() + " " +
                    passportService.get(conteinerIdService.getContIdService().getContId()).getMiddleName() + " " +
                    passportService.get(conteinerIdService.getContIdService().getContId()).getLastName());

            newPerson = personService.get(id);
            newPerson.setPassport(passportService.get(conteinerIdService.getContIdService().getContId()));
            personForm.setId(personService.update(newPerson).getId());
            conteinerIdService.clearContIdService();


        }
        else if(personService.get(id)==null) {
           newPerson = new Person();
            personForm.setId(personService.create(newPerson).getId());
           personForm.setPassport("");
            conteinerIdService.setContIdService(TypeId.PERSON,personForm.getId());
        }
        else {
            personForm.setPassport(personService.get(id).getPassport().getFirstName() + " " +
                    personService.get(id).getPassport().getMiddleName() + " " +
                    personService.get(id).getPassport().getLastName()
                    );
        }
        if(conteinerIdService.getContIdService().getContId()!=null && conteinerIdService.getContIdService().getTypeId()==TypeId.ADDRESS )
        {
            newPerson = personService.get(id);
            newPerson.setAddress(addressService.get(conteinerIdService.getContIdService().getContId()));
            personForm.setId(personService.update(newPerson).getId());
            personForm.setAddress(addressService.get(conteinerIdService.getContIdService().getContId()).getCountry()+" "+
            addressService.get(conteinerIdService.getContIdService().getContId()).getArea()+" "+
            addressService.get(conteinerIdService.getContIdService().getContId()).getCity()+" "+
            addressService.get(conteinerIdService.getContIdService().getContId()).getStreet()+" "+
            addressService.get(conteinerIdService.getContIdService().getContId()).getBuilding()+" "+
            addressService.get(conteinerIdService.getContIdService().getContId()).getHouse());
            conteinerIdService.clearContIdService();

        }

        else
        {
            personForm.setAddress("");
            conteinerIdService.setContIdService(TypeId.PERSON,personForm.getId());
        }

        model.addAttribute("personForm",personForm);
        model.addAttribute("genders", Gender.values());

        return "personCreate";
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public  String create(Model model, @ModelAttribute("personForm") PersonForm personForm,@PathVariable("id") String id)
    {
        Person newPerson = personService.get(id);

        if(newPerson.getAddress()==null){
            newPerson.setAddress( new Address());
        }

        newPerson.setGender(personForm.getGender());
        newPerson.setIpn(personForm.getIpn());
        personService.update(newPerson);
        System.out.println(personService.get(id).getPassport().getNumber());
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public  String updatePerson(Model model,@PathVariable("id") String id)
    {
        PersonForm personForm = new PersonForm();
        Person personUpdate = personService.get(id);
        personForm.setId(id);
        personForm.setAddressId(personUpdate.getAddress().getId());
        if(conteinerIdService.getContIdService().getContId()!=null && conteinerIdService.getContIdService().getTypeId()==TypeId.PASSPORT )
           {
            personForm.setPassport(passportService.get(conteinerIdService.getContIdService().getContId()).getFirstName()+" "+
                    passportService.get(conteinerIdService.getContIdService().getContId()).getMiddleName()+" "+
                    passportService.get(conteinerIdService.getContIdService().getContId()).getLastName());
            personUpdate.setPassport(passportService.get(conteinerIdService.getContIdService().getContId()));
               personService.update(personUpdate);
            conteinerIdService.clearContIdService();
               conteinerIdService.setContIdService(TypeId.PERSON,personForm.getId());
           }
        else personForm.setPassport(personUpdate.getPassport().getFirstName()+" "+personUpdate.getPassport().getMiddleName());
        if(conteinerIdService.getContIdService().getContId()!=null && conteinerIdService.getContIdService().getTypeId()==TypeId.ADDRESS )
        {
            personForm.setAddress(addressService.get(conteinerIdService.getContIdService().getContId()).toString());
        personUpdate.setAddress(addressService.get(conteinerIdService.getContIdService().getContId()));
        personService.update(personUpdate);
        conteinerIdService.clearContIdService();
            conteinerIdService.setContIdService(TypeId.PERSON,personForm.getId());
        }
        else personForm.setAddress(personUpdate.getAddress().getCountry()+" "+
        personUpdate.getAddress().getArea()+" "+
        personUpdate.getAddress().getCity()+" "+
        personUpdate.getAddress().getStreet()+" "+
        personUpdate.getAddress().getBuilding()+" "+
        personUpdate.getAddress().getHouse()
        );

        personForm.setPassportId(personUpdate.getPassport().getId());
        personForm.setGender(personUpdate.getGender());
        personForm.setIpn(personUpdate.getIpn());


        model.addAttribute("genders", Gender.values());
        model.addAttribute("personForm",personForm);

        return "personUpdate";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String updatePassport(Model model,@ModelAttribute("personForm") PersonForm personForm,
                          @PathVariable("id") String id)
    {
        Person person = personService.get(id);

        if(conteinerIdService.getContIdService().getTypeId()==TypeId.PASSPORT
                && conteinerIdService.getContIdService().getContId()!=null
                && conteinerIdService!=null ){

        }
        else person.setPassport(personService.get(id).getPassport());
        if(conteinerIdService.getContIdService().getTypeId()==TypeId.ADDRESS
                && conteinerIdService.getContIdService().getContId()!=null
                && conteinerIdService!=null ){

        }
        else person.setAddress(personService.get(id).getAddress());
        person.setGender(personForm.getGender());
        person.setIpn(personForm.getIpn());
        personForm.setPassport(person.getPassport().getFirstName()+" "+person.getPassport().getMiddleName());
        System.out.println(personForm.getPassport());
        model.addAttribute("personForm",personForm);

        personService.update(person);
        return "redirect:/person/list";
    }

}
