package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.SfcNetwork;

/**
 * @class SfcNetworkDao
 * @brief SFCNetwork
 * @author ychuang
 *
 */
public interface SfcNetworkDao extends JpaRepository<SfcNetwork, Integer> {
	/**
	 * sfcNetworkId sfcNetwork
	 * @param sfcNetworkId
	 * @return	SFCNetwork
	 */
	public SfcNetwork findBysfcNetworkId(Integer sfcNetworkId);
	/**
	 * sfcId sfcNetwork
	 * @param sfcId
	 * @return	sfc
	 */
	public SfcNetwork findNetworkOsidBySfcId(String sfcId);
	/**
	 * sfcNetworkId sfcNetwork
	 * @param sfcNetworkId
	 */
	@Transactional
	public void deleteBysfcNetworkId(Integer sfcNetworkId);
	
}
