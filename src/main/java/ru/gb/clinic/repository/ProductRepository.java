package ru.gb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.gb.clinic.model.Product;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {


    public List<Product> findAllByCostIsAfter(int minCost);

    public List<Product> findAllByCostIsBefore(int maxCost);

    public List<Product> findAllByCostIsBetween(int minCost, int maxCost);
}
