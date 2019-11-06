package edu.voloshin.tryshop.repositorys;


import edu.voloshin.tryshop.models.Passport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends MongoRepository <Passport, String>{

}
