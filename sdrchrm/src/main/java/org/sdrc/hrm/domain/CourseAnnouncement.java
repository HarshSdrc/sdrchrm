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
@Table(name = "course_announcement")
public class CourseAnnouncement {

	@Column(name = "courseAnnouncement_id_pk")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "course_code", unique = true)
	private String courseCode;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "start_time")
	private String from;

	@Column(name = "end_time")
	private String to;

	@Column(name = "email")
	private String email;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "course_structure_path")
	private String coursePath;

	@ManyToOne
	@JoinColumn(name = "course_name_fk")
	private TypeDetail courseName;
	
	@ManyToOne
	@JoinColumn(name = "tariner_name_fk")
	private EmployeeDetails trainerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public TypeDetail getCourseName() {
		return courseName;
	}

	public void setCourseName(TypeDetail courseName) {
		this.courseName = courseName;
	}

	public EmployeeDetails getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(EmployeeDetails trainerName) {
		this.trainerName = trainerName;
	}

	public String getCoursePath() {
		return coursePath;
	}

	public void setCoursePath(String coursePath) {
		this.coursePath = coursePath;
	}

}
