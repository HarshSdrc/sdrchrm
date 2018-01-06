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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Entity
@Table(name = "type_detail")
public class TypeDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "type_id_fk", nullable = false)
	private Type typeId;


	@CreationTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;

	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "order_level")
	private Integer orderLevel;
	
	@Column(name="description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="courseName")
	private List<CourseAnnouncement> course;

	public TypeDetail() {

	}

	public TypeDetail(Integer salutationId) {
		this.id = salutationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getTypeId() {
		return typeId;
	}

	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(Integer orderLevel) {
		this.orderLevel = orderLevel;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
