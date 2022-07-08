package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	String user;
	String pass;
	String roles;

	public Account() {
		super();
	}

	public Account(String user, String pass, String roles) {
		super();
		this.user = user;
		this.pass = pass;
		this.roles = roles;
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
}
