package com.pppw.SpringWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.pppw.SpringWebApp.model.User;

public class UserDaoJDBC implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDaoJDBC(DataSource userdataSource) {
        jdbcTemplate = new JdbcTemplate(userdataSource);
    }
	
	public boolean isValidUser(String username, String password) {		
		//String sql = "SELECT * FROM USER WHERE USERNAME=" + username;
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";		
		/*User user = jdbcTemplate.query(sql, 
				new ResultSetExtractor<User>() { 
	            //@Override
			    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
			    	if (rs.next()) {
			    		System.out.println(rs.getString("username"));
			    		System.out.println(rs.getString("password"));
			    		System.out.println(rs.getInt("usergroup"));
			    		User user = new User();
			    		user.setUsername(rs.getString("username"));
			    		user.setPassword(rs.getString("password"));
			    		user.setUsergroup(rs.getInt("usergroup"));
			    		return user;
			    	}
	            return null;
			    }
		});*/
		

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
		
		if (user != null && user.getUsername().equals(password))			
			return true;
		else
			return false;
	}
    public UserGroup getUserGroup(String username) {
    	return UserGroup.Admin;
    }
}
