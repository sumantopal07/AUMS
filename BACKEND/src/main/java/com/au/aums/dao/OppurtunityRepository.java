
package com.au.aums.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;



@Repository
public interface OppurtunityRepository extends JpaRepository<Oppurtunities,Integer>{
	
	
	Oppurtunities findByOppId(int keyword);
	
	@Query("SELECT new com.au.aums.model.dto.SkillDTO(c.skill, COUNT(c.skill)) "
			  + "FROM Oppurtunities AS c GROUP BY c.skill ORDER BY c.skill DESC")
			List<SkillDTO> countSkill();
	
	@Query("SELECT new com.au.aums.model.dto.ClientDTO(c.client, COUNT(c.client)) "
			  + "FROM Oppurtunities AS c GROUP BY c.client ORDER BY c.client DESC")
			List<ClientDTO> countClient();
	
	@Query("SELECT new com.au.aums.model.dto.LocationDTO(c.location, COUNT(c.location)) "
			  + "FROM Oppurtunities AS c GROUP BY c.location ORDER BY c.location DESC")
			List<LocationDTO> countLocation();

	@Query("SELECT new com.au.aums.model.dto.DescriptionDTO(c.description, COUNT(c.description)) "
			  + "FROM Oppurtunities AS c GROUP BY c.description ORDER BY c.description DESC")
			List<DescriptionDTO> countDescription();
	
}
