package edu.voloshin.tryshop.controllers.web;


import edu.voloshin.tryshop.forms.AddressForm;
import edu.voloshin.tryshop.models.Address;
import edu.voloshin.tryshop.models.TypeId;
import edu.voloshin.tryshop.services.address.impls.AddressServiceImpl;
import edu.voloshin.tryshop.services.conteiner.impl.ConteinerIdServiceImpl;
import edu.voloshin.tryshop.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/address")
@CrossOrigin("*")
@Controller
public class AddressWebController {

        @Autowired
        AddressServiceImpl addressService;

        @Autowired
        PersonServiceImpl personService;

        @Autowired
        ConteinerIdServiceImpl conteinerIdService;





        @RequestMapping("/list")
        public String showAll(Model model)
        {
            List<Address> list = addressService.getAll();
            model.addAttribute("addressList", list);
            return "addresslist";
        }
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        public String searchPassport(Model model){
            List<Address> list = addressService.getAll();
            model.addAttribute("addressList", list);

            return "addressSearch";
        }
        @RequestMapping(value = "/search", method = RequestMethod.POST)
        public String search(Model model,
                             @RequestParam(defaultValue = "") String searchCountry,
                             @RequestParam(defaultValue = "") String searchArea,
                             @RequestParam(defaultValue = "") String searchCity,
                             @RequestParam(defaultValue = "") String searchStreet,
                             @RequestParam(defaultValue = "") String searchBuilding,
                             @RequestParam(defaultValue = "") String searchHous
                             ) {
            List<Address> addresses = addressService.getAll();
            List<Address> filterList = addresses.stream()
                    .filter(p -> p.getCountry().contains(searchCountry))
                    .collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchArea)).collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchCity)).collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchStreet)).collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchBuilding)).collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchBuilding)).collect(Collectors.toList());
            filterList = filterList.stream().filter(p -> p.getArea().contains(searchHous)).collect(Collectors.toList());

            model.addAttribute("addressList", filterList);
            model.addAttribute("lastSearch", searchCountry);
            return "addressSearch";
        }

        @RequestMapping("/delete/{id}")
        RedirectView delete(@PathVariable(value = "id") String id){
            addressService.delete(id);
            return new RedirectView ("/address/list");
        }

        @RequestMapping(value = "/create", method = RequestMethod.GET)
        public String createAddress(Model model){
            AddressForm addressForm = new AddressForm();
            model.addAttribute("addressForm",addressForm);

            return "addressCreate";
        }

        @RequestMapping(value = "/create", method = RequestMethod.POST)
        public  String create(Model model, @ModelAttribute("addressForm") AddressForm addressForm)
        {
            if(conteinerIdService.getContIdService().getTypeId()== TypeId.PERSON&&conteinerIdService!=null){
                addressForm.setPersonId(conteinerIdService.getContIdService().getContId());
                conteinerIdService.clearContIdService();
            }
            Address newAddress = new Address(addressForm.getCountry(), addressForm.getArea(),
                    addressForm.getCity(), addressForm.getStreet(),
                    addressForm.getBuilding(), addressForm.getHouse()
                    );
            addressForm.setId( addressService.create(newAddress).getId());
            conteinerIdService.setContIdService(TypeId.ADDRESS,addressForm.getId());
            System.out.println(addressForm.getPersonId());

            if(addressForm.getPersonId()!=null)
            {
                String persId="redirect:/person/create/"+addressForm.getPersonId();
                return persId;
                //return "redirect:/person/create";
            }
            else
                return "redirect:/address/list";



        }

        @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
        public  String updateAddress(Model model,@PathVariable("id") String id)
        {
            System.out.println("fl1");
            System.out.println(id);
            AddressForm addressForm = new AddressForm();
            Address addressUpd = addressService.get(id);
            System.out.println(addressUpd);
            System.out.println("fl2");
            System.out.println("flag"+addressUpd.getId());
            System.out.println("flag"+addressUpd.getCountry());
            addressForm.setId(id);
            if(addressService.getPerson(id)!=null){
            addressForm.setPersonId(addressService.getPerson(id).getId());
            }
            addressForm.setCountry(addressUpd.getCountry());
            addressForm.setArea(addressUpd.getArea());
            addressForm.setCity(addressUpd.getCity());
            addressForm.setStreet(addressUpd.getStreet());
            addressForm.setBuilding(addressUpd.getBuilding());
            addressForm.setHouse(addressUpd.getHouse());
            System.out.println(addressForm.getPersonId());

            model.addAttribute("addressForm",addressForm);

            return "addressUpdate";

        }

        @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
        String updatePassport(Model model,@ModelAttribute("addressForm") AddressForm addressForm,
                              @PathVariable("id") String id )
        {
            Address address = new Address(
                    addressForm.getCountry(),
                    addressForm.getArea(),
                    addressForm.getCity(),
                    addressForm.getStreet(),
                    addressForm.getBuilding(),
                    addressForm.getHouse()

            );
            address.setId(id);

            addressForm.setId( addressService.create(address).getId());

            if( addressService.getPerson(id)!=null){
            conteinerIdService.setContIdService(TypeId.ADDRESS,addressForm.getId());
                addressForm.setPersonId(addressService.getPerson(id).getId());
                String persId="redirect:/person/update/"+addressForm.getPersonId();
                return persId;
            }

            else
            return "redirect:/address/list";

        }
}
