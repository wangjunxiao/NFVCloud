package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="instance")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Instance {
	
	@Id
	private String instanceId;
	private String instanceOsid;
	private String instanceName;
	private String instanceType;
	private String instanceIp;		//add a proprity named instance_ip
	private String instanceZone;
	private String instanceStatus;
	
	public Instance() {
		super();
	}

	public Instance(String instanceOsid, String instanceName, String instanceType, String instanceIp,
			String instanceZone, String instanceStatus) {
		super();
		this.instanceOsid = instanceOsid;
		this.instanceName = instanceName;
		this.instanceType = instanceType;
		this.instanceIp = instanceIp;
		this.instanceZone = instanceZone;
		this.instanceStatus = instanceStatus;
	}

	public Instance(String instanceId, String instanceOsid, String instanceName, String instanceType, String instanceIp,
			String instanceZone, String instanceStatus) {
		super();
		this.instanceId = instanceId;
		this.instanceOsid = instanceOsid;
		this.instanceName = instanceName;
		this.instanceType = instanceType;
		this.instanceIp = instanceIp;
		this.instanceZone = instanceZone;
		this.instanceStatus = instanceStatus;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getInstanceOsid() {
		return instanceOsid;
	}

	public void setInstanceOsid(String instanceOsid) {
		this.instanceOsid = instanceOsid;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public String getInstanceIp() {
		return instanceIp;
	}

	public void setInstanceIp(String instanceIp) {
		this.instanceIp = instanceIp;
	}

	public String getInstanceZone() {
		return instanceZone;
	}

	public void setInstanceZone(String instanceZone) {
		this.instanceZone = instanceZone;
	}

	public String getInstanceStatus() {
		return instanceStatus;
	}

	public void setInstanceStatus(String instanceStatus) {
		this.instanceStatus = instanceStatus;
	}

	@Override
	public String toString() {
		return "Instance [instanceId=" + instanceId + ", instanceOsid=" + instanceOsid + ", instanceName="
				+ instanceName + ", instanceType=" + instanceType + ", instanceIp=" + instanceIp + ", instanceZone="
				+ instanceZone + ", instanceStatus=" + instanceStatus + "]";
	}
	
	

}
