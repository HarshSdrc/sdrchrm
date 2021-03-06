/**
 * 
 */
package org.sdrc.hrm.service;

import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.model.EmployeeModel;
import org.sdrc.hrm.repository.EmployeeRepository;
import org.sdrc.hrm.util.DomainToModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	DomainToModelConverter  domainToModelConverter;

	/* (non-Javadoc)
	 * @see org.sdrc.mis.service.EmployeeDetailsService#findEmployeeByCode(java.lang.String)
	 */
	@Override
	public EmployeeModel findEmployeeByCode(String empCode) {
		
		EmployeeDetails employeeDetails = employeeRepository.findByEmployeeCode(empCode);
		return domainToModelConverter.employeeDomainToModel(employeeDetails);
	}

}
