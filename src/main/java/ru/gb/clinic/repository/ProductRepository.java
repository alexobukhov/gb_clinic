package ru.gb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import ru.gb.clinic.model.Product;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select id, title, cost from product")
    public List<Product> getAllProducts();
}
