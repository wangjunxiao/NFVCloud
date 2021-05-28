package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tenant_sfc")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class TenantSfc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tenantSfcId;
	private Integer tenantId;
	private String sfcId;
	
	public TenantSfc() {
		super();
	}

	public TenantSfc(Integer tenantId, String sfcId) {
		super();
		this.tenantId = tenantId;
		this.sfcId = sfcId;
	}

	public TenantSfc(Integer tenantSfcId, Integer tenantId, String sfcId) {
		super();
		this.tenantSfcId = tenantSfcId;
		this.tenantId = tenantId;
		this.sfcId = sfcId;
	}

	public Integer getTenantSfcId() {
		return tenantSfcId;
	}

	public void setTenantSfcId(Integer tenantSfcId) {
		this.tenantSfcId = tenantSfcId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getSfcId() {
		return sfcId;
	}

	public void setSfcId(String sfcId) {
		this.sfcId = sfcId;
	}

	@Override
	public String toString() {
		return "TenantSfc [tenantSfcId=" + tenantSfcId + ", tenantId=" + tenantId + ", sfcId=" + sfcId + "]";
	}
	
}
