package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.ImageInstance;

/**
 * @class ImageInstanceDao
 * @brief ImageInstanceDao
 * @author ychuang
 *
 */
public interface ImageInstanceDao extends JpaRepository<ImageInstance, Integer> {
	/**
	 * imageInstanceId imageInstance
	 * @param imageInstanceId
	 * @return
	 */
	public ImageInstance findByimageInstanceId(Integer imageInstanceId);
	/**
	 * imageInstanceId imageInstance
	 * @param imageInstanceId
	 */
	@Transactional
	public void deleteByimageInstanceId(Integer imageInstanceId);
	
}
