package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.VnfStack;

/**
 * @class VnfStackDao
 * @brief VnfStack
 * @author ychuang
 *
 */
public interface VnfStackDao extends JpaRepository<VnfStack, Integer> {
	/**
	 * vnfStackId vnfStack
	 * @param vnfStackId
	 * @return vnfStack
	 */
	public VnfStack findByvnfStackId(Integer vnfStackId);
	/**
	 * stackId vnfStack
	 * @param stackId
	 * @return vnfStack
	 */
	public VnfStack findBystackId(Integer stackId);
	/**
	 * vnfStackId vnfStack
	 * @param vnfStackId
	 */
	@Transactional
	public void deleteByvnfStackId(Integer vnfStackId);
	/**
	 * VnfId vnfStack
	 * @param vnfId
	 * @return vnfStack
	 */
	public VnfStack findByvnfId(String vnfId);
	
}
