package edu.voloshin.tryshop.repositorys;


import edu.voloshin.tryshop.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
}
