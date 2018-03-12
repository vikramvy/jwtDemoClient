package com.jwt.client.model;

public class TokenHolder {
	
	private String userToken;
	
	public TokenHolder(String token)
	{
		this.userToken = token;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

}
