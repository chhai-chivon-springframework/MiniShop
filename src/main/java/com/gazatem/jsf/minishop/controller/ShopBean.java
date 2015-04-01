package com.gazatem.jsf.minishop.controller;

import com.gazatem.jsf.minishop.dao.CartDaoImp;
import com.gazatem.jsf.minishop.dao.CategoryDaoImp;
import com.gazatem.jsf.minishop.dao.CustomerDaoImp;
import com.gazatem.jsf.minishop.dao.ProductDaoImp;
import com.gazatem.jsf.minishop.models.Cart;
import com.gazatem.jsf.minishop.models.Category;
import com.gazatem.jsf.minishop.models.Customer;
import com.gazatem.jsf.minishop.models.Product;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class ShopBean {

    public String shopName = "MiniShop";
    DataModel categoryProducts;
    DataModel products;
    DataModel categories;
    private Category category;

    int catId;
    int productId;

    public ShopBean() {
    }

    public String getShopName() {
        return shopName;
    }

    public DataModel getProducts() {
        List<Product> lista = new ProductDaoImp().getProducts();
        products = new ListDataModel(lista);
        return products;
    }

    public DataModel getCategoryProducts() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        catId = Integer.parseInt(params.get("catId"));
        List<Product> lista = new ProductDaoImp().getProductsByCategoryId(catId);
        categoryProducts = new ListDataModel(lista);
        return categoryProducts;
    }

    public DataModel getCategories() {
        List<Category> lista = new CategoryDaoImp().getCategories();
        categories = new ListDataModel(lista);
        return categories;
    }

    public Category getCategory() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        catId = Integer.parseInt(params.get("catId"));
        if (catId > 0) {
            category = new CategoryDaoImp().getCategory(catId);
            return category;
        }
        return null;
    }

    public String addCart(String productId){
        System.out.println("Product Id" + productId);
//        Customer customer=FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{authController.customer}", Customer.class);
//        new CartDaoImp().addCart(productId, customer.getId());
        return "index";
    }
    
}
