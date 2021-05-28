package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.Flavor;

/**
 * @class FlavorDao
 * @brief Flavor with db
 * @author ychuang
 *
 */
public interface FlavorDao extends JpaRepository<Flavor, Integer> {
	
	/**
	 * query flavor from db by flavorId
	 * @param flavorId
	 * @return	flavor
	 */
	public Flavor findByFlavorId(Integer flavorId);
	
	/**
	 * delete flavor by flavorId
	 * @param flavorId
	 */
	@Transactional
	public void deleteByFlavorId(Integer flavorId);
	
}
