/**
 * 
 */
package org.sdrc.hrm.domain;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Entity
public class DeviceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;

	@Column(nullable = false)
	private String deviceName;

	// device code will be auto generated by the system depending on deviceType
	@Column(nullable = false, unique = true)
	private String deviceCode;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String serialNo;
	
	@Column(nullable = false)
	private String firmWare;
	
	@Column(nullable = false)
	private String firmwareVersion;
	
	@Column(nullable = false)
	private String macAdress;
	
	@Column(nullable = false)
	private Date purchaseDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable = false)
	private TypeDetail deviceType;

	@Column(nullable = false, unique = true)
	private String barCode;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String createdBy;

	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp createdDate;

	private String updatedBy;

	@UpdateTimestamp
	private Timestamp updatedDate;
	
	//==== bi-directional mapping=====
	
	@JsonIgnore
	@OneToMany(mappedBy="deviceId")
	List<EmployeeDeviceMapping> employeeDeviceMapping;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public TypeDetail getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(TypeDetail deviceType) {
		this.deviceType = deviceType;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<EmployeeDeviceMapping> getEmployeeDeviceMapping() {
		return employeeDeviceMapping;
	}

	public void setEmployeeDeviceMapping(
			List<EmployeeDeviceMapping> employeeDeviceMapping) {
		this.employeeDeviceMapping = employeeDeviceMapping;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getFirmWare() {
		return firmWare;
	}

	public void setFirmWare(String firmWare) {
		this.firmWare = firmWare;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getMacAdress() {
		return macAdress;
	}

	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
