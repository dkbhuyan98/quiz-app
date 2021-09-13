package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModule {
	@Id
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public UserModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModule(int user_id,String username, String email, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModule [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}
	

}
