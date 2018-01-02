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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	@Column(nullable=false)
	private String roleName;
	
	@Column(nullable=false)
	private String roleCode;
	
	@Column(nullable=false)
	private String createdBy;
	
	@CreationTimestamp
	@Column(nullable=false)
	private Timestamp createdDate;
	
	private String updatedBy;
	
	@UpdateTimestamp
	private Timestamp updatedDate;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
