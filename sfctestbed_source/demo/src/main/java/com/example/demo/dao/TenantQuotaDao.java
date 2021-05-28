package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.TenantQuota;

/**
 * @class TenantQuotaDao
 * @brief TenantQuota
 * @author ychuang
 *
 */
public interface TenantQuotaDao extends JpaRepository<TenantQuota, Integer> {
	/**
	 * tenantQuotaId tenantquota
	 * @param tenantQuotaId
	 * @return tenantquota
	 */
	public TenantQuota findBytenantQuotaId(Integer tenantQuotaId);
	/**
	 * tenantQuotaId tenantquota
	 * @param tenantQuotaId
	 */
	@Transactional
	public void deleteBytenantQuotaId(Integer tenantQuotaId);
	
}
