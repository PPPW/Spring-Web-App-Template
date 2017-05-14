package com.pppw.SpringWebApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pppw.SpringWebApp.dao.RestaurantDao;
import com.pppw.SpringWebApp.dao.UserDao;
import com.pppw.SpringWebApp.dao.UserGroup;
import com.pppw.SpringWebApp.model.Restaurant;

@Controller
public class RestaurantController {	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping(value="/restaurantList", method = RequestMethod.GET)
	public String listRestaurants(Model model, HttpServletRequest request) {
		// TODO
		String userName = (String) request.getSession().getAttribute("userName");
		UserGroup userGroup = userDao.getUserGroup(userName);
		
		model.addAttribute("userName", userName);
	    model.addAttribute("userGroup", userGroup);
	    
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
	
	@RequestMapping(value = "/editRestaurant", method = RequestMethod.GET)
    public String editRestaurant(Model model, @RequestParam("id") int restaurantId) {
		Restaurant newRestaurant = restaurantDao.get(restaurantId);
		model.addAttribute("restaurant", newRestaurant);
	    return "restaurantForm";
	}
	
	@RequestMapping(value = "/editRestaurant", method = RequestMethod.POST)
    public String submitRestaurantEdit(Model model, @ModelAttribute("restaurant") Restaurant restaurant) {		
		if (restaurant.getID() > 0) {
			restaurantDao.update(restaurant);
		}
		else {
			restaurantDao.insert(restaurant);
		}
		return "redirect:restaurantList";
	}		
	
	@RequestMapping(value = "/deleteRestaurant", method = RequestMethod.GET)
	public String deleteRestaurant(@RequestParam("id") int restaurantId) {
	    restaurantDao.delete(restaurantId);
	    return "redirect:restaurantList";
	}
}
