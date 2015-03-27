package com.gazatem.jsf.minishop.controller;

import com.gazatem.jsf.minishop.dao.CustomerDaoImp;
import com.gazatem.jsf.minishop.utilities.SessionBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class AuthController {

    private String name;
    private String password;
    private String email;
    private String message;

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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public AuthController() {
    }

    public String createUser() {
        boolean result = new CustomerDaoImp().createUser(email, name, password);

        if (result) {

            HttpSession session = SessionBean.getSession();
            session.setAttribute("name", name);
            return "home";
        }

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Incorrect Username and Passowrd",
                        "Please enter correct username and Password"));
        return "signup";

    }

}
