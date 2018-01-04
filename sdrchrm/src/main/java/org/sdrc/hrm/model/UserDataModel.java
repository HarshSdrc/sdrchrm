/**
 * 
 */
package org.sdrc.hrm.model;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 * This model will conatins the userString and the data to be submitted
 */
public class UserDataModel {
	
	private String userName;
	
	private String password;
	
	private Object submissionObject;
	
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


	public Object getSubmissionObject() {
		return submissionObject;
	}


	public void setSubmissionObject(Object submissionObject) {
		this.submissionObject = submissionObject;
	}
	
	

}
