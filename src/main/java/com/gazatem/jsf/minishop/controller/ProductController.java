/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazatem.jsf.minishop.controller;

import com.gazatem.jsf.minishop.dao.CategoryDaoImp;
import com.gazatem.jsf.minishop.dao.ProductDaoImp;
import com.gazatem.jsf.minishop.models.Category;
import com.gazatem.jsf.minishop.models.Product;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProductController {

    Category category;
    Product product;
    int catId;
    int productId;

    public ProductController() {
    }

    public Category getCategory() {

        if (catId > 0) {
            category = new CategoryDaoImp().getCategory(catId);
            return category;
        }
        return null;
    }

    public Product getProduct() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        productId = Integer.parseInt(params.get("productId"));
        if (productId > 0) {
            Product product = new ProductDaoImp().getProduct(productId);
            catId = product.getCatId();
            return product;
        }
        return null;
    }
}
