package com.pppw.SpringWebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pppw.SpringWebApp.dao.UserGroup;

@Entity
@Table(name = "USER")
public class User {
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "USERGROUP")
	private int usergroup;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(int usergroup) {
		this.usergroup = usergroup;
	}
}
