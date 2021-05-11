package com.au.aums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;
import com.au.aums.service.TrendService;


@Component
@Service
@Transactional
@Repository
public class TrendServiceImpl implements TrendService {

	@Autowired
	OppurtunityRepository opp;

	@Override
	public List<SkillDTO> skill() {
		return opp.countSkill();
	}

	@Override
	public List<ClientDTO> client() {
		return opp.countClient();
	}

	@Override
	public List<LocationDTO> location() {
		return opp.countLocation();
	}

	@Override
	public List<DescriptionDTO> description() {
		return opp.countDescription();
	}

}
