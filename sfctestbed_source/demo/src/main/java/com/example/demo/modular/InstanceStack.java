package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="instance_stack")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InstanceStack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer instanceStackId;
	private String instanceId;
	private Integer stackId;
	
	public InstanceStack() {
		super();
	}

	public InstanceStack(String instanceId, Integer stackId) {
		super();
		this.instanceId = instanceId;
		this.stackId = stackId;
	}

	public InstanceStack(Integer instanceStackId, String instanceId, Integer stackId) {
		super();
		this.instanceStackId = instanceStackId;
		this.instanceId = instanceId;
		this.stackId = stackId;
	}

	public Integer getInstanceStackId() {
		return instanceStackId;
	}

	public void setInstanceStackId(Integer instanceStackId) {
		this.instanceStackId = instanceStackId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getStackId() {
		return stackId;
	}

	public void setStackId(Integer stackId) {
		this.stackId = stackId;
	}

	@Override
	public String toString() {
		return "InstanceStack [instanceStackId=" + instanceStackId + ", instanceId=" + instanceId + ", stackId="
				+ stackId + "]";
	}
	
	
}
