package org.sdrc.hrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private MessageDigestPasswordEncoder messageDigestPasswordEncoder;


	@Override
	public void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

		if (authentication.getCredentials() == null || userDetails.getPassword() == null) {
			throw new BadCredentialsException("Credentials cannot be null");
		}

		 logger.info("<  UserName , {}",authentication.getCredentials());
		 logger.info("<  Password , {}",userDetails.getPassword());
		 logger.info("\n Password Encoded , {}",messageDigestPasswordEncoder.encodePassword(authentication.getName(), (String) authentication.getCredentials()));

		 

		if (!messageDigestPasswordEncoder.encodePassword(authentication.getName(), (String) authentication.getCredentials()).equals(userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Credentials !");
		}
		authentication.setDetails(userDetails);
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
				return userDetailsService.loadUserByUsername(username);
	}

}
