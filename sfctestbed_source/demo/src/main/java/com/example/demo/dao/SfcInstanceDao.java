package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.SfcInstance;

/**
 * @class SfcInstanceDao
 * @brief SFCInstance
 * @author ychuang
 *
 */
public interface SfcInstanceDao extends JpaRepository<SfcInstance, Integer> {
	/**
	 * SFCInstanceId SFCInstance
	 * @param sfcInstanceId
	 * @return	SFCInstance
	 */
	public SfcInstance findBysfcInstanceId(Integer sfcInstanceId);
	/**
	 * SFCInstanceId SFCInstance
	 * @param sfcInstanceId
	 */
	@Transactional
	public void deleteBysfcInstanceId(Integer sfcInstanceId);
	/**
	 * instanceId SFCInstance
	 * @param instanceId
	 * @return	SFCInstance
	 */
	@Transactional
	public SfcInstance findByInstanceId(String instanceId);
	
}
