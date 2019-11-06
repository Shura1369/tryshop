package edu.voloshin.tryshop.services.pasport.impls;


import edu.voloshin.tryshop.models.Passport;
import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.repositorys.PassportRepository;
import edu.voloshin.tryshop.repositorys.PersonRepository;
import edu.voloshin.tryshop.services.pasport.interfaces.IPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements IPassportService {
    List<Passport> passports = new ArrayList<>();


    @Autowired
    PassportRepository passportRepository;

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    void init(){
        passportRepository.deleteAll();

        passports.add( new Passport("KP333555", "Peter","Petrov","Petrovich",
                LocalDate.of(1969, 11, 13), LocalDate.of(2000,1,1)));
        passports.add( new Passport("KP555777", "Ivan","Ivanov","Ivanovich",
                LocalDate.of(1992,03,13), LocalDate.of(2001,2,2)));
        passports.add( new Passport("KP777999", "Sidor","Sidorov","Sidorovich",
                LocalDate.of(1973,01,18), LocalDate.of(2001,2,2)));
      passportRepository.saveAll(passports);

    }

    @Override
    public List<Passport> getAll() {
        return passportRepository.findAll();
    }



    @Override
    public Passport get(String id) {
        return passportRepository.findById(id).orElse(null);
    }

    public Person getPerson(String id){
        Person person = personRepository.findAll().stream().filter(persone -> persone.getPassport().getId().equals(id))
                .findAny().orElse(null);
        return person;
    }


    @Override
    public Passport delete(String id) {
        Passport passport = this.get(id);

        passportRepository.deleteById(id);
        List<Person> personList = personRepository.findAll().stream().filter(person -> person.getPassport().getId().equals(id))
                .collect(Collectors.toList());
        personRepository.deleteAll(personList);

        return passport;
    }

    @Override
    public Passport update(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport create(Passport passport) {
        return passportRepository.save(passport);
    }

}
