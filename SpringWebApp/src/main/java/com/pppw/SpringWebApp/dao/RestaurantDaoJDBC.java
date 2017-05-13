package com.pppw.SpringWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pppw.SpringWebApp.model.Restaurant;

public class RestaurantDaoJDBC implements RestaurantDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RestaurantDaoJDBC(DataSource userDataSource) {
        jdbcTemplate = new JdbcTemplate(userDataSource);
    }
	//public RestaurantDaoJDBC(DataSource restaurantDataSource) {
    //    jdbcTemplate = new JdbcTemplate(restaurantDataSource);
    //}
	
	public Restaurant get(int ID) {
		String sql = "SELECT * FROM RESTAURANT WHERE ID = ?";
		
		Restaurant restaurant = (Restaurant) jdbcTemplate.queryForObject(
				sql, 
				new Object[] { ID }, 
				new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Restaurant restaurant = new Restaurant();
					restaurant.setName(rs.getString("name"));
					restaurant.setType(rs.getString("type"));
					restaurant.setAddress(rs.getString("address"));
		    		return restaurant;
		    		}
				});
		return restaurant;
	}

	public List<Restaurant> getAll() {
		String sql = "SELECT * FROM RESTAURANT";
		
		List<Restaurant> restaurantList = jdbcTemplate.query(
				sql, 				
				new RowMapper<Restaurant>() {
				public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
					Restaurant restaurant = new Restaurant();
					restaurant.setID(rs.getInt("ID"));
					restaurant.setName(rs.getString("name"));
					restaurant.setType(rs.getString("type"));
					restaurant.setAddress(rs.getString("address"));
		    		return restaurant;
		    		}
				});
		return restaurantList;
	}

	public void insert(Restaurant restaurant) {
		String sql = "INSERT INTO RESTAURANT (ID, NAME, TYPE, ADDRESS) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql,  
				restaurant.getID(), restaurant.getName(), restaurant.getType(), restaurant.getAddress());
	}
	
	public void update(Restaurant restaurant) {
		String sql = "UPDATE RESTAURANT SET ID=?, NAME=?, TYPE=?, ADDRESS=? WHERE ID=?";
		jdbcTemplate.update(sql,  
				restaurant.getID(), restaurant.getName(), restaurant.getType(), restaurant.getAddress());
	}

	public void delete(int ID) {
		String sql = "DELETE FROM RESTAURANT WHERE ID = ?";
	    jdbcTemplate.update(sql, ID);
	}
}
