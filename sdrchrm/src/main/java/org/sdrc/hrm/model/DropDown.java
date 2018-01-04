package org.sdrc.hrm.model;

import java.util.List;


public class DropDown {
	
	private List<EmployeeModel> employeeModel;

	private Integer status;
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<EmployeeModel> getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(List<EmployeeModel> employeeModel) {
		this.employeeModel = employeeModel;
	}

	
	

}
