package model;

import java.util.Date;

public class Bill {
	private int id;
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhonel;
	private float amount;
	private Date createDate;
	public Bill( int userId, String userName, String userEmail, String userPhonel, float amount,
			Date createDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhonel = userPhonel;
		this.amount = amount;
		this.createDate = createDate;
	}
	public Bill() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhonel() {
		return userPhonel;
	}
	public void setUserPhonel(String userPhonel) {
		this.userPhonel = userPhonel;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
