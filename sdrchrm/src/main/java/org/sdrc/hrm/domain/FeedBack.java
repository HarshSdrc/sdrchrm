package org.sdrc.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedBack {

	@Id
	@Column(name = "feedback_id_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;

	private String response;

	@ManyToOne
	@JoinColumn(name="employee_details_fk")
	private EmployeeDetails empId;

	@ManyToOne
	@JoinColumn(name="feedback_qstn_mst_fk")
	private FeedBackQuestionMaster questions;
	
	@ManyToOne
	@JoinColumn(name="course_name_fk")
	private CourseAnnouncement courseName ;

	public Integer getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public EmployeeDetails getEmpId() {
		return empId;
	}


	public void setEmpId(EmployeeDetails empId) {
		this.empId = empId;
	}


	public FeedBackQuestionMaster getQuestions() {
		return questions;
	}


	public void setQuestions(FeedBackQuestionMaster questions) {
		this.questions = questions;
	}


	public EmployeeDetails getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(EmployeeDetails employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
