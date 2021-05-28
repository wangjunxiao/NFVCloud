package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vnf_stack")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class VnfStack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vnfStackId;
	private String vnfId;
	private Integer stackId;
	
	public VnfStack() {
		super();
	}

	public VnfStack(String vnfId, Integer stackId) {
		super();
		this.vnfId = vnfId;
		this.stackId = stackId;
	}

	public VnfStack(Integer vnfStackId, String vnfId, Integer stackId) {
		super();
		this.vnfStackId = vnfStackId;
		this.vnfId = vnfId;
		this.stackId = stackId;
	}

	public Integer getVnfStackId() {
		return vnfStackId;
	}

	public void setVnfStackId(Integer vnfStackId) {
		this.vnfStackId = vnfStackId;
	}

	public String getVnfId() {
		return vnfId;
	}

	public void setVnfId(String vnfId) {
		this.vnfId = vnfId;
	}

	public Integer getStackId() {
		return stackId;
	}

	public void setStackId(Integer stackId) {
		this.stackId = stackId;
	}

	@Override
	public String toString() {
		return "VnfStack [vnfStackId=" + vnfStackId + ", vnfId=" + vnfId + ", stackId=" + stackId + "]";
	}
	
}
