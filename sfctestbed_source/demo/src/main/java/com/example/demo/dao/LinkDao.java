package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Link;

/**
 * @class LinkDao
 * @brief Link
 * @author ychuang
 *
 */
public interface LinkDao extends JpaRepository<Link, Integer> {
	/**
	 * linkId Link
	 * @param linkId
	 * @return	Link
	 */
	public Link findBylinkId(String linkId);
	/**
	 * linkId link
	 * @param linkId
	 */
	@Transactional
	public void deleteBylinkId(String linkId);
	/**
	 * sfcId Link list
	 * @param sfcId
	 * @return	Link list
	 */
	@Modifying
	@Transactional
	@Query(value="select link.* from (select * from sfc_link where sfc_link.sfc_id=?1) as A inner join link on link.link_id=A.link_id", nativeQuery=true)
	public List<Link> findBysfcId(String sfcId);
	
}
