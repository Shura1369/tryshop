package edu.voloshin.tryshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client  {

    @Id
    private String id;
    private Person person;
    private String phone;
    private String email;
    private boolean isActive;

    public Client() {
    }


}
