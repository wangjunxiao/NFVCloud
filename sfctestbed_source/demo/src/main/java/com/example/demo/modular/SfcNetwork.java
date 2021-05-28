package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sfc_network")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SfcNetwork {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sfcNetworkId;
	private String sfcId;
	private String networkOsid;
	
	public SfcNetwork() {
		super();
	}

	public SfcNetwork(String sfcId, String networkOsid) {
		super();
		this.sfcId = sfcId;
		this.networkOsid = networkOsid;
	}

	public SfcNetwork(Integer sfcNetworkId, String sfcId, String networkOsid) {
		super();
		this.sfcNetworkId = sfcNetworkId;
		this.sfcId = sfcId;
		this.networkOsid = networkOsid;
	}

	public Integer getSfcNetworkId() {
		return sfcNetworkId;
	}

	public void setSfcNetworkId(Integer sfcNetworkId) {
		this.sfcNetworkId = sfcNetworkId;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	public String getNetworkOsid() {
		return networkOsid;
	}

	public void setNetworkOsid(String networkOsid) {
		this.networkOsid = networkOsid;
	}

	@Override
	public String toString() {
		return "SfcNetwork [sfcNetworkId=" + sfcNetworkId + ", sfcId=" + sfcId + ", networkOsid=" + networkOsid + "]";
	}
	
}
