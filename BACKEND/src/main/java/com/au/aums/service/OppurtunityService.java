
package com.au.aums.service;

import java.util.List;

import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.OppurtunityDTO;

public interface OppurtunityService {
	
	
	Oppurtunities addOppurtunity(OppurtunityDTO oppDTO);
	Oppurtunities updateOppurtunity(OppurtunityDTO oppDTO);
	List<Oppurtunities> getAll();
	Oppurtunities getOppurtunity(int keyword);
	String deleteBy(Integer keyword);
}
