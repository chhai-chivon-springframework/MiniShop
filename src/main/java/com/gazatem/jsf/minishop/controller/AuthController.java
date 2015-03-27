package com.gazatem.jsf.minishop.controller;

import com.gazatem.jsf.minishop.dao.CustomerDaoImp;
import com.gazatem.jsf.minishop.models.Customer;
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
    private String naviMsg;
    private boolean isLogin;

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

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

    public String getNaviMsg() {
        return naviMsg;
    }

    public void setNaviMsg(String naviMsg) {
        this.naviMsg = naviMsg;
    }

    public AuthController() {
    }

    public boolean isLogin() {
        HttpSession session = SessionBean.getSession();
        String msg = (String) session.getAttribute("name");
        if (!"".equals(msg)) {
            return true;
        } else {
            return false;
        }
    }

    public String getNavigationBarMessage() {
        HttpSession session = SessionBean.getSession();
        String msg = (String) session.getAttribute("name");
        if (!"".equals(msg)) {
            return (String) session.getAttribute("name");
        } else {
            return "";
        }
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
                        "Can not create user",
                        "Please enter email, username and Password"));
        return "signup";
    }

    public String loginUser() {
        Customer customer = new CustomerDaoImp().loginUser(email, password);
        if (customer != null) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("name", customer.getName());
            return "home";
        }
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Incorrect Username and Passowrd",
                        "Please enter correct username and Password"));
        return "login";
    }

}
