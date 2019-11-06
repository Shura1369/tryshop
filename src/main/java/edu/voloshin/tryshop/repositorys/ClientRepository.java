package edu.voloshin.tryshop.repositorys;


import edu.voloshin.tryshop.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {
}
