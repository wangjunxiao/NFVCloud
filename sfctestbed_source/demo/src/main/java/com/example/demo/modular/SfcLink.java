package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sfc_link")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SfcLink {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sfcLinkId;
	private String sfcId;
	private String linkId;
	
	public SfcLink() {
		super();
	}

	public SfcLink(String sfcId, String linkId) {
		super();
		this.sfcId = sfcId;
		this.linkId = linkId;
	}

	public SfcLink(Integer sfcLinkId, String sfcId, String linkId) {
		super();
		this.sfcLinkId = sfcLinkId;
		this.sfcId = sfcId;
		this.linkId = linkId;
	}

	public Integer getSfcLinkId() {
		return sfcLinkId;
	}

	public void setSfcLinkId(Integer sfcLinkId) {
		this.sfcLinkId = sfcLinkId;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	@Override
	public String toString() {
		return "SfcLink [sfcLinkId=" + sfcLinkId + ", sfcId=" + sfcId + ", linkId=" + linkId + "]";
	}
	
	
}
