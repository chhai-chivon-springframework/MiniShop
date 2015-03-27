/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Category;
import com.gazatem.jsf.minishop.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kemal
 */
public class CategoryDaoImp implements CategoryDao {

    @Override
    public List<Category> getCategories() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Category category").list();
        t.commit();
        return lista;
    }

    @Override
    public Category getCategory(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 
        Category category = (Category) session.createQuery("from Category category where id =:id").setParameter("id",id).uniqueResult();
        t.commit();
        return category;
    }

}
