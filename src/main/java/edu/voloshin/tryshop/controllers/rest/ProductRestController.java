package edu.voloshin.tryshop.controllers.rest;



import edu.voloshin.tryshop.models.Product;
import edu.voloshin.tryshop.services.product.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class ProductRestController {

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/product/list")
    List<Product> showAll(){
        return productService.getAll();
    }
}
