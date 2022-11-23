package io.Sheraton.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank(message = "Username no puede estar en blanco")
	private String username;
	@NotBlank(message = "Password no puede estar en blanco")
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
