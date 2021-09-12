package ru.gb.alekseiterentev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.alekseiterentev.shop.model.Product;
import ru.gb.alekseiterentev.shop.repositories.ProductRepository;
import ru.gb.alekseiterentev.shop.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAllProducts();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Long id, String name, Integer price) {
        repository.save(new Product(id, name, price));
    }
}
