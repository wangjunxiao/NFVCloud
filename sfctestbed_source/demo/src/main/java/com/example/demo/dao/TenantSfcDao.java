package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.TenantSfc;

/**
 * @class TenantSfcDao
 * @brief TenantSfc
 * @author ychuang
 *
 */
public interface TenantSfcDao extends JpaRepository<TenantSfc, Integer> {
	/**
	 * tenantSfcId tenantSfc
	 * @param tenantSfcId
	 * @return tenantSfc
	 */
	public TenantSfc findBytenantSfcId(Integer tenantSfcId);
	/**
	 * tenantSfcId tenantSfc
	 * @param tenantSfcId
	 */
	@Transactional
	public void deleteBytenantSfcId(Integer tenantSfcId);
	
}
