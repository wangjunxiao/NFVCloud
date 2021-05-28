package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tenant_quota")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class TenantQuota {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tenantQuotaId;
	private Integer tenantId;
	private Integer quotaId;
	
	public TenantQuota() {
		super();
	}

	public TenantQuota(Integer tenantId, Integer quotaId) {
		super();
		this.tenantId = tenantId;
		this.quotaId = quotaId;
	}

	public TenantQuota(Integer tenantQuotaId, Integer tenantId, Integer quotaId) {
		super();
		this.tenantQuotaId = tenantQuotaId;
		this.tenantId = tenantId;
		this.quotaId = quotaId;
	}

	public Integer getTenantQuotaId() {
		return tenantQuotaId;
	}

	public void setTenantQuotaId(Integer tenantQuotaId) {
		this.tenantQuotaId = tenantQuotaId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(Integer quotaId) {
		this.quotaId = quotaId;
	}

	@Override
	public String toString() {
		return "TenantQuota [tenantQuotaId=" + tenantQuotaId + ", tenantId=" + tenantId + ", quotaId=" + quotaId + "]";
	}
	
}
