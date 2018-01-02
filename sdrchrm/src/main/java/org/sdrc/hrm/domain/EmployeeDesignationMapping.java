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

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Entity
public class EmployeeDesignationMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeDesignationId;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private TypeDetail designationId;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private EmployeeDetails  employeeId;
	
	@Column(nullable=false)
	private boolean isLive;
	
	@Column(nullable=false)
	private String createdBy;
	
	@CreationTimestamp
	@Column(nullable=false)
	private Timestamp createdDate;
	
	private String updatedBy;
	
	@UpdateTimestamp
	private Timestamp updatedDate;
	
	public int getEmployeeDesignationId() {
		return employeeDesignationId;
	}

	public void setEmployeeDesignationId(int employeeDesignationId) {
		this.employeeDesignationId = employeeDesignationId;
	}

	public TypeDetail getDesignationId() {
		return designationId;
	}

	public void setDesignationId(TypeDetail designationId) {
		this.designationId = designationId;
	}

	public EmployeeDetails getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeDetails employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
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
