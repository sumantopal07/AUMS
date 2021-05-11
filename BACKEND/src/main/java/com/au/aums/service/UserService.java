package com.au.aums.service;

import java.util.List;
import java.util.Optional;

import com.au.aums.model.User;

public interface UserService {

	User getUser(String email);

}
