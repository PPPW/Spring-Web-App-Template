package com.pppw.SpringWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pppw.SpringWebApp.dao.UserDao;
import com.pppw.SpringWebApp.model.User;
import com.pppw.SpringWebApp.viewBean.LoginBean;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String init(Model model) {        
        return "users";
    }
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("User") User user) {     
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getUsergroup());
		userDao.insert(user);
        return "redirect:restaurantList";
    }
}
