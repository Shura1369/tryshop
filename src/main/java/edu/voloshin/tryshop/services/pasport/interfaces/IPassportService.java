package edu.voloshin.tryshop.services.pasport.interfaces;



import edu.voloshin.tryshop.models.Passport;

import java.util.List;

public interface IPassportService {
    List<Passport> getAll();
    Passport get(String id);
    Passport delete(String id);
    Passport update(Passport passport);
    Passport create(Passport passport);

}
