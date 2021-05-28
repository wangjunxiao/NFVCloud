package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="link")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Link {

	@Id
	private String linkId;
	private String linkSrc;
	private String linkDst;
	private String linkStatus;
	private String linkTimestamp;
	
	public Link() {
		super();
	}

	public Link(String linkSrc, String linkDst, String linkStatus, String linkTimestamp) {
		super();
		this.linkSrc = linkSrc;
		this.linkDst = linkDst;
		this.linkStatus = linkStatus;
		this.linkTimestamp = linkTimestamp;
	}

	public Link(String linkId, String linkSrc, String linkDst, String linkStatus, String linkTimestamp) {
		super();
		this.linkId = linkId;
		this.linkSrc = linkSrc;
		this.linkDst = linkDst;
		this.linkStatus = linkStatus;
		this.linkTimestamp = linkTimestamp;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getLinkSrc() {
		return linkSrc;
	}

	public void setLinkSrc(String linkSrc) {
		this.linkSrc = linkSrc;
	}

	public String getLinkDst() {
		return linkDst;
	}

	public void setLinkDst(String linkDst) {
		this.linkDst = linkDst;
	}

	public String getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(String linkStatus) {
		this.linkStatus = linkStatus;
	}

	public String getLinkTimestamp() {
		return linkTimestamp;
	}

	public void setLinkTimestamp(String linkTimestamp) {
		this.linkTimestamp = linkTimestamp;
	}

	@Override
	public String toString() {
		return "Link [linkId=" + linkId + ", linkSrc=" + linkSrc + ", linkDst=" + linkDst + ", linkStatus=" + linkStatus
				+ ", linkTimestamp=" + linkTimestamp + "]";
	}
	
	
	
}
