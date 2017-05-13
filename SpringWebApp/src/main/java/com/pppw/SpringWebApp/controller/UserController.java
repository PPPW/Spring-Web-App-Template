package com.pppw.SpringWebApp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String init(Model model) {        
        return "users";
    }
}
