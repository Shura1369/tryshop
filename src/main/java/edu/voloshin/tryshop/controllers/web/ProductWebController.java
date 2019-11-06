package edu.voloshin.tryshop.controllers.web;



import edu.voloshin.tryshop.forms.ProductForm;
import edu.voloshin.tryshop.models.Product;
import edu.voloshin.tryshop.models.TypeId;
import edu.voloshin.tryshop.models.TypeProduct;
import edu.voloshin.tryshop.services.conteiner.impl.ConteinerIdServiceImpl;
import edu.voloshin.tryshop.services.product.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/product")
@CrossOrigin("*")
@Controller
public class ProductWebController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ConteinerIdServiceImpl conteinerIdService;

    @RequestMapping("/list")
    public String showAll(Model model)
    {
        List<Product> productList = productService.getAll();
        model.addAttribute("products",productList);
       return "productlist";
    }

    @RequestMapping("/delete/{id}")
    public RedirectView deleteProduct(@PathVariable(value = "id")String id)
    {
        productService.delete(id);
        return new RedirectView("/product/list");
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProduct(Model model){
        List<Product> list = productService.getAll();
        model.addAttribute("products", list);

        return "productSearch";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchProduct(Model model, @RequestParam(defaultValue = "") String searchProductName) {
        List<Product> products = productService.getAll();
        List<Product> filterList = products.stream()
                .filter(p -> p.getName().contains(searchProductName))
                .collect(Collectors.toList());
        model.addAttribute("products", filterList);
        for (Product product:filterList) {
            System.out.println(product.getName());
        }
        System.out.println(searchProductName);
        model.addAttribute("lastSearch", searchProductName);
        return "productSearch";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createProduct(Model model){
        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm",productForm);
        model.addAttribute("typeProd", TypeProduct.values());
        return "productCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  String create(Model model, @ModelAttribute("productForm") ProductForm productForm) {
        if (conteinerIdService.getContIdService().getTypeId() == TypeId.ORDER && conteinerIdService != null) {
            productForm.setOrderId(conteinerIdService.getContIdService().getContId());
            conteinerIdService.clearContIdService();
        }
        Product newProduct = new Product(productForm.getName(), productForm.getPrice(),
                productForm.getTypeProduct(), productForm.getDescription(), false);
        productForm.setId(productService.create(newProduct).getId());
        conteinerIdService.setContIdService(TypeId.PRODUCT, productForm.getId());
        System.out.println(productForm.getOrderId());
        if (productForm.getOrderId() != null) {
            String orderId = "redirect:/order/create/" + productForm.getOrderId();
            return orderId;

        } else return "redirect:/product/list";
    }

}
