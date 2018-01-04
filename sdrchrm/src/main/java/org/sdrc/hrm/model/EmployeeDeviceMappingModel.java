/**
 * 
 */
package org.sdrc.hrm.model;


/**
 * This model will contain the device history
 * @author Harsh Pratyush
 *
 */
public class EmployeeDeviceMappingModel {
	
	private long employeeDeviceMappingId;
	
	private int deviceId;
	
	private String  employeeName;
	
	private boolean isAssigned;
	
	private String asssignedDate;
	
	private String assignedBy;
	
	private String assigingDescription;
	
	private boolean isReturned;
	
	private String returnedDate;
	
	private String returnedTo;
	
	private String remarks;
	
	private String createdBy;

	private String createdDate;

	private String updatedBy;

	private String updatedDate;

	public long getEmployeeDeviceMappingId() {
		return employeeDeviceMappingId;
	}

	public void setEmployeeDeviceMappingId(long employeeDeviceMappingId) {
		this.employeeDeviceMappingId = employeeDeviceMappingId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public String getAsssignedDate() {
		return asssignedDate;
	}

	public void setAsssignedDate(String asssignedDate) {
		this.asssignedDate = asssignedDate;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssigingDescription() {
		return assigingDescription;
	}

	public void setAssigingDescription(String assigingDescription) {
		this.assigingDescription = assigingDescription;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public String getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}

	public String getReturnedTo() {
		return returnedTo;
	}

	public void setReturnedTo(String returnedTo) {
		this.returnedTo = returnedTo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
