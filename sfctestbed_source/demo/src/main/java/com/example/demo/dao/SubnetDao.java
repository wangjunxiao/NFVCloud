package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Subnet;

/**
 * @class SubnetDao
 * @brief Subnet
 * @author ychuang
 *
 */
public interface SubnetDao extends JpaRepository<Subnet, Integer> {
	/**
	 * SubnetId Subnet
	 * @param subnetId
	 * @return Subnet
	 */
	public Subnet findBysubnetId(String subnetId);
	/**
	 * SubnetType Subnet
	 * @param subnetType
	 * @return Subnet
	 */
	public Subnet findBysubnetType(String subnetType);
	/**
	 * instanceId Subnet
	 * @param instanceId
	 * @return	Subnet
	 */
	@Transactional
	@Query(value="select subnet.* from (select * from instance_subnet where instance_subnet.instance_id=?1) as A inner join subnet on A.subnet_id=subnet.subnet_id", nativeQuery=true)
	public Subnet findByinstanceId(String instanceId);
	/**
	 * SubnetId Subnet
	 * @param subnetId
	 */
	@Transactional
	public void deleteBysubnetId(String subnetId);
	
}
