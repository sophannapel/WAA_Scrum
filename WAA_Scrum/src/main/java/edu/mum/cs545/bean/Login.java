package edu.mum.cs545.bean;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

public class Login implements Serializable{
	
	@NotEmpty(message = "Enter your username")
	private String username;
	@NotEmpty(message = "Enter your password")
	private String password;

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

}
