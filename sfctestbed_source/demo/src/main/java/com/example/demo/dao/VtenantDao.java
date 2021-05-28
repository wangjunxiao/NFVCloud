package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.Vtenant;

/**
 * @class VtenantDao
 * @brief Vtenant
 * @author ychuang
 *
 */
public interface VtenantDao extends JpaRepository<Vtenant, Integer> {
	/**
	 * tenantName tenantPassword vtenant
	 * @param tenantName
	 * @param tenantPassword
	 * @return Vtenant
	 */
	public Vtenant findByTenantNameAndTenantPassword(String tenantName, String tenantPassword);
	/**
	 * tenantId Vtenant
	 * @param tenantId
	 * @return Vtenant
	 */
	public Vtenant findBytenantId(Integer tenantId);
	/**
	 * tenantId Vtenant
	 * @param tenantId
	 */
	@Transactional
	public void deleteBytenantId(Integer tenantId);
	
}
