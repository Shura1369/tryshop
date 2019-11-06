package edu.voloshin.tryshop.services.order.interfaces;



import edu.voloshin.tryshop.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order get(String id);
    Order delete(String id);
    Order update(Order order);
    Order create(Order order);
}
