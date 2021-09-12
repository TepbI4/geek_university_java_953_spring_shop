package ru.gb.alekseiterentev.shop.repositories;

import ru.gb.alekseiterentev.shop.model.Product;

import java.util.List;

public interface ProductRepository {

    void init();
    List<Product> findAllProducts();
    Product findById(Long id);
    void save(Product product);
}
