package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sfc_instance")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SfcInstance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sfcInstanceId;
	private String sfcId;
	private String instanceId;
	
	public SfcInstance() {
		super();
	}

	public SfcInstance(Integer sfcInstanceId, String sfcId, String instanceId) {
		super();
		this.sfcInstanceId = sfcInstanceId;
		this.sfcId = sfcId;
		this.instanceId = instanceId;
	}

	public Integer getSfcInstanceId() {
		return sfcInstanceId;
	}

	public void setSfcInstanceId(Integer sfcInstanceId) {
		this.sfcInstanceId = sfcInstanceId;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public String toString() {
		return "SfcInstance [sfcInstanceId=" + sfcInstanceId + ", sfcId=" + sfcId + ", instanceId=" + instanceId + "]";
	}
	
}
