package ru.gb.alekseiterentev.shop.repositories.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.alekseiterentev.shop.db.SessionFactoryBean;
import ru.gb.alekseiterentev.shop.model.Product;
import ru.gb.alekseiterentev.shop.repositories.ProductRepository;

import java.util.List;

@Component
public class DbProductRepository implements ProductRepository {

    SessionFactoryBean sessionFactoryBean;

    @Autowired
    public void setSessionFactoryBean(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Product> findAllProducts() {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void save(Product product) {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
