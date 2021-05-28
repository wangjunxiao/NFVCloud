package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Stack;

/**
 * @class StackDao
 * @brief Stack
 * @author ychuang
 *
 */
public interface StackDao extends JpaRepository<Stack, Integer> {
	/**
	 * stackId Stack
	 * @param stackId
	 * @return stack
	 */
	public Stack findBystackId(Integer stackId);
	/**
	 * stackId stack
	 * @param stackId
	 */
	@Transactional
	public void deleteBystackId(Integer stackId);
	/**
	 * sfcId Stack
	 * @param sfcId
	 * @return stack
	 */
	@Transactional
	@Query(value="select stack.* from (select vnf_stack.* from (select * from sfc_vnf where sfc_vnf.sfc_id=?1) as A inner join vnf_stack on vnf_stack.vnf_id=A.vnf_id) as B inner join stack on stack.stack_id=B.stack_id", nativeQuery=true)
	public List<Stack> findBysfcId(String sfcId);
	/**
	 * VNFId stack
	 * @param vnfId
	 * @return Stack
	 */
	@Transactional
	@Query(value="select stack.* from (select vnf_stack.* from vnf_stack where vnf_stack.vnf_id=?1)as A inner join stack on stack.stack_id=A.stack_id", nativeQuery=true)
	public Stack findByvnfId(String vnfId);
	/**
	 * VnfName sfcId stack
	 * @param vnfName
	 * @param sfcId
	 * @return stack
	 */
	@Transactional
	@Query(value="select stack.* from (select vnf_stack.* from (select * from vnf where vnf.vnf_name=?1) as A inner join (select * from sfc_vnf where sfc_vnf.sfc_id=?2) as B on A.vnf_id=B.vnf_id inner join vnf_stack on vnf_stack.vnf_id=A.vnf_id) as C inner join stack on C.stack_id=stack.stack_id", nativeQuery=true)
	public Stack findByvnfName(String vnfName, String sfcId);
	/**
	 * stackId, stackOsid, stackName, stackStatus, stackIp update stack
	 * @param stackId
	 * @param stackOsid
	 * @param stackName
	 * @param stackStatus
	 * @param stackIp
	 * @return	update success or fail
	 */
	@Transactional
	@Query(value="update stack.* set stack.stack_osid=?2,stack.stack_name=?3,stack.stack_status=?4,stack.stack_ip=?5 where stack.stack_id=?1", nativeQuery=true)
	public int updateStack(Integer stackId, String stackOsid, String stackName, String stackStatus, String stackIp);
}
