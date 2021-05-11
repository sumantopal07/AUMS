package com.au.aums.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;
import com.au.aums.service.TrendService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest	
public class TrendsServicesTest {
	@Autowired
	private ObjectMapper objectMapper;

	

	
	@MockBean
	private OppurtunityRepository opp;
	
	@Autowired
	private TrendService t;

	static Logger log = LoggerFactory.getLogger(TrendsServicesTest.class);
	
	@Test
	public void Skills() throws Exception {
		SkillDTO skill1= new SkillDTO();
		SkillDTO skill2= new SkillDTO("React",1l);
		skill1.setSkill("java");
		skill1.setTotal(2l);
		
		
        List<SkillDTO> skills=new ArrayList<SkillDTO>();
        skills.add(skill1);
        skills.add(skill2);

        when(opp.countSkill()).thenReturn(skills);
        assertArrayEquals(t.skill().toArray(),skills.toArray());
        
        log.info(skill2.getSkill());
        log.info(skill2.getTotal()+"");
      
	}
	@Test
	public void Client() throws Exception {
		ClientDTO c1= new ClientDTO();
		ClientDTO c2= new ClientDTO("Prudential",1l);
		c1.setClient("Morgan Stanley");
		c1.setTotal(2l);
		
		
        List<ClientDTO> clients=new ArrayList<ClientDTO>();
        clients.add(c1);
        clients.add(c2);
        when(opp.countClient()).thenReturn(clients);
        
        log.info(c2.getClient());
        log.info(c2.getTotal()+"");
        
        assertArrayEquals(t.client().toArray(),clients.toArray());
        
	}
	@Test
	public void Location() throws Exception {
		LocationDTO l1= new LocationDTO();
		LocationDTO l2= new LocationDTO("Bangalore",1l);
		l1.setLocation("Gurugram");
		l1.setTotal(2l);
		
		
		
        List<LocationDTO> locations=new ArrayList<LocationDTO>();
        locations.add(l1);
        locations.add(l2);

        when(opp.countLocation()).thenReturn(locations);
        assertArrayEquals(t.location().toArray(),locations.toArray());
        
        log.info(l1.getLocation());
        log.info(l1.getTotal()+"");
        

        
	}
	
	@Test
	public void Description() throws Exception {
		DescriptionDTO l1= new DescriptionDTO();
		DescriptionDTO l2= new DescriptionDTO("SDE1",1l);
		l1.setDescription("SDE2");
		l1.setTotal(2l);
		
		
        List<DescriptionDTO> d=new ArrayList<DescriptionDTO>();
        d.add(l1);
        d.add(l2);

        when(opp.countDescription()).thenReturn(d);
        assertArrayEquals(t.description().toArray(),d.toArray());
        
        log.info(l1.getDescription());
        log.info(l1.getTotal()+"");
        

        
	}
	
	
}



















