package com.pppw.SpringWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pppw.SpringWebApp.dao.RestaurantDao;
import com.pppw.SpringWebApp.model.Restaurant;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping(value="/restaurantList", method = RequestMethod.GET)
	public String listContact(Model model) {
	    List<Restaurant> allRestaurants = restaurantDao.getAll();
	    model.addAttribute("allRestaurants", allRestaurants);
	    //model.setViewName("home");
	 
	    return "restaurantList";
	}
	
	@RequestMapping(value = "/editRestaurant", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("restaurant") Restaurant restaurant) {
		if (restaurant.getID() > 0) {
			restaurantDao.update(restaurant);
		}
		else {
			restaurantDao.insert(restaurant);
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/newRestaurant", method = RequestMethod.GET)
	public String newContact(Model model) {
	    return "restaurantForm";
	}
}
