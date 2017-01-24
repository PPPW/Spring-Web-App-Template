package com.pppw.SpringWebApp.dao;

import java.util.List;

import com.pppw.SpringWebApp.model.Restaurant;

public interface RestaurantDao {
    
	public Restaurant get(int ID);
	public List<Restaurant> getAll();
	
	public void insert(Restaurant restaurant);
    public void update(Restaurant restaurant);     
    public void delete(int ID);

}
