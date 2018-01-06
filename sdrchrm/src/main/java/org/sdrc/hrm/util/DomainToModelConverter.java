/**
 * 
 */
package org.sdrc.hrm.util;

import java.text.SimpleDateFormat;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.domain.EmployeeDeviceMapping;
import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.model.EmployeeDeviceMappingModel;
import org.sdrc.hrm.model.EmployeeModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Component
public class DomainToModelConverter {
	
	private final SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");

	
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
	
	
	public EmployeeDeviceMappingModel employeeDeviceMappintToModel(EmployeeDeviceMapping employeeDeviceMapping)
	{
		EmployeeDeviceMappingModel employeeDeviceMappingModel = new EmployeeDeviceMappingModel();
		
		if(employeeDeviceMapping!=null)
		{
			ObjectMapper objectMapper = new ObjectMapper();
			employeeDeviceMappingModel= objectMapper.convertValue(employeeDeviceMapping, EmployeeDeviceMappingModel.class);
			employeeDeviceMappingModel.setAssignedBy(employeeDeviceMapping.getAssignedBy().getName());
			if(employeeDeviceMapping.isReturned())
			{
			employeeDeviceMappingModel.setReturnedTo(employeeDeviceMapping.getReturnedTo().getName());
			employeeDeviceMappingModel.setReturnedDate(sdf.format(employeeDeviceMapping.getReturnedDate()));
			}
			employeeDeviceMappingModel.setAsssignedDate(sdf.format(employeeDeviceMapping.getAsssignedDate()));
			
			
		}
		return employeeDeviceMappingModel;
	}
}
