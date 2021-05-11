package com.au.aums.model.dto;

public class LoginResponseDTO {
	
	private String accessToken;
	private String email;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginResponseDTO [accessToken=" + accessToken + ", email=" + email + "]";
	}
}
