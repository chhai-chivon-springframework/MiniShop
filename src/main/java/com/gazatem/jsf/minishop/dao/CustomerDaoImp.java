/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Customer;
import com.gazatem.jsf.minishop.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kemal
 */
public class CustomerDaoImp implements CustomerDao{

    @Override
    public List<Customer> getCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createUser(String email, String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Customer customer = new Customer(name, password, email);
        session.save(customer);
        t.commit();
        return true;
    }
    
}
