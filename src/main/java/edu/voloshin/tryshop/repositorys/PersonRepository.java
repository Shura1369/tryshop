package edu.voloshin.tryshop.repositorys;


import edu.voloshin.tryshop.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
