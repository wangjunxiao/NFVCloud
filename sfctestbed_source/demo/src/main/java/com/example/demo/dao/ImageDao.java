package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.Image;

/**
 * @class ImageDao
 * @brief Image
 * @author ychuang
 *
 */
public interface ImageDao extends JpaRepository<Image, Integer> {

	/**
	 * imageId Image
	 * @param imageId
	 * @return
	 */
	public Image findByimageId(Integer imageId);
	/**
	 * imageName Image
	 * @param imageName
	 * @return
	 */
	public Image findByimageName(String imageName);
	/**
	 * imageId Image
	 * @param imageId
	 */
	@Transactional
	public void deleteByimageId(Integer imageId);
	/**
	 * imageOsid image
	 * @param imageOsid
	 * @return
	 */
	public Image findByimageOsid(String imageOsid);
	/**
	 * imageId image imageOsid
	 * @param imageId
	 * @return
	 */
	public String findImageOsidByImageId(int imageId);
	
}
