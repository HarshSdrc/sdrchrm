/**
 * 
 */
package org.sdrc.hrm.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *	This entity class will contain the record of device assignment to users
 */

@Entity
public class EmployeeDeviceMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeDeviceMappingId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false)
	private DeviceDetails deviceId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false)
	private EmployeeDetails  employeeId;
	
	@Column(nullable=false,columnDefinition = "boolean default TRUE")
	private boolean isAssigned;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp asssignedDate;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false)
	private TypeDetail assignedBy;
	
	
	@Column(nullable=false)
	private String assigingDescription;
	
	@Column(nullable=false,columnDefinition = "boolean default FALSE")
	private boolean isReturned;
	
	@JsonIgnore
	@UpdateTimestamp
	private Timestamp returnedDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private TypeDetail returnedTo;
	
	@Column(nullable=true)
	private String remarks;
	
	
	@Column(nullable = false)
	private String createdBy;

	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp createdDate;

	private String updatedBy;

	@UpdateTimestamp
	private Timestamp updatedDate;

	public long getEmployeeDeviceMappingId() {
		return employeeDeviceMappingId;
	}

	public void setEmployeeDeviceMappingId(long employeeDeviceMappingId) {
		this.employeeDeviceMappingId = employeeDeviceMappingId;
	}

	public DeviceDetails getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(DeviceDetails deviceId) {
		this.deviceId = deviceId;
	}

	public EmployeeDetails getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeDetails employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Timestamp getAsssignedDate() {
		return asssignedDate;
	}

	public void setAsssignedDate(Timestamp asssignedDate) {
		this.asssignedDate = asssignedDate;
	}

	public TypeDetail getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(TypeDetail assignedBy) {
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

	public Timestamp getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Timestamp returnedDate) {
		this.returnedDate = returnedDate;
	}

	public TypeDetail getReturnedTo() {
		return returnedTo;
	}

	public void setReturnedTo(TypeDetail returnedTo) {
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
}
