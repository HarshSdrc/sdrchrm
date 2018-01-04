/**
 * 
 */
package org.sdrc.hrm.repository;

import java.util.List;

import org.sdrc.hrm.domain.EmployeeDetails;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface EmployeeRepository {

	EmployeeDetails findByEmployeeCode(String empCode);

	EmployeeDetails findByEmailIdAndIsLiveTrue(String emailId);

	EmployeeDetails findByemployeeNameAndIsLiveTrue(String traineeName);

	List<EmployeeDetails> findByIsLiveTrue();

}
