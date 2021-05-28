package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.VnfFlavor;

/**
 * @class VnfFlavorDao
 * @brief VnfFlavor
 * @author ychuang
 *
 */
public interface VnfFlavorDao extends JpaRepository<VnfFlavor, Integer> {
	/**
	 * vnfFlavorId vnfFlavor
	 * @param vnfFlavorId
	 * @return VnfFlavor
	 */
	public VnfFlavor findByvnfFlavorId(Integer vnfFlavorId);
	/**
	 * VNFFlavorId vnfFlavor
	 * @param vnfFlavorId
	 */
	@Transactional
	public void deleteByvnfFlavorId(Integer vnfFlavorId);
	
}
