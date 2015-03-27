package com.gazatem.jsf.minishop.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author kemal
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String password;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    
}
