package ru.gb.alekseiterentev.shop.services;

import ru.gb.alekseiterentev.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    void save(String name, Integer price);
    void decrease(Long id);
    public void increase(Long id);
    public void delete(Long id);
}
