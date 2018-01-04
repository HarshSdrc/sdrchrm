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
 * @author Subham Ashish (subham@sdrc.co.in)
 *	16-May-2017
 * 
 */

@Entity
@Table(name="course_enrollment")
public class CourseEnrollment {
	
	@Column(name ="course_enroll_id_pk")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="course_name_fk")
	private TypeDetail courseName;
	
	@ManyToOne
	@JoinColumn(name="course_code_fk")
	private CourseAnnouncement courseCode;
	//trainee name who have enrolled(sent email)
	//sepearted by comma
	@ManyToOne
	@JoinColumn(name="trainee_name_fk")
	private EmployeeDetails traineeName;
	

	public Integer getId() {
		return id;
	}

	public TypeDetail getCourseName() {
		return courseName;
	}

	public void setCourseName(TypeDetail courseName) {
		this.courseName = courseName;
	}

	public CourseAnnouncement getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(CourseAnnouncement courseCode) {
		this.courseCode = courseCode;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmployeeDetails getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(EmployeeDetails traineeName) {
		this.traineeName = traineeName;
	}


}
