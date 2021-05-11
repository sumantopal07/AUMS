package com.au.aums.security;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
    private IJwtTokenProviderService jwtTokenProviderService;
 
    public JwtTokenFilter(IJwtTokenProviderService jwtTokenProviderService) {
    	log.info("[ENTER] [JwtTokenFilter] contructor"+jwtTokenProviderService.hashCode());
        this.jwtTokenProviderService = jwtTokenProviderService;
        log.info("[EXIT] [JwtTokenFilter] contructor"+jwtTokenProviderService.hashCode());
    }
    
    static Logger log = LoggerFactory.getLogger(JwtTokenFilter.class);
 
    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    	log.info("[ENTER] [JwtTokenFilter] doFilterInternal"+jwtTokenProviderService.hashCode());
    	String token = jwtTokenProviderService.parseToken(httpServletRequest);
    	
    	
        try {
            if (token != null && jwtTokenProviderService.validateToken(token)) {
                Authentication auth = jwtTokenProviderService.validateUserAndGetAuthentication(token);
                log.info("\n[EXIT]  [JwtTokenFilter] doFilterInternal [auth]\n"+auth.toString());
                SecurityContextHolder.getContext().setAuthentication(auth); 
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return ;
            } 
        } catch (Exception ex) { 
            SecurityContextHolder.clearContext();
            return; 
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
        log.info("[EXIT] [JwtTokenFilter] doFilterInternal"+jwtTokenProviderService.hashCode());
    }

}