/**
 * 
 */
package org.sdrc.hrm.model;

import java.sql.Timestamp;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public class TypeDetailModel {
	
	private Integer id;

	private String name;

	private int typeId;
	
	private Timestamp createdDate;
	
	private Timestamp updatedDate;

	private Integer orderLevel;
	
	private String description;

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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
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