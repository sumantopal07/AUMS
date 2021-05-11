package com.au.aums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.enums.Role;
import com.au.aums.model.User;
import com.au.aums.model.dto.CheckUserDTO;
import com.au.aums.model.dto.LoginResponseDTO;
import com.au.aums.model.dto.UserDTO;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private IJwtTokenProviderService jwtTokenProviderService;

	
	@PostMapping(path = "/api/allowed/login")
	public ResponseEntity<LoginResponseDTO> checkUser(@RequestBody UserDTO userDTO) {

		User user = userService.getUser(userDTO.getEmail());
		if (user == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		LoginResponseDTO l = new LoginResponseDTO();
		l.setAccessToken(jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN));
		l.setEmail(user.getEmail());
		return new ResponseEntity<>(l, HttpStatus.OK);

	} 

}
