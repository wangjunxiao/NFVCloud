package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="flavor_instance")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class FlavorInstance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flavorInstanceId;
	private Integer flavorId;
	private String instanceId;
	
	public FlavorInstance() {
		super();
	}

	public FlavorInstance(Integer flavorId, String instanceId) {
		super();
		this.flavorId = flavorId;
		this.instanceId = instanceId;
	}

	public FlavorInstance(Integer flavorInstanceId, Integer flavorId, String instanceId) {
		super();
		this.flavorInstanceId = flavorInstanceId;
		this.flavorId = flavorId;
		this.instanceId = instanceId;
	}

	public Integer getFlavorInstanceId() {
		return flavorInstanceId;
	}

	public void setFlavorInstanceId(Integer flavorInstanceId) {
		this.flavorInstanceId = flavorInstanceId;
	}

	public Integer getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(Integer flavorId) {
		this.flavorId = flavorId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public String toString() {
		return "FlavorInstance [flavorInstanceId=" + flavorInstanceId + ", flavorId=" + flavorId + ", instanceId="
				+ instanceId + "]";
	}
	
	
}
