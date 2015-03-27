package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Product;
import com.gazatem.jsf.minishop.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImp implements ProductDao {

    @Override
    public List<Product> getProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Product product").list();
        t.commit();
        return lista;
    }

    @Override
    public List<Product> getProductsByCategoryId(int catId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Product product where catId = '" + catId + "'").list();
        t.commit();
        return lista;
    }

    @Override
    public Product getProduct(int productId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Product product = (Product) session.createQuery("from Product product where id =:productId").setParameter("productId", productId).uniqueResult();
        t.commit();
        return product;
    }

}
