package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.FloatingIp;

/**
 * Class FloatingIpDao
 * @brief FloatingIp
 * @author ychuang
 *
 */
public interface FloatingIpDao extends JpaRepository<FloatingIp, Integer> {
	/**
	 * floatingIpId floatingIp
	 * @param floatingIpId
	 * @return
	 */
	public FloatingIp findByfloatingIpId(Integer floatingIpId);
	/**
	 * floatingIpId floatingIp
	 * @param floatingIpId
	 */
	@Transactional
	public void deleteByfloatingIpId(Integer floatingIpId);
	/**
	 * floatingIpStatus FloatingIp
	 * @param floatingIpStatus
	 * @return
	 */
	@Transactional
	@Query(value="select * from vfunc.floatingip where vfunc.floatingip.floating_ip_status=?1 limit 0,1", nativeQuery=true)
	public FloatingIp findRandomFloatingIp(String floatingIpStatus);
	/**
	 * floatingIpOsid floatingIp
	 * @param floatingIpOsid
	 * @return
	 */
	public FloatingIp findByfloatingIpOsid(String floatingIpOsid);
	
}
