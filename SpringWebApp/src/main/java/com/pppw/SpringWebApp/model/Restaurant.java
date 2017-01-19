package com.pppw.SpringWebApp.model;

public class Restaurant {
	private int ID;	
	private String name;
	private String type;
	private String address;
	
	public Restaurant() {}
	public Restaurant(String name, String type, String address) {
		this.name = name;
		this.type = type;
		this.address = address;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
