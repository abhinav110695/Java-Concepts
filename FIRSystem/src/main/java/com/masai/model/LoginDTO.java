package com.masai.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {
	
	private Integer userId;
	@NotNull(message ="Password cannot be null.")
	private String password;
	
}
