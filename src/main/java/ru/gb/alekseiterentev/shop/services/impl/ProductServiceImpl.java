package ru.gb.alekseiterentev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.gb.alekseiterentev.shop.model.Product;
import ru.gb.alekseiterentev.shop.repositories.ProductRepository;
import ru.gb.alekseiterentev.shop.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    @Qualifier("dbProductRepository")
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
    public void save(String name, Integer price) {
        repository.save(new Product(name, price));
    }

    @Override
    public void decrease(Long id) {
        Product product = repository.findById(id);
        if (product.getPrice() > 0) {
            product.setPrice(product.getPrice() - 1);
        }
        repository.save(product);
    }

    @Override
    public void increase(Long id) {
        Product product = repository.findById(id);
        if (product.getPrice() > 0) {
            product.setPrice(product.getPrice() + 1);
        }
        repository.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        repository.delete(product);
    }
}
