package org.sdrc.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_enrollment")
public class CourseEnrollment {
	
	@Column(name ="course_enroll_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//trainee name who have enrolled(sent email)
	//sepearted by comma
	@ManyToOne
	@JoinColumn(name="trainee_name_fk")
	private EmployeeDetails traineeName;

	public Integer getId() {
		return id;
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
