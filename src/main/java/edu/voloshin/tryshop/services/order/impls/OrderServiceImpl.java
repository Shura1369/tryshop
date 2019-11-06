package edu.voloshin.tryshop.services.order.impls;


import edu.voloshin.tryshop.models.Order;
import edu.voloshin.tryshop.models.Person;
import edu.voloshin.tryshop.models.Product;
import edu.voloshin.tryshop.repositorys.OrderRepository;
import edu.voloshin.tryshop.services.order.interfaces.IOrderService;
import edu.voloshin.tryshop.services.person.impls.PersonServiceImpl;
import edu.voloshin.tryshop.services.product.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    List<Order> orders = new ArrayList<>();

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    PersonServiceImpl personService;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order delete(String id) {
        Order order = this.get(id);
        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }
    @PostConstruct
    void init(){
        orderRepository.deleteAll();
        List <Person> personList = personService.getAll();
        List<Product> products = productService.getAll();

        for (int i=0, j=0;i<personList.size();i++,j++) {
            orders.add(new Order(true,products.get(i), LocalDate.of(2019,11,9),
                    LocalDate.of(2019,12,9), 7000,13000,10000,
                    personList.get(j)));
        }

        orderRepository.saveAll(orders);

    }

    @Scheduled(cron = "0 * * * * ?")
    void CalcBuybackPrice ()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);

    }
}
    /*private String id;
    private boolean isActive;
    private  Product product;
    private LocalDate getDate;
    private LocalDate retDate;
    private double issuedMoney;//выдано денег
    private double sellingPrice;//цена продажи
    private double buybackPrice;//выкупная цена
    private Person person;*/
