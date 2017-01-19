package com.pppw.SpringWebApp.dao;

import java.util.List;

import com.pppw.SpringWebApp.model.Restaurant;

public interface RestaurantDao {
    
	public Restaurant get(int restaurantId);
	public List<Restaurant> getAll();
	
    public void update(Restaurant restaurant);     
    public void delete(int restaurantId);

}
