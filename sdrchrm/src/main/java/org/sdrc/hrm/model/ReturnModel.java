/**
 * 
 */
package org.sdrc.hrm.model;


/**
 * @author Harsh Pratyush(harsh@sdrc.co.in)
 *
 */
public class ReturnModel {
	
	// statusCode = 200 if success else 400
	private int statusCode;
	
	// error message/Success message
	private String message;
	
	// description in case of failure/success 
	private String description;
	
	// return desired object if required
	private Object object;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	

}
