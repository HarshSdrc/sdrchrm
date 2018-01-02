/**
 * 
 */
package org.sdrc.hrm.repository;

import org.sdrc.hrm.domain.EmployeeDetails;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface EmployeeRepository {

	EmployeeDetails findByEmployeeCode(String empCode);

}
