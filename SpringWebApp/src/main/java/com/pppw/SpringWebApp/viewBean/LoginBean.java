package com.pppw.SpringWebApp.viewBean;

public class LoginBean {
	// the variables' name must be consistent with the login.jsp
    private String userName;
    private String password;
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
}
