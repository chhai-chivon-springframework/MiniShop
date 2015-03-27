package com.gazatem.jsf.minishop.dao;

import com.gazatem.jsf.minishop.models.Product;
import java.util.List;

public interface ProductDao {

    public List<Product> getProducts();

    public List<Product> getProductsByCategoryId(int catId);

    public Product getProduct(int productId);

}
