package com.pppw.SpringWebApp.dao;

import com.pppw.SpringWebApp.model.User;

public interface UserDao {
	
    public boolean isValidUser(String username, String password);
    public UserGroup getUserGroup(String username);
    
    public void insert(User user);
    
    // You can implement more operations, in the same way as RestaurantDao
}

