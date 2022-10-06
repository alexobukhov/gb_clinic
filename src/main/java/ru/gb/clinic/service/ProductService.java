package ru.gb.clinic.service;

import org.springframework.stereotype.Service;
import ru.gb.clinic.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product((long) i, "Продукт " + i, new Random().nextLong()));
        }
        return productList;
    }
}
