package com.example.demo.modular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="image")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer imageId;
	private String imageOsid;
	private String imageName;
	private String imageFormat;
	private String imageSize;
	
	public Image() {
		super();
	}

	public Image(String imageOsid, String imageName, String imageFormat, String imageSize) {
		super();
		this.imageOsid = imageOsid;
		this.imageName = imageName;
		this.imageFormat = imageFormat;
		this.imageSize = imageSize;
	}

	public Image(Integer imageId, String imageOsid, String imageName, String imageFormat, String imageSize) {
		super();
		this.imageId = imageId;
		this.imageOsid = imageOsid;
		this.imageName = imageName;
		this.imageFormat = imageFormat;
		this.imageSize = imageSize;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageOsid() {
		return imageOsid;
	}

	public void setImageOsid(String imageOsid) {
		this.imageOsid = imageOsid;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageOsid=" + imageOsid + ", imageName=" + imageName + ", imageFormat="
				+ imageFormat + ", imageSize=" + imageSize + "]";
	}
	
	
	
}
