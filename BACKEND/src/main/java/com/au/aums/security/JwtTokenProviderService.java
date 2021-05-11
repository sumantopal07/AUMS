package com.au.aums.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.au.aums.enums.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenProviderService implements IJwtTokenProviderService {

	@Value("${jwt.secret}")
    private String secretKey;
 
    private long validityInMilliseconds = 3600000; // 1h
    
    static Logger log = LoggerFactory.getLogger(JwtTokenProviderService.class);

    @Autowired
    private MyUserDetailsService myUserDetailsService;
 
    @PostConstruct
    protected void init() {
    	log.info("[ENTER] [JwtTokenProviderService] init");
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        log.info("[EXIT] [JwtTokenProviderService] init"+secretKey);
    }

    public JwtTokenProviderService(MyUserDetailsService myUserDetailsService) {
    	log.info("[ENTER] [JwtTokenProviderService] constructor"+myUserDetailsService.hashCode());
        this.myUserDetailsService = myUserDetailsService;
        log.info("[EXIT] [JwtTokenProviderService] constructor"+myUserDetailsService.hashCode());
    } 

    @Override
    public String createToken(String userName, Role role) {
    	log.info("[ENTER] [JwtTokenProviderService] createToken"+myUserDetailsService.hashCode());
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("auth", role);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        log.info("[EXIT] [JwtTokenProviderService] createToken"+myUserDetailsService.hashCode());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @Override
    public Authentication validateUserAndGetAuthentication(String token) {
    	log.info("[ENTER] [JwtTokenProviderService] validateUserAndGetAuthentication"+token);
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(getUsername(token));
        log.info("exit "+ userDetails);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    @Override
    public String getUsername(String token) {
    	log.info("[ENTER] [JwtTokenProviderService] getUsername"+token);
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    @Override
    public String parseToken(HttpServletRequest req) {
    	log.info("[ENTER] [JwtTokenProviderService] parseToken"+req);
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
        	log.info("[EXIT] [JwtTokenProviderService] parseToken"+req);
            return bearerToken.substring(7);
        }
         
        return null;
    }
 
    @Override
    public boolean validateToken(String token){
    	log.info("[ENTER] [JwtTokenProviderService] validateToken"+token);
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            log.info("[EXIT] [JwtTokenProviderService] validateToken"+token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
}
