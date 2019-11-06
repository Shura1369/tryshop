package edu.voloshin.tryshop.services.product.impls;


import edu.voloshin.tryshop.models.Product;
import edu.voloshin.tryshop.models.TypeProduct;
import edu.voloshin.tryshop.repositorys.ProductRepository;
import edu.voloshin.tryshop.services.product.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    List<Product> products = new ArrayList<>();

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    void init(){
           productRepository.deleteAll();
           products.add(new Product("phone Apple",60000, TypeProduct.ELECTRONICS,"super", false));
           products.add(new Product("phone Samsung",10000, TypeProduct.ELECTRONICS,"crash", false));
           products.add(new Product("watch",300000, TypeProduct.WATCHS,"beautiful", false));
           productRepository.saveAll(products);

    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product delete(String id) {

        Product product = this.get(id);
        productRepository.deleteById(id);

        return product;
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
