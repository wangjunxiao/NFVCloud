package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.InstanceStack;

/**
 * @class InstanceStackDao
 * @brief InstanceStack
 * @author ychuang
 *
 */
public interface InstanceStackDao extends JpaRepository<InstanceStack, Integer> {
	/**
	 * instanceStackId instanceStack
	 * @param instanceStackId
	 * @return	InstanceStack
	 */
	public InstanceStack findByinstanceStackId(Integer instanceStackId);
	/**
	 * InstanceStackId instanceStack
	 * @param instanceStackId
	 */
	@Transactional
	public void deleteByinstanceStackId(Integer instanceStackId);
	/**
	 * stackId InstanceStack
	 * @param stackId
	 * @return	InstanceStack
	 */
	public InstanceStack findBystackId(Integer stackId);
	
}
