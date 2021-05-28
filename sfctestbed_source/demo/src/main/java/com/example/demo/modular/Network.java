package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="network")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Network {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer networkId;
	private String networkOsid;
	private String subnetOsid;
	private String subnetCidr;
	private String networkStatus;
	
	public Network() {
		super();
	}

	public Network(String networkOsid, String subnetOsid, String subnetCidr, String networkStatus) {
		super();
		this.networkOsid = networkOsid;
		this.subnetOsid = subnetOsid;
		this.subnetCidr = subnetCidr;
		this.networkStatus = networkStatus;
	}

	public Network(Integer networkId, String networkOsid, String subnetOsid, String subnetCidr, String networkStatus) {
		super();
		this.networkId = networkId;
		this.networkOsid = networkOsid;
		this.subnetOsid = subnetOsid;
		this.subnetCidr = subnetCidr;
		this.networkStatus = networkStatus;
	}

	public Integer getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Integer networkId) {
		this.networkId = networkId;
	}

	public String getNetworkOsid() {
		return networkOsid;
	}

	public void setNetworkOsid(String networkOsid) {
		this.networkOsid = networkOsid;
	}

	public String getSubnetOsid() {
		return subnetOsid;
	}

	public void setSubnetOsid(String subnetOsid) {
		this.subnetOsid = subnetOsid;
	}

	public String getSubnetCidr() {
		return subnetCidr;
	}

	public void setSubnetCidr(String subnetCidr) {
		this.subnetCidr = subnetCidr;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	@Override
	public String toString() {
		return "Network [networkId=" + networkId + ", networkOsid=" + networkOsid + ", subnetOsid=" + subnetOsid
				+ ", subnetCidr=" + subnetCidr + ", networkStatus=" + networkStatus + "]";
	}
	
	
}
