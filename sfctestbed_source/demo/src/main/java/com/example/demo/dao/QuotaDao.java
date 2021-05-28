package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modular.Quota;

/**
 * @Class QuotaDao
 * @brief Quota
 * @author ychuang
 *
 */
public interface QuotaDao extends JpaRepository<Quota, Integer> {
	/**
	 * quotaId quota
	 * @param quotaId
	 * @return	quota
	 */
	public Quota findByquotaId(Integer quotaId);
	/**
	 * quotaId quota
	 * @param quotaId
	 */
	@Transactional
	public void deleteByquotaId(Integer quotaId);
	
}
