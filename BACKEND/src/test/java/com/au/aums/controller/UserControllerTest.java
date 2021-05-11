package com.au.aums.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.dao.UserRepository;
import com.au.aums.enums.Role;
import com.au.aums.model.User;
import com.au.aums.model.dto.LoginResponseDTO;
import com.au.aums.model.dto.UserDTO;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
	@Autowired
	MockMvc mockMvc;

	
	
	@Autowired
	UserService userService;
	

	@Autowired
	IJwtTokenProviderService jwtTokenProviderService;
	
	@MockBean
	UserRepository userRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	String url = "/api/restriction/";

	@MockBean
	private OppurtunityRepository opp;

	static Logger log = LoggerFactory.getLogger(UserControllerTest.class);

    @Test
    public void Success() throws Exception {
    	UserDTO user = new UserDTO();
    	user.setEmail("sumantopal07@gmail.com");
    	
    	User resUser = new User();
    	resUser.setEmail("sumantopal07@gmail.com");
    	resUser.setUserId(1);
    	
    	List<User> u = new ArrayList<User>();
    	u.add(resUser);
		
    	String  token = jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN);
    	
    	LoginResponseDTO l = new LoginResponseDTO();
    	l.setAccessToken(jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN));
		l.setEmail(user.getEmail());
		when(userRepository.findByEmail("sumantopal07@gmail.com")).thenReturn(u);
		
		MvcResult mvcResult = mockMvc.perform(post("/api/allowed/login")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk()).andReturn(); 
		
		mockMvc.perform(get("/api/restriction/client")
                .contentType("application/json")
                .header("Authorization", "Bearer "+token))
                .andExpect(status().isOk()).andReturn(); 
 
    }
    
    
    
//    @Test
//    public void Failure() throws Exception {
//    	UserDTO user = new UserDTO();
//    	user.setEmail("fakeEmail@gmail.com");
//    	
//    	
//        List <User> emptyList= new ArrayList<User>();
//        
//        when(userRepository.findByEmail("fakeEmail@gmail.com")).thenReturn(null);
//        mockMvc.perform(post("/api/allowed/login")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().is4xxClientError()).andReturn(); 
//
//    }

	

}