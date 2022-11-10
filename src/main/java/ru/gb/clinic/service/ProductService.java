package ru.gb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gb.clinic.model.Product;
import ru.gb.clinic.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getPage(Pageable pageable) {
        List<Product> productList = productRepository.findAll();
        int size = pageable.getPageSize();
        int current = pageable.getPageNumber();
        int start = current * size;
        List<Product> listToView = new ArrayList<>();
        if (productList.size() < start) {
            listToView = Collections.emptyList();
        } else {
            int index = Math.min(start + size, productList.size());
            listToView = productList.subList(start, index);
        }
        return new PageImpl<Product>(listToView, PageRequest.of(current, size), productList.size());
    }

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
