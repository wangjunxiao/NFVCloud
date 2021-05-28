package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.InstanceSubnet;

/**
 * @class InstanceSubnetDao
 * @brief InstanceSubnet
 * @author ychuang
 *
 */
public interface InstanceSubnetDao extends JpaRepository<InstanceSubnet, Integer> {
	/**
	 * instanceSubnetId InstanceSubnet
	 * @param instanceSubnetId
	 * @return	InstanceSubnet
	 */
	public InstanceSubnet findByinstanceSubnetId(Integer instanceSubnetId);
	/**
	 * InstanceSubnetId instanceSubnet
	 * @param instanceSubnetId
	 */
	@Transactional
	public void deleteByinstanceSubnetId(Integer instanceSubnetId);
	
}
