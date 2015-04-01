package com.gazatem.jsf.minishop.controller;
import com.gazatem.jsf.minishop.dao.CustomerDaoImp;
import com.gazatem.jsf.minishop.models.Cart;
import com.gazatem.jsf.minishop.models.Customer;
import com.gazatem.jsf.minishop.models.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AuthController {

    private String name;
    private String password;
    private String email;
    private Customer customer;
    

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    
    public Customer getCustomer() {
        return customer;
    }

    public AuthController() {
    }

    public String createUser() {
        customer = new CustomerDaoImp().createUser(email, name, password);
        if (customer instanceof Customer) {
            return "home";
        }
        return "signup";
    }

    public String loginUser() {
        customer = new CustomerDaoImp().loginUser(email, password);
        if (customer instanceof Customer) {
            return "home";
        }
        return "login";
    }

}
