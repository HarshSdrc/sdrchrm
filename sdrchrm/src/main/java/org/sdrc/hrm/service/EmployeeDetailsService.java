/**
 * 
 */
package org.sdrc.hrm.service;

import org.sdrc.hrm.model.EmployeeModel;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface EmployeeDetailsService {

	
	public EmployeeModel findEmployeeByCode(String empCode);
}
