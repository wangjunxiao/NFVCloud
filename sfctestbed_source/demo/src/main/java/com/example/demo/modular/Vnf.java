package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vnf")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Vnf {

	@Id
	private String vnfId;
	private String vnfName;
	private String vnfType;
	private String vnfStatus;
	private String vnfTimestamp;
	private String vnfConfig;
	
	public Vnf() {
		super();
	}

	public Vnf(String vnfName, String vnfType, String vnfStatus, String vnfTimestamp, String vnfConfig) {
		super();
		this.vnfName = vnfName;
		this.vnfType = vnfType;
		this.vnfStatus = vnfStatus;
		this.vnfTimestamp = vnfTimestamp;
		this.vnfConfig = vnfConfig;
	}

	public Vnf(String vnfId, String vnfName, String vnfType, String vnfStatus, String vnfTimestamp, String vnfConfig) {
		super();
		this.vnfId = vnfId;
		this.vnfName = vnfName;
		this.vnfType = vnfType;
		this.vnfStatus = vnfStatus;
		this.vnfTimestamp = vnfTimestamp;
		this.vnfConfig = vnfConfig;
	}

	public String getVnfId() {
		return vnfId;
	}

	public void setVnfId(String vnfId) {
		this.vnfId = vnfId;
	}

	public String getVnfName() {
		return vnfName;
	}

	public void setVnfName(String vnfName) {
		this.vnfName = vnfName;
	}

	public String getVnfType() {
		return vnfType;
	}

	public void setVnfType(String vnfType) {
		this.vnfType = vnfType;
	}

	public String getVnfStatus() {
		return vnfStatus;
	}

	public void setVnfStatus(String vnfStatus) {
		this.vnfStatus = vnfStatus;
	}

	public String getVnfTimestamp() {
		return vnfTimestamp;
	}

	public void setVnfTimestamp(String vnfTimestamp) {
		this.vnfTimestamp = vnfTimestamp;
	}

	public String getVnfConfig() {
		return vnfConfig;
	}

	public void setVnfConfig(String vnfConfig) {
		this.vnfConfig = vnfConfig;
	}

	@Override
	public String toString() {
		return "Vnf [vnfId=" + vnfId + ", vnfName=" + vnfName + ", vnfType=" + vnfType + ", vnfStatus=" + vnfStatus
				+ ", vnfTimestamp=" + vnfTimestamp + ", vnfConfig=" + vnfConfig + "]";
	}
	
}
