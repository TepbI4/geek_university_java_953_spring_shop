package ru.gb.alekseiterentev.shop.repositories.impl;

import org.springframework.stereotype.Component;
import ru.gb.alekseiterentev.shop.model.Product;
import ru.gb.alekseiterentev.shop.repositories.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryProductRepository implements ProductRepository {

    private static final List<Product> repository = new ArrayList<>();

    @PostConstruct
    public void init() {
        repository.add(new Product(1L, "Bread", 40));
        repository.add(new Product(2L, "Milk", 80));
        repository.add(new Product(3L, "Cheese", 150));
        repository.add(new Product(4L, "Sausage", 250));
        repository.add(new Product(5L, "Cookies", 90));
    }

    public List<Product> findAllProducts() {
        return repository;
    }

    @Override
    public Product findById(Long id) {
        return repository.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        repository.add(product);
    }
}
