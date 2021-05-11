package com.au.aums.security;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.au.aums.dao.UserRepository;
import com.au.aums.enums.Role;
import com.au.aums.model.User;
import com.au.aums.model.dto.LoginResponseDTO;
import com.au.aums.model.dto.UserDTO;
import com.au.aums.service.OppurtunityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtTokenProviderServiceTest {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private JwtTokenProviderService jwtTokenProviderService;

	static Logger log = LoggerFactory.getLogger(JwtTokenProviderServiceTest.class);

	@Test
	public void LoadingUser() throws Exception {

		UserDetails u = org.springframework.security.core.userdetails.User
                .withUsername("a@gmail.com")
                .password("1234")
                .authorities(Role.ROLE_ADMIN)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
		List<User> list1 = new ArrayList<User>();
		User x = new User();
		x.setEmail("a@gmail.com");
		x.setUserId(1);
		list1.add(x);
		when(userRepository.findByEmail("a@gmail.com")).thenReturn(list1);
		assertEquals(userDetailsService.loadUserByUsername("a@gmail.com"), u);
	}
	
}
