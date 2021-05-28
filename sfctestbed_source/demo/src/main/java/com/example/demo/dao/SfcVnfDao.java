package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.SfcVnf;

/**
 * @class SfcVnfDao
 * @brief SfcVnf
 * @author ychuang
 *
 */
public interface SfcVnfDao extends JpaRepository<SfcVnf, Integer> {
	/**
	 * sfcVnfId sfcVnf
	 * @param sfcVnfId
	 * @return sfcVnf
	 */
	public SfcVnf findBysfcVnfId(Integer sfcVnfId);
	/**
	 * sfcVnfId sfcVnf
	 * @param sfcVnfId
	 */
	@Transactional
	public void deleteBysfcVnfId(Integer sfcVnfId);
	
}
