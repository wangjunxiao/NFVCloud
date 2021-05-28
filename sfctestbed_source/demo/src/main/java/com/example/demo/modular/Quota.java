package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="quota")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Quota {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer quotaId;
	private Integer quotaCpu;
	private Integer quotaRam;
	private Integer quotaDisk;
	private String quotaSfc;
	
	public Quota() {
		super();
	}

	public Quota(Integer quotaCpu, Integer quotaRam, Integer quotaDisk, String quotaSfc) {
		super();
		this.quotaCpu = quotaCpu;
		this.quotaRam = quotaRam;
		this.quotaDisk = quotaDisk;
		this.quotaSfc = quotaSfc;
	}

	public Quota(Integer quotaId, Integer quotaCpu, Integer quotaRam, Integer quotaDisk, String quotaSfc) {
		super();
		this.quotaId = quotaId;
		this.quotaCpu = quotaCpu;
		this.quotaRam = quotaRam;
		this.quotaDisk = quotaDisk;
		this.quotaSfc = quotaSfc;
	}

	public Integer getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(Integer quotaId) {
		this.quotaId = quotaId;
	}

	public Integer getQuotaCpu() {
		return quotaCpu;
	}

	public void setQuotaCpu(Integer quotaCpu) {
		this.quotaCpu = quotaCpu;
	}

	public Integer getQuotaRam() {
		return quotaRam;
	}

	public void setQuotaRam(Integer quotaRam) {
		this.quotaRam = quotaRam;
	}

	public Integer getQuotaDisk() {
		return quotaDisk;
	}

	public void setQuotaDisk(Integer quotaDisk) {
		this.quotaDisk = quotaDisk;
	}

	public String getQuotaSfc() {
		return quotaSfc;
	}

	public void setQuotaSfc(String quotaSfc) {
		this.quotaSfc = quotaSfc;
	}

	@Override
	public String toString() {
		return "Quota [quotaId=" + quotaId + ", quotaCpu=" + quotaCpu + ", quotaRam=" + quotaRam + ", quotaDisk="
				+ quotaDisk + ", quotaSfc=" + quotaSfc + "]";
	}
	
	
	
}
