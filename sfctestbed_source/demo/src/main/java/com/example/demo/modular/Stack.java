package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="stack")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Stack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stackId;
	private String stackOsid;
	private String stackType;
	private String stackName;
	private String stackIp;
	private String stackCompute;
	private String stackStatus;
	private String stackTimestamp;
	
	public Stack() {
		super();
	}

	public Stack(String stackOsid, String stackType, String stackName, String stackIp, String stackCompute,
			String stackStatus, String stackTimestamp) {
		super();
		this.stackOsid = stackOsid;
		this.stackType = stackType;
		this.stackName = stackName;
		this.stackIp = stackIp;
		this.stackCompute = stackCompute;
		this.stackStatus = stackStatus;
		this.stackTimestamp = stackTimestamp;
	}

	public Stack(Integer stackId, String stackOsid, String stackType, String stackName, String stackIp,
			String stackCompute, String stackStatus, String stackTimestamp) {
		super();
		this.stackId = stackId;
		this.stackOsid = stackOsid;
		this.stackType = stackType;
		this.stackName = stackName;
		this.stackIp = stackIp;
		this.stackCompute = stackCompute;
		this.stackStatus = stackStatus;
		this.stackTimestamp = stackTimestamp;
	}

	public Integer getStackId() {
		return stackId;
	}

	public void setStackId(Integer stackId) {
		this.stackId = stackId;
	}

	public String getStackOsid() {
		return stackOsid;
	}

	public void setStackOsid(String stackOsid) {
		this.stackOsid = stackOsid;
	}

	public String getStackType() {
		return stackType;
	}

	public void setStackType(String stackType) {
		this.stackType = stackType;
	}

	public String getStackName() {
		return stackName;
	}

	public void setStackName(String stackName) {
		this.stackName = stackName;
	}

	public String getStackIp() {
		return stackIp;
	}

	public void setStackIp(String stackIp) {
		this.stackIp = stackIp;
	}

	public String getStackCompute() {
		return stackCompute;
	}

	public void setStackCompute(String stackCompute) {
		this.stackCompute = stackCompute;
	}

	public String getStackStatus() {
		return stackStatus;
	}

	public void setStackStatus(String stackStatus) {
		this.stackStatus = stackStatus;
	}

	public String getStackTimestamp() {
		return stackTimestamp;
	}

	public void setStackTimestamp(String stackTimestamp) {
		this.stackTimestamp = stackTimestamp;
	}

	@Override
	public String toString() {
		return "Stack [stackId=" + stackId + ", stackOsid=" + stackOsid + ", stackType=" + stackType + ", stackName="
				+ stackName + ", stackIp=" + stackIp + ", stackCompute=" + stackCompute + ", stackStatus=" + stackStatus
				+ ", stackTimestamp=" + stackTimestamp + "]";
	}
	
	
}
