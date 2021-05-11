package com.au.aums.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.au.aums.dao.UserRepository;
import com.au.aums.enums.Role;
import com.au.aums.model.User;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository secureUserRepository;
    static Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    public MyUserDetailsService(UserRepository secureUserRepository) { 
    	log.info("[ENTER] [MyUserDetailsService] contructor");
        this.secureUserRepository = secureUserRepository;
        log.info("[EXIT] [MyUserDetailsService] contructor");
    }
 
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	log.info("[ENTER] [MyUserDetailsService] loadUserByUsername"+email);
        final User user = secureUserRepository.findByEmail(email).get(0);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }
        log.info("[EXIT] [MyUserDetailsService] loadUserByUsername"+email);
        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password("1234")
                .authorities(Role.ROLE_ADMIN)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}