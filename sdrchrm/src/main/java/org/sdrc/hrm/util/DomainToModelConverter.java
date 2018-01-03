/**
 * 
 */
package org.sdrc.hrm.util;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.model.DeviceModel;
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
	
	public DeviceModel deviceDomainToModel(DeviceDetails deviceDetails)
	{
		DeviceModel deviceModel= new DeviceModel();
		if(deviceDetails!=null)
		{
			ObjectMapper objectMapper=new ObjectMapper();
			deviceModel = objectMapper.convertValue(deviceDetails, DeviceModel.class);
			deviceModel.setDeviceType(deviceDetails.getDeviceType().getName());
			deviceModel.setDeviceTypeId(deviceDetails.getDeviceType().getId());
		}
		return deviceModel;
	}
}
