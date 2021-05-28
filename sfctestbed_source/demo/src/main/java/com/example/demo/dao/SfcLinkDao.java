package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.SfcLink;

/**
 * @class SfcLinkDao
 * @brief SFCLink
 * @author ychuang
 *
 */
public interface SfcLinkDao extends JpaRepository<SfcLink, Integer> {
	/**
	 * sfcLinkId SfcLink
	 * @param sfcLinkId
	 * @return	SFCLink
	 */
	public SfcLink findBysfcLinkId(Integer sfcLinkId);
	/**
	 * sfcLinkId SFCLink
	 * @param sfcLinkId
	 */
	@Transactional
	public void deleteBysfcLinkId(Integer sfcLinkId);
	
}
