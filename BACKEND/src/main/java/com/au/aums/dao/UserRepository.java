package com.au.aums.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.aums.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	List<User> findByEmail(String email);
}
