package edu.voloshin.tryshop.services.address.impls;


import edu.voloshin.tryshop.models.Address;
import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.repositorys.AddressRepository;
import edu.voloshin.tryshop.repositorys.PersonRepository;
import edu.voloshin.tryshop.services.address.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    List<Address> addressList = new ArrayList<>();


    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Address> getAll() {
            return addressRepository.findAll();
    }

    @Override
    public Address get(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address delete(String id) {
        Address address = this.get(id);
        addressRepository.deleteById(id);
        return address;
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @PostConstruct
    void init(){
        addressRepository.deleteAll();
        addressList.add( new Address("Ukrina","Chernovickaya","Chernovcy","Ruska","219e","55"));
        addressList.add( new Address("Ukrina","Chernovickaya","Chernovcy","golovna","210","69"));
        addressList.add( new Address("USA","California","Ghicago","11","22","33"));
        addressList.add( new Address("Australiya","Sidney","Sidney","22","33","55"));
        addressList.add( new Address("Slovakiya","Bratislavs","Bratislava","Gorkogo","55","77"));
        addressList.add( new Address("Egipt","Aleksandriyas","Aleksandriya","Ramzesa","11","33"));







        addressRepository.saveAll(addressList);
        System.out.println("fl1");
        for (Address address:addressRepository.findAll()) {
            System.out.println(address.getId());
        }
        System.out.println("fl2");
    }


    public Person getPerson(String id){

        Person person = personRepository.findAll().stream().filter(persone -> persone.getAddress().getId().equals(id))
                .findAny().orElse(null);
        return person;
    }
}
