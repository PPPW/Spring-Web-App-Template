package com.pppw.SpringWebApp.dao;

public interface UserDao {
    public boolean isValidUser(String username, String password);
    public UserGroup getUserGroup(String username);
}

