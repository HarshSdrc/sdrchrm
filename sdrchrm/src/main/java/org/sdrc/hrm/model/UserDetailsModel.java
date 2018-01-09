package org.sdrc.hrm.model;

import java.util.Set;


/**
 * 
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */	
public class UserDetailsModel {

	private String userName;
	
	private String password;
	
	private Set<String> grantedAuthorithies;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getGrantedAuthorithies() {
		return grantedAuthorithies;
	}

	public void setGrantedAuthorithies(Set<String> grantedAuthorithies) {
		this.grantedAuthorithies = grantedAuthorithies;
	}
	
	

}
