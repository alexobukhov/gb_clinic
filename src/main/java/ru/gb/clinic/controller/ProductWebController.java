package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.service.ProductService;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping
public class ProductWebController {

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

    @GetMapping(value = "/{id}/delete")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.deleteProduct(id);
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "index";
    }
}
