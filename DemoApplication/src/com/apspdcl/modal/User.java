package com.apspdcl.modal;

import java.io.Serializable;
//Pojo class for User details 
public class User  implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7227132765330456560L;
	
	//setter and getters
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
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	

}
