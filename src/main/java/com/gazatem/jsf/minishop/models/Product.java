package com.gazatem.jsf.minishop.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")

public class Product implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    private int quantity;
    private float  price;
    private int catId;
    private String image;
    
    public int getId() {
        return id;
    } 

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    } 

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(int id, String name, int quantity, float price, int catId, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.catId = catId;
        this.image = image;
    }

   
    
    
    public static void main(String[] args) {
        
    }
}
