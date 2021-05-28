package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vnf_flavor")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class VnfFlavor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vnfFlavorId;
	private String vnfId;
	private Integer flavorId;
	
	public VnfFlavor() {
		super();
	}

	public VnfFlavor(String vnfId, Integer flavorId) {
		super();
		this.vnfId = vnfId;
		this.flavorId = flavorId;
	}

	public VnfFlavor(Integer vnfFlavorId, String vnfId, Integer flavorId) {
		super();
		this.vnfFlavorId = vnfFlavorId;
		this.vnfId = vnfId;
		this.flavorId = flavorId;
	}

	public Integer getVnfFlavorId() {
		return vnfFlavorId;
	}

	public void setVnfFlavorId(Integer vnfFlavorId) {
		this.vnfFlavorId = vnfFlavorId;
	}

	public String getVnfId() {
		return vnfId;
	}

	public void setVnfId(String vnfId) {
		this.vnfId = vnfId;
	}

	public Integer getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(Integer flavorId) {
		this.flavorId = flavorId;
	}

	@Override
	public String toString() {
		return "VnfFlavor [vnfFlavorId=" + vnfFlavorId + ", vnfId=" + vnfId + ", flavorId=" + flavorId + "]";
	}
	
}
