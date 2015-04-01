 
package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Customer;
import java.util.List;

/**
 *
 * @author kemal
 */
public interface CustomerDao {
    public List<Customer> getCustomers();
    public Customer createUser(String email, String name, String password);
    public Customer loginUser(String email, String password);
    
}
