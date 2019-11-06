package edu.voloshin.tryshop.controllers.rest;


import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class PersonRestController {
    @Autowired
    PersonServiceImpl service;

    @RequestMapping("/person/list")
    List<Person> showAll(){
        return service.getAll();
    }
}
