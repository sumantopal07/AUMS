
package com.au.aums.services;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.dao.UserRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.model.User;
import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.service.OppurtunityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.Mockito.times;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OppurtunititesServicesTest {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OppurtunityService oppService;

	@MockBean
	private OppurtunityRepository oppRepository;

	@MockBean
	private UserRepository userRepository;

	static Logger log = LoggerFactory.getLogger(OppurtunititesServicesTest.class);

	@Test
	public void addOppurtunity() throws Exception {

		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);

		Oppurtunities opp = new Oppurtunities();
		opp.setClient(oppDTO.getClient());
		opp.setDate(opp.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		User u = new User();
		u.setEmail(oppDTO.getEmail());
		u.setUserId(1);
		opp.setUser(u);
		opp.setMinExp(oppDTO.getMinExp());
		opp.setOppId(1);
		opp.setSkill(oppDTO.getSkill());

		List<User> LIST = new ArrayList<User>();
		LIST.add(u);
 
		when(oppRepository.findByOppId(1)).thenReturn(opp);
		when(userRepository.findByEmail(oppDTO.getEmail())).thenReturn(LIST);

		when(oppRepository.save(opp)).thenReturn(opp);
		log.info(opp.toString());
		log.info(oppRepository.save(opp).toString());

		oppService.addOppurtunity(oppDTO);
		verify(oppRepository, times(1)).save(opp);

	}

	@Test
	public void updateOppurtunity() throws Exception {

		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setDate("1999-02-22");
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);
		oppDTO.setId(1);

		Oppurtunities opp = new Oppurtunities();
		opp.setClient(oppDTO.getClient());
		opp.setDate(opp.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		User u = new User();
		u.setEmail(oppDTO.getEmail());
		u.setUserId(1);
		opp.setUser(u);
		opp.setMinExp(oppDTO.getMinExp());
		opp.setOppId(1);
		opp.setSkill(oppDTO.getSkill());

		List<User> LIST = new ArrayList<User>();
		LIST.add(u);

		when(oppRepository.findByOppId(1)).thenReturn(opp);
		when(userRepository.findByEmail(oppDTO.getEmail())).thenReturn(LIST);

		when(oppRepository.save(opp)).thenReturn(opp);

		oppService.updateOppurtunity(oppDTO);
		verify(oppRepository).save(opp);

	}

	@Test
	public void get() throws Exception {
		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setDate("1999-02-22");
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);
		oppDTO.setId(1);

		Oppurtunities opp = new Oppurtunities();
		opp.setClient(oppDTO.getClient());
		opp.setDate(opp.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		User u = new User();
		u.setEmail(oppDTO.getEmail());
		u.setUserId(1);
		opp.setUser(u);
		opp.setMinExp(oppDTO.getMinExp());
		opp.setOppId(1);
		opp.setSkill(oppDTO.getSkill());

		List<Oppurtunities> list = new ArrayList<Oppurtunities>();
		list.add(opp);

		when(oppRepository.findAll()).thenReturn(list);

		assertArrayEquals(oppService.getAll().toArray(), list.toArray());
	}

	@Test
	public void deleteBy() throws Exception {
		OppurtunityDTO oppDTO = new OppurtunityDTO();
		oppDTO.setClient("Prudential");
		oppDTO.setEmail("a@gmail.com");
		oppDTO.setDescription("SDE1");
		oppDTO.setDemand(1);
		oppDTO.setDate("1999-02-22");
		oppDTO.setLocation("Mumbai");
		oppDTO.setSkill("Microservices");
		oppDTO.setMinExp(11);
		oppDTO.setId(1);

		Oppurtunities opp = new Oppurtunities();
		opp.setClient(oppDTO.getClient());
		opp.setDate(opp.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		User u = new User();
		u.setEmail(oppDTO.getEmail());
		u.setUserId(1);
		opp.setUser(u);
		opp.setMinExp(oppDTO.getMinExp());
		opp.setOppId(1);
		opp.setSkill(oppDTO.getSkill());
		
		
		doNothing().when(oppRepository).deleteById(1);
		when(oppRepository.findByOppId(1)).thenReturn(opp);
		oppService.deleteBy(1);
		verify(oppRepository,times(1)).deleteById(1);
	}

}
