package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subnet")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Subnet {

	@Id
	private String subnetId;
	private String subnetName;
	private String subnetType;
	private String subnetCidr;
	
	public Subnet() {
		super();
	}

	public Subnet(String subnetName, String subnetType, String subnetCidr) {
		super();
		this.subnetName = subnetName;
		this.subnetType = subnetType;
		this.subnetCidr = subnetCidr;
	}

	public Subnet(String subnetId, String subnetName, String subnetType, String subnetCidr) {
		super();
		this.subnetId = subnetId;
		this.subnetName = subnetName;
		this.subnetType = subnetType;
		this.subnetCidr = subnetCidr;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	public String getSubnetName() {
		return subnetName;
	}

	public void setSubnetName(String subnetName) {
		this.subnetName = subnetName;
	}

	public String getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(String subnetType) {
		this.subnetType = subnetType;
	}

	public String getSubnetCidr() {
		return subnetCidr;
	}

	public void setSubnetCidr(String subnetCidr) {
		this.subnetCidr = subnetCidr;
	}

	@Override
	public String toString() {
		return "Subnet [subnetId=" + subnetId + ", subnetName=" + subnetName + ", subnetType=" + subnetType
				+ ", subnetCidr=" + subnetCidr + "]";
	}
	
}
