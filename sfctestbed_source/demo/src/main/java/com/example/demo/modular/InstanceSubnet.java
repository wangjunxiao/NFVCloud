package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="instance_subnet")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InstanceSubnet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer instanceSubnetId;
	private String instanceId;
	private String subnetId;
	
	public InstanceSubnet() {
		super();
	}

	public InstanceSubnet(String instanceId, String subnetId) {
		super();
		this.instanceId = instanceId;
		this.subnetId = subnetId;
	}

	public InstanceSubnet(Integer instanceSubnetId, String instanceId, String subnetId) {
		super();
		this.instanceSubnetId = instanceSubnetId;
		this.instanceId = instanceId;
		this.subnetId = subnetId;
	}

	public Integer getInstanceSubnetId() {
		return instanceSubnetId;
	}

	public void setInstanceSubnetId(Integer instanceSubnetId) {
		this.instanceSubnetId = instanceSubnetId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	@Override
	public String toString() {
		return "InstanceSubnet [instanceSubnetId=" + instanceSubnetId + ", instanceId=" + instanceId + ", subnetId="
				+ subnetId + "]";
	}

}
