package com.gazatem.jsf.minishop.controller;

import com.gazatem.jsf.minishop.dao.ProductDaoImp;
import com.gazatem.jsf.minishop.models.Product;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProductController {
 
    Product product;
    int productId;

    public ProductController() {
    }

 
    public Product getProduct() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        productId = Integer.parseInt(params.get("productId"));
        if (productId > 0) {
            Product product = new ProductDaoImp().getProduct(productId);
            //catId = product.getCatId();
            return product;
        }
        return null;
    }
}
