package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping(value = "/products/add")
    public String getAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping(value = "/products/save")
    public String addProduct(Product product, Model model) {
        productService.saveProduct(product);
        model.addAttribute(product);
        return "save";
    }
}
