package com.example.demo.modular;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vtenant")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Vtenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tenantId;
    private String tenantName;
    private String tenantPassword;
    private String tenantRole;
    
	public Vtenant() {
		super();
	}

	public Vtenant(String tenantName, String tenantPassword, String tenantRole) {
		super();
		this.tenantName = tenantName;
		this.tenantPassword = tenantPassword;
		this.tenantRole = tenantRole;
	}

	public Vtenant(Integer tenantId, String tenantName, String tenantPassword, String tenantRole) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantPassword = tenantPassword;
		this.tenantRole = tenantRole;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantPassword() {
		return tenantPassword;
	}

	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = tenantPassword;
	}

	public String getTenantRole() {
		return tenantRole;
	}

	public void setTenantRole(String tenantRole) {
		this.tenantRole = tenantRole;
	}

	@Override
	public String toString() {
		return "Vtenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", tenantPassword=" + tenantPassword
				+ ", tenantRole=" + tenantRole + "]";
	}
    

}
