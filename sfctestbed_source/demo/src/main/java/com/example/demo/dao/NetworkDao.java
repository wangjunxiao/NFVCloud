package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Network;

/**
 * @class NetworkDao
 * @brief Network
 * @author ychuang
 *
 */
public interface NetworkDao extends JpaRepository<Network, Integer> {
	/**
	 * networkId network
	 * @param networkId
	 * @return	Network
	 */
	public Network findBynetworkId(Integer networkId);
	/**
	 * networkId network
	 * @param networkId
	 */
	@Transactional
	public void deleteBynetworkId(Integer networkId);
	/**
	 * networkStatus network
	 * @param networkStatus
	 * @return	Network
	 */
	@Transactional
	@Query(value="select * from network where network_status=?1 limit 0,1", nativeQuery=true)
	public Network findBynetworkStatus(String networkStatus);
}
