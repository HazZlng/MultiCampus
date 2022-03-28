package com.domain;

public class MemberVO {

	private String userId;
	private String passwd;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "LoginVO [userId=" + userId + ", passwd=" + passwd + "]";
	}
	
}
