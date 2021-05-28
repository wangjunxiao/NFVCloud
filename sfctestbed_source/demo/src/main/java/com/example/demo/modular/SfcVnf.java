package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sfc_vnf")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SfcVnf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sfcVnfId;
	private String sfcId;
	private String vnfId;
	
	public SfcVnf() {
		super();
	}

	public SfcVnf(String sfcId, String vnfId) {
		super();
		this.sfcId = sfcId;
		this.vnfId = vnfId;
	}

	public Integer getSfcVnfId() {
		return sfcVnfId;
	}

	public void setSfcVnfId(Integer sfcVnfId) {
		this.sfcVnfId = sfcVnfId;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	public String getVnfId() {
		return vnfId;
	}

	public void setVnfId(String vnfId) {
		this.vnfId = vnfId;
	}

	@Override
	public String toString() {
		return "SfcVnf [sfcVnfId=" + sfcVnfId + ", sfcId=" + sfcId + ", vnfId=" + vnfId + "]";
	}
	
}
