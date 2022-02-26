package com.example.java_shop_api.user;


public class UserResponse {
	private String message;

	public UserResponse(){
	}

	public  UserResponse(String message) {this.message = message;}

	public String getMessage(){return message;}
	public void setMessage(){this.message = message;}
}
