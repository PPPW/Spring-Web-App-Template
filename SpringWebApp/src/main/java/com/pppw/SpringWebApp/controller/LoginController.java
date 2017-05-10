package com.pppw.SpringWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pppw.SpringWebApp.dao.UserDao;
import com.pppw.SpringWebApp.dao.UserGroup;
import com.pppw.SpringWebApp.viewBean.LoginBean;

 
@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null && loginBean.getPassword() != null) {
        	if (userDao.isValidUser(loginBean.getUserName(), loginBean.getPassword())) {
        		UserGroup userGroup = userDao.getUserGroup(loginBean.getUserName());
        		model.addAttribute("userGroup", userGroup);
                model.addAttribute("msg", "Welcome " 
                		+ loginBean.getUserName() 
                		+ "! You are logged in as " + userGroup);
                return "redirect:restaurantList";
            } else {
                model.addAttribute("error", "Invalid credentials");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {		
		return "redirect:/login";
	}
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return "redirect:/login";
	}
}
