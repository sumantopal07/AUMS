package com.au.aums.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.service.OppurtunityService;
import com.au.aums.service.UserService;

@Service
@Transactional
public class OppurtunityServiceImpl implements OppurtunityService {

	@Autowired
	OppurtunityRepository oppRepository;
	
	@Autowired
	UserService userService;

	@Override
	public Oppurtunities addOppurtunity(OppurtunityDTO oppDTO) {
		Oppurtunities opp = new Oppurtunities();

		opp.setClient(oppDTO.getClient());
		opp.setDate(oppDTO.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setUser(userService.getUser(oppDTO.getEmail()));
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		return oppRepository.save(opp);
	}
	@Override
	public Oppurtunities updateOppurtunity(OppurtunityDTO oppDTO) {
		Oppurtunities opp = getOppurtunity(oppDTO.getId());
		opp.setClient(oppDTO.getClient());
		opp.setDate(oppDTO.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setUser(userService.getUser(oppDTO.getEmail()));
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		return oppRepository.save(opp);
	}


	@Override
	public List<Oppurtunities> getAll() {
		return oppRepository.findAll();
	}

	@Override
	public Oppurtunities getOppurtunity(int keyword) {
		return oppRepository.findByOppId(keyword);
	}

	@Override
	public String deleteBy(Integer keyword) {
		oppRepository.deleteById(oppRepository.findByOppId(keyword).getOppId());
		return "Success";
	}

}
