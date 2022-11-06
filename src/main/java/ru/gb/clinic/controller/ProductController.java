package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.service.ProductService;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/")
    public String getProducts(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping(value = "/add")
    public String getAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping(value = "/save")
    public String addProduct(Product product, Model model) {
        productService.save(product);
        List<Product> products = productService.getAll();
        model.addAttribute(products);
        return "index";
    }

    @DeleteMapping (value = "/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.deleteProduct(id);
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "index";
    }
}
