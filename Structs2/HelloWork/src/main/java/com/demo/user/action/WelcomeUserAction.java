package com.demo.user.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class WelcomeUserAction extends ActionSupport{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	// all struts login here
	@Override
	public String execute() {
		return "SUCCESS";
	}

}
