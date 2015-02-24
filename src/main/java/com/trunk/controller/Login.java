package com.trunk.controller;

public class Login {
	  public Login(){}
	  
	  private String username;
	  private String password;
	  private boolean isAuthenticated;

	  public String getPassword() {
		  return password;
	  }

	  public void setPassword(String password) {
		  this.password = password;
	  }

	  public String getUsername() {
		  return username;
	  }

	  public void setUsername(String username) {
		  this.username = username;
	  }
	  
	  public void setIsAuthenticated(boolean isAuthenticated){
		  this.isAuthenticated = isAuthenticated;
	  }
	  
	  public boolean isAuthenticated(){
		  return isAuthenticated;
	  }
}