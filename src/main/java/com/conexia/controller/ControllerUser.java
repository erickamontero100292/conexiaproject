package com.conexia.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerUser {
    public static final String USER_DEFAULT = "conexia";
    public static final String PASSWORD_DEFAULT = "123456";

    public Boolean validateLogin(String userName, String password) {
        Boolean validate = false;
        if (USER_DEFAULT.equalsIgnoreCase(userName) && PASSWORD_DEFAULT.equalsIgnoreCase(password)) {
            validate = Boolean.TRUE;
        }
        return validate;
    }


}
