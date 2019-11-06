package edu.voloshin.tryshop.controllers.rest;


import edu.voloshin.tryshop.models.Passport;
import edu.voloshin.tryshop.services.pasport.impls.PassportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class PassportRestController {
    @Autowired
    PassportServiceImpl service;

    @RequestMapping("/passport/list")
    List<Passport> showAll(){
        return service.getAll();
    }

}
