package com.trunk.controller;

public class Login {
	  public Login(){}
	  
	  private String inputEmail;
	  private String inputPassword;
	  private boolean isAuthenticated;

	  public String getInputPassword() {
		  return inputPassword;
	  }

	  public void setInputPassword(String inputPassword) {
		  this.inputPassword = inputPassword;
	  }

	  public String getInputEmail() {
		  return inputEmail;
	  }

	  public void setInputEmail(String inputEmail) {
		  this.inputEmail = inputEmail;
	  }
	  
	  public void setIsAuthenticated(boolean isAuthenticated){
		  this.isAuthenticated = isAuthenticated;
	  }
	  
	  public boolean isAuthenticated(){
		  return isAuthenticated;
	  }
}