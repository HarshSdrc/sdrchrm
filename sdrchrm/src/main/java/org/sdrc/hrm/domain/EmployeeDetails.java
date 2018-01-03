/**
 * 
 */
package org.sdrc.hrm.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Entity
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	@Column(nullable = false)
	private String employeeName;

	@Email
	@Column(nullable = false, unique = true)
	private String emailId;

	@Column(nullable = false, unique = true)
	private long contactNumber;

	@Column(nullable = true, unique = true)
	private String voterId;

	@Column(nullable = true, unique = true)
	private String pancard;

	@Column(nullable = true, unique = true)
	private String passport;

	@Column(nullable = false, unique = true)
	private String employeeCode;

	@Column(nullable = false)
	private String fatherName;

	@Column(nullable = false)
	private String motherName;

	@Column(nullable = false)
	private boolean isLive;

	@Column(nullable = false)
	private String createdBy;

	@CreationTimestamp
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	private Timestamp createdDate;

	private String updatedBy;

	@UpdateTimestamp
	private Timestamp updatedDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable = false)
	private TypeDetail gender;

	
	@Column(nullable=false)
	private String password;
	
	// == Bi-directinal mapping===//

	@OneToMany(mappedBy = "employeeId")
	@JsonIgnore
	private List<EmployeeRoleMapping> employeeRoleMappings;

	// == Bi-directinal mapping===//
	
	@JsonIgnore
	@OneToMany(mappedBy = "empId")
	private List<FeedBack> feedBack;

	// == Bi-directinal mapping===//
	
	@JsonIgnore
	@OneToMany(mappedBy = "trainerName")
	private List<CourseAnnouncement> course;

	public List<FeedBack> getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(List<FeedBack> feedBack) {
		this.feedBack = feedBack;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeDetail getGender() {
		return gender;
	}

	public void setGender(TypeDetail gender) {
		this.gender = gender;
	}

	public List<EmployeeRoleMapping> getEmployeeRoleMappings() {
		return employeeRoleMappings;
	}

	public void setEmployeeRoleMappings(
			List<EmployeeRoleMapping> employeeRoleMappings) {
		this.employeeRoleMappings = employeeRoleMappings;
	}

}
