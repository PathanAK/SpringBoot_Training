package com.example.userService.user;

public class UserData {
	
	private int uid;
	private String uname;
	private String address;
	
	public UserData(int uid, String uname, String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.address = address;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
