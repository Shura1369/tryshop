package edu.voloshin.tryshop.services.address.interfaces;



import edu.voloshin.tryshop.models.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address get(String id);
    Address delete(String id);
    Address update(Address address);
    Address create(Address address);
}
