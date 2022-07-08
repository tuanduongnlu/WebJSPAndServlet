package model;

import java.util.Date;

import utils.DateHelper;

public class User {
	public int id ;
	public String userName ;
	public String password ;
	public String phone;
	public String adress;
	public String email;
	public String activity ;
	public Date createDate ;
	
	public User() {
		super();
	}

	public User(String userName, String password, String phone,  String adress,
			String email, String activity,Date createDate) {
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.adress = adress;
		this.email = email;
		this.activity = activity;
		this.createDate =createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

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
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCreateDate() {
		return DateHelper.toString(createDate);
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
