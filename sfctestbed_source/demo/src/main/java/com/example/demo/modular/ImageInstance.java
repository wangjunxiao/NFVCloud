package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="image_instance")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ImageInstance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer imageInstanceId;
	private Integer imageId;
	private String instanceId;
	
	public ImageInstance() {
		super();
	}

	public ImageInstance(Integer imageId, String instanceId) {
		super();
		this.imageId = imageId;
		this.instanceId = instanceId;
	}

	public ImageInstance(Integer imageInstanceId, Integer imageId, String instanceId) {
		super();
		this.imageInstanceId = imageInstanceId;
		this.imageId = imageId;
		this.instanceId = instanceId;
	}

	public Integer getImageInstanceId() {
		return imageInstanceId;
	}

	public void setImageInstanceId(Integer imageInstanceId) {
		this.imageInstanceId = imageInstanceId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public String toString() {
		return "ImageInstance [imageInstanceId=" + imageInstanceId + ", imageId=" + imageId + ", instanceId="
				+ instanceId + "]";
	}
	
}
