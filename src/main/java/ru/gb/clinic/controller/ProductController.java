package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(name = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Product getProduct(@PathVariable Long id) {
        return productService.get(id);
    }

    @GetMapping(name = "/products", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public List<Product> getProductList() {
        return productService.getAll();
    }

    @PostMapping(name = "/products/", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public void addProduct(Product product) {
        productService.save(product);
    }

    @GetMapping(name = "/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
