package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sfc")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Sfc {

	@Id
	private String sfcId;
	private String sfcName;
	private String sfcType;
	private String sfcStatus;
	private String sfcTimestamp;
	private String sfcIngress;
	private String sfcEgress;
	private String sfcBandwidth;
	private String sfcDelay;
	private String sfcReliability;
	
	public Sfc() {
		super();
	}

	public Sfc(String sfcName, String sfcType, String sfcStatus, String sfcTimestamp, String sfcIngress,
			String sfcEgress, String sfcBandwidth, String sfcDelay, String sfcReliability) {
		super();
		this.sfcName = sfcName;
		this.sfcType = sfcType;
		this.sfcStatus = sfcStatus;
		this.sfcTimestamp = sfcTimestamp;
		this.sfcIngress = sfcIngress;
		this.sfcEgress = sfcEgress;
		this.sfcBandwidth = sfcBandwidth;
		this.sfcDelay = sfcDelay;
		this.sfcReliability = sfcReliability;
	}

	public Sfc(String sfcId, String sfcName, String sfcType, String sfcStatus, String sfcTimestamp, String sfcIngress,
			String sfcEgress, String sfcBandwidth, String sfcDelay, String sfcReliability) {
		super();
		this.sfcId = sfcId;
		this.sfcName = sfcName;
		this.sfcType = sfcType;
		this.sfcStatus = sfcStatus;
		this.sfcTimestamp = sfcTimestamp;
		this.sfcIngress = sfcIngress;
		this.sfcEgress = sfcEgress;
		this.sfcBandwidth = sfcBandwidth;
		this.sfcDelay = sfcDelay;
		this.sfcReliability = sfcReliability;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	public String getSfcName() {
		return sfcName;
	}

	public void setSfcName(String sfcName) {
		this.sfcName = sfcName;
	}

	public String getSfcType() {
		return sfcType;
	}

	public void setSfcType(String sfcType) {
		this.sfcType = sfcType;
	}

	public String getSfcStatus() {
		return sfcStatus;
	}

	public void setSfcStatus(String sfcStatus) {
		this.sfcStatus = sfcStatus;
	}

	public String getSfcTimestamp() {
		return sfcTimestamp;
	}

	public void setSfcTimestamp(String sfcTimestamp) {
		this.sfcTimestamp = sfcTimestamp;
	}

	public String getSfcIngress() {
		return sfcIngress;
	}

	public void setSfcIngress(String sfcIngress) {
		this.sfcIngress = sfcIngress;
	}

	public String getSfcEgress() {
		return sfcEgress;
	}

	public void setSfcEgress(String sfcEgress) {
		this.sfcEgress = sfcEgress;
	}

	public String getSfcBandwidth() {
		return sfcBandwidth;
	}

	public void setSfcBandwidth(String sfcBandwidth) {
		this.sfcBandwidth = sfcBandwidth;
	}

	public String getSfcDelay() {
		return sfcDelay;
	}

	public void setSfcDelay(String sfcDelay) {
		this.sfcDelay = sfcDelay;
	}

	public String getSfcReliability() {
		return sfcReliability;
	}

	public void setSfcReliability(String sfcReliability) {
		this.sfcReliability = sfcReliability;
	}

	@Override
	public String toString() {
		return "Sfc [sfcId=" + sfcId + ", sfcName=" + sfcName + ", sfcType=" + sfcType + ", sfcStatus=" + sfcStatus
				+ ", sfcTimestamp=" + sfcTimestamp + ", sfcIngress=" + sfcIngress + ", sfcEgress=" + sfcEgress
				+ ", sfcBandwidth=" + sfcBandwidth + ", sfcDelay=" + sfcDelay + ", sfcReliability=" + sfcReliability
				+ "]";
	}
	
}
