package ru.gb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsWithCostHigherThan(int minCost) {
        return productRepository.findAllByCostIsAfter(minCost);
    }

    public List<Product> getProsuctsWithCostLowerThan(int maxCost) {
        return productRepository.findAllByCostIsBefore(maxCost);
    }

    public List<Product> getProductsWithCostBetween(int minCost, int maxCost) {
        return productRepository.findAllByCostIsBetween(minCost, maxCost);
    }
}
