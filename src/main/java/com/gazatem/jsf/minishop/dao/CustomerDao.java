/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Customer;
import java.util.List;

/**
 *
 * @author kemal
 */
public interface CustomerDao {
    public List<Customer> getCustomers();
    public boolean createUser(String email, String name, String password);
    public Customer loginUser(String email, String password);
}
