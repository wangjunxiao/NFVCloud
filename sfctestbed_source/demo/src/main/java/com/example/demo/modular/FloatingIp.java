package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="floatingip")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class FloatingIp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer floatingIpId;
	private String floatingIpAddr;
	private String floatingIpStatus;
	private String floatingIpOsid;
	
	public FloatingIp() {
		super();
	}

	public FloatingIp(String floatingIpAddr, String floatingIpStatus, String floatingIpOsid) {
		super();
		this.floatingIpAddr = floatingIpAddr;
		this.floatingIpStatus = floatingIpStatus;
		this.floatingIpOsid = floatingIpOsid;
	}

	public FloatingIp(Integer floatingIpId, String floatingIpAddr, String floatingIpStatus, String floatingIpOsid) {
		super();
		this.floatingIpId = floatingIpId;
		this.floatingIpAddr = floatingIpAddr;
		this.floatingIpStatus = floatingIpStatus;
		this.floatingIpOsid = floatingIpOsid;
	}

	public Integer getFloatingIpId() {
		return floatingIpId;
	}

	public void setFloatingIpId(Integer floatingIpId) {
		this.floatingIpId = floatingIpId;
	}

	public String getFloatingIpAddr() {
		return floatingIpAddr;
	}

	public void setFloatingIpAddr(String floatingIpAddr) {
		this.floatingIpAddr = floatingIpAddr;
	}

	public String getFloatingIpStatus() {
		return floatingIpStatus;
	}

	public void setFloatingIpStatus(String floatingIpStatus) {
		this.floatingIpStatus = floatingIpStatus;
	}

	public String getFloatingIpOsid() {
		return floatingIpOsid;
	}

	public void setFloatingIpOsid(String floatingIpOsid) {
		this.floatingIpOsid = floatingIpOsid;
	}

	@Override
	public String toString() {
		return "FloatingIp [floatingIpId=" + floatingIpId + ", floatingIpAddr=" + floatingIpAddr + ", floatingIpStatus="
				+ floatingIpStatus + ", floatingIpOsid=" + floatingIpOsid + "]";
	}
	
	
	
}
