package edu.voloshin.tryshop.services.person.interfaces;



import edu.voloshin.tryshop.models.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
    Person get(String id);
    Person delete(String id);
    Person update(Person person);
    Person create(Person person);
}
