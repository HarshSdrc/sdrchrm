package org.sdrc.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Subham Ashish (subham@sdrc.co.in) 16-May-2017
 * 
 */

@Entity
@Table(name = "feedback")
public class FeedBack {

	@Id
	@Column(name = "feedback_id_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;

	private String response;

	@ManyToOne
	@JoinColumn(name = "employee_id_fk")
	private EmployeeDetails empId;

	@ManyToOne
	@JoinColumn(name = "feedback_qstns_fk")
	private FeedBackQuestionMaster questions;

	@ManyToOne
	@JoinColumn(name = "course_name_fk")
	private CourseAnnouncement courseName;

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

}
