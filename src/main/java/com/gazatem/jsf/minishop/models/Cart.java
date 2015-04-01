package com.gazatem.jsf.minishop.models;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private int id;
    
    private int productId;
    private int customerId;
//    private Product product;
//    private Customer customer;

 
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
// 
//    @ManyToOne
//    @JoinColumn(name = "customerId")
//    public Customer getCustomer() {
//        return this.customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    } 
//    
//    @ManyToOne
//    @JoinColumn(name = "productId")
//    public Product getProduct() {
//        return this.product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }     

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Cart() {
    }

    
    public Cart(int id, int productId, int customerId) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
    }

    public void setCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setProduct(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
