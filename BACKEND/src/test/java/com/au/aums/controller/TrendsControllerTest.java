
package com.au.aums.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.dao.UserRepository;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser("spring")
class TrendsControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserService userService;

	@MockBean
	IJwtTokenProviderService jwtTokenProviderService;

	@MockBean
	UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	String url = "/api/restriction/";

	@MockBean
	private OppurtunityRepository opp;

	static Logger log = LoggerFactory.getLogger(TrendsControllerTest.class);

	@Test
	public void Trends() throws Exception {

		MvcResult mvcResultClient = mockMvc.perform(get("/api/restriction/client").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		MvcResult mvcResultLocation = mockMvc.perform(get("/api/restriction/location").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		MvcResult mvcResultDescription = mockMvc
				.perform(get("/api/restriction/description").contentType("application/json")).andExpect(status().isOk())
				.andReturn();
		MvcResult mvcResultSkill = mockMvc.perform(get("/api/restriction/skill").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
	}

}