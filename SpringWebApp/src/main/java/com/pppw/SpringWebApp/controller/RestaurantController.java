package com.pppw.SpringWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pppw.SpringWebApp.dao.RestaurantDao;
import com.pppw.SpringWebApp.model.Restaurant;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping(value="/restaurantList", method = RequestMethod.GET)
	public String listRestaurants(Model model) {
	    List<Restaurant> allRestaurants = restaurantDao.getAll();
	    model.addAttribute("allRestaurants", allRestaurants);
	 
	    return "restaurantList";
	}
	
	@RequestMapping(value = "/newRestaurant", method = RequestMethod.GET)
	public String newRestaurant(Model model) {
		Restaurant newRestaurant = new Restaurant();
		model.addAttribute("restaurant", newRestaurant);
	    return "restaurantForm";	    
	}
//	@RequestMapping(value = "/newRestaurant", method = RequestMethod.GET)
//	public ModelAndView newRestaurant(ModelAndView model) {
//		Restaurant newContact = new Restaurant();
//		model.addObject("restaurant", newContact);
//		model.setViewName("restaurantForm");
//		return model;
//    }
	// TODO
	@RequestMapping(value = "/editRestaurant", method = RequestMethod.POST)
    public String editRestaurant(Model model, @ModelAttribute("restaurant") Restaurant restaurant) {
		if (restaurant.getID() > 0) {
			restaurantDao.update(restaurant);
		}
		else {
			restaurantDao.insert(restaurant);
		}
		return "redirect:restaurantList";
	}		
	// TODO
	@RequestMapping(value = "/deleteRestaurant", method = RequestMethod.GET)
	public String deleteRestaurant(@RequestParam("id") int restaurantId) {
	    restaurantDao.delete(restaurantId);
	    return "redirect:restaurantList";
	}
}
