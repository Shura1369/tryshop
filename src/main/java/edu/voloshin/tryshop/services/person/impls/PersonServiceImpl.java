package edu.voloshin.tryshop.services.person.impls;


import edu.voloshin.tryshop.models.Address;
import edu.voloshin.tryshop.models.Gender;
import edu.voloshin.tryshop.models.Passport;
import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.repositorys.PassportRepository;
import edu.voloshin.tryshop.repositorys.PersonRepository;
import edu.voloshin.tryshop.services.address.impls.AddressServiceImpl;
import edu.voloshin.tryshop.services.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    List<Person> people = new ArrayList<>();

    @Autowired
    PersonRepository personRepository;


    @Autowired
    PassportRepository passportRepository;

    @Autowired
    AddressServiceImpl addressService;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person delete(String id) {
        Person person = this.get(id);
        personRepository.deleteById(id);
        passportRepository.deleteById(person.getPassport().getId());
        return person;
    }

    @PostConstruct
    void init()
    {
        personRepository.deleteAll();
        List<Passport> passports = passportRepository.findAll();
        List<Address> addresses = addressService.getAll();
        System.out.println("fl3");
        for (Address address:addresses ) {
            System.out.println(address.getId());
        }
        System.out.println("fl4");
        int i = 1;
        for ( Passport passport:passports ) {
            people.add(new Person(passport, Gender.MAN,new Address(),""));
        }
        for (Person person:people) {
            person.setAddress(addresses.get(i++));
        }

        personRepository.saveAll(people);
    }
    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }
}
