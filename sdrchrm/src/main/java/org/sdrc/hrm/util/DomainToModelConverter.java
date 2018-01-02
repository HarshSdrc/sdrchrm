/**
 * 
 */
package org.sdrc.hrm.util;

import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.model.EmployeeModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Component
public class DomainToModelConverter {

	
	public EmployeeModel employeeDomainToModel(EmployeeDetails employeeDetails)
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(employeeDetails !=null)
		{
			ObjectMapper objectMapper=new ObjectMapper();
			employeeModel = objectMapper.convertValue(employeeDetails, EmployeeModel.class);
			employeeModel.setGender(employeeDetails.getGender().getName());

		}
		return employeeModel;
	}
}
