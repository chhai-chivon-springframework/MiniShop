package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Cart;
import com.gazatem.jsf.minishop.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aeris
 */
public class CartDaoImp implements CartDao{

    @Override
    public boolean addCart(int productId, int customerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction(); 
        Cart cart = new Cart();
        cart.setCustomer(customerId);
        cart.setProduct(productId);
        session.save(cart);
        t.commit();
        return true;
    }
    
}
