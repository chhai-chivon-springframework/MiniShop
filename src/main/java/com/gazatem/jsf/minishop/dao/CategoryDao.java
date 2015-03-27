/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazatem.jsf.minishop.dao;

import java.util.List;
import com.gazatem.jsf.minishop.models.Category;
/**
 *
 * @author kemal
 */
public interface CategoryDao {
    public List<Category> getCategories();
    
    public Category getCategory(int id);
    
}
