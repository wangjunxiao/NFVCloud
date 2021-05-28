package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @class
 * @brief flavor entity
 * @author ychuang
 * @note
 * should be identical with db's
 *
 */
@Entity
@Table(name="flavor")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Flavor {
	
	@Id
	private Integer flavorId;
	private String flavorOsid;
	private String flavorName;
	private Integer flavorVcpus;
	private Integer flavorRam;
	private Integer flavorRootdisk;
	private Integer flavorEphemeraldisk;
	private Integer flavorSwapdisk;
	
	public Flavor() {
		super();
	}

	public Flavor(String flavorOsid, String flavorName, Integer flavorVcpus, Integer flavorRam, Integer flavorRootdisk,
			Integer flavorEphemeraldisk, Integer flavorSwapdisk) {
		super();
		this.flavorOsid = flavorOsid;
		this.flavorName = flavorName;
		this.flavorVcpus = flavorVcpus;
		this.flavorRam = flavorRam;
		this.flavorRootdisk = flavorRootdisk;
		this.flavorEphemeraldisk = flavorEphemeraldisk;
		this.flavorSwapdisk = flavorSwapdisk;
	}

	public Flavor(Integer flavorId, String flavorOsid, String flavorName, Integer flavorVcpus, Integer flavorRam,
			Integer flavorRootdisk, Integer flavorEphemeraldisk, Integer flavorSwapdisk) {
		super();
		this.flavorId = flavorId;
		this.flavorOsid = flavorOsid;
		this.flavorName = flavorName;
		this.flavorVcpus = flavorVcpus;
		this.flavorRam = flavorRam;
		this.flavorRootdisk = flavorRootdisk;
		this.flavorEphemeraldisk = flavorEphemeraldisk;
		this.flavorSwapdisk = flavorSwapdisk;
	}

	public Integer getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(Integer flavorId) {
		this.flavorId = flavorId;
	}

	public String getFlavorOsid() {
		return flavorOsid;
	}

	public void setFlavorOsid(String flavorOsid) {
		this.flavorOsid = flavorOsid;
	}

	public String getFlavorName() {
		return flavorName;
	}

	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}

	public Integer getFlavorVcpus() {
		return flavorVcpus;
	}

	public void setFlavorVcpus(Integer flavorVcpus) {
		this.flavorVcpus = flavorVcpus;
	}

	public Integer getFlavorRam() {
		return flavorRam;
	}

	public void setFlavorRam(Integer flavorRam) {
		this.flavorRam = flavorRam;
	}

	public Integer getFlavorRootdisk() {
		return flavorRootdisk;
	}

	public void setFlavorRootdisk(Integer flavorRootdisk) {
		this.flavorRootdisk = flavorRootdisk;
	}

	public Integer getFlavorEphemeraldisk() {
		return flavorEphemeraldisk;
	}

	public void setFlavorEphemeraldisk(Integer flavorEphemeraldisk) {
		this.flavorEphemeraldisk = flavorEphemeraldisk;
	}

	public Integer getFlavorSwapdisk() {
		return flavorSwapdisk;
	}

	public void setFlavorSwapdisk(Integer flavorSwapdisk) {
		this.flavorSwapdisk = flavorSwapdisk;
	}

	@Override
	public String toString() {
		return "Flavor [flavorId=" + flavorId + ", flavorOsid=" + flavorOsid + ", flavorName=" + flavorName
				+ ", flavorVcpus=" + flavorVcpus + ", flavorRam=" + flavorRam + ", flavorRootdisk=" + flavorRootdisk
				+ ", flavorEphemeraldisk=" + flavorEphemeraldisk + ", flavorSwapdisk=" + flavorSwapdisk + "]";
	}
	
	
}
