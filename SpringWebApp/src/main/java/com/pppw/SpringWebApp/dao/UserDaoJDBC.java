package com.pppw.SpringWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pppw.SpringWebApp.model.User;

public class UserDaoJDBC implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDaoJDBC(DataSource userDataSource) {
        jdbcTemplate = new JdbcTemplate(userDataSource);
    }
	
	public boolean isValidUser(String username, String password) {				
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		User user; 
		try {
			user = (User) jdbcTemplate.queryForObject(
				sql, 
				new Object[] { username }, 
				new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
		    		user.setUsername(rs.getString("username"));
		    		user.setPassword(rs.getString("password"));
		    		user.setUsergroup(rs.getInt("usergroup"));
		    		return user;
		    		}
				});
		} 
		catch ( org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
		
		if (user != null && user.getUsername().equals(password))			
			return true;
		else
			return false;
	}
	
    public UserGroup getUserGroup(String username) {
    	String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		
		User user = (User) jdbcTemplate.queryForObject(
				sql, 
				new Object[] { username }, 
				new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
		    		user.setUsername(rs.getString("username"));
		    		user.setPassword(rs.getString("password"));
		    		user.setUsergroup(rs.getInt("usergroup"));
		    		return user;
		    		}
				});
		if (user == null) 
			return UserGroup.None;
		else if (user.getUsergroup() == 0)
			return UserGroup.Admin;
		else
			return UserGroup.Guest;
    }

	
    public void insert(User user) {
    	String sql = "INSERT INTO USER (USERNAME, PASSWORD, USERGROUP) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql,  
				user.getUsername(), user.getPassword(), user.getUsergroup());
	}
}
