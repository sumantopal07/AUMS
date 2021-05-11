
package com.au.aums.controller;

import static org.mockito.Mockito.doNothing;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.service.OppurtunityService;
import com.au.aums.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser("spring")
class OppurtunityControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserService userService;

	@MockBean
	IJwtTokenProviderService jwtTokenProviderService;

	@MockBean
	OppurtunityService oppService;

	@Autowired
	private ObjectMapper objectMapper;

	String url = "/api/restriction/";

	@MockBean
	private OppurtunityRepository oppRepository;

	static Logger log = LoggerFactory.getLogger(OppurtunityControllerTest.class);

	@Test
	public void getOppurtunitiesWhenOk() throws Exception {

		List<Oppurtunities> oppList = new ArrayList<Oppurtunities>();
		oppList.add(new Oppurtunities());
		when(oppRepository.findAll()).thenReturn(oppList);
		when(oppService.getAll()).thenReturn(oppList);
		MvcResult mvcResultClient = mockMvc
				.perform(get("/api/restriction/getOppurtunities").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

	}
	@Test
	public void getOppurtunitiesWhenEmpty() throws Exception {
		MvcResult mvcResultClient = mockMvc
				.perform(get("/api/restriction/getOppurtunities").contentType("application/json"))
				.andExpect(status().isBadRequest()).andReturn();

	}
	
	@Test
	public void Delete() throws Exception {
		MvcResult mvcResultClient = mockMvc
				.perform(delete("/api/restriction/delete/1").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

	}
	
	@Test
	public void Add() throws Exception {
		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);
		MvcResult mvcResultClient = mockMvc
				.perform(post("/api/restriction/addOppurtunity").contentType("application/json")
						.content(objectMapper.writeValueAsString(oppDTO)))
				.andExpect(status().isOk()).andReturn();

	}
	
	@Test
	public void Update() throws Exception {
		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setId(1);
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);
		MvcResult mvcResultClient = mockMvc
				.perform(put("/api/restriction/updateOppurtunity").contentType("application/json")
						.content(objectMapper.writeValueAsString(oppDTO)))
				.andExpect(status().isOk()).andReturn();
		//System.out.println(mvcResultClient.getResponse());

	}

}