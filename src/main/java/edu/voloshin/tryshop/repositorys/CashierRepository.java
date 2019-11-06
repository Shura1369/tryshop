package edu.voloshin.tryshop.repositorys;


import edu.voloshin.tryshop.models.Cashier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends MongoRepository<Cashier,String> {
}
