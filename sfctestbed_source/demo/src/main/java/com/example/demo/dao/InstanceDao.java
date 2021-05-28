package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Instance;
/**
 * @class InstanceDao
 * @brief Instance
 * @author ychuang
 *
 */
public interface InstanceDao extends JpaRepository<Instance, Integer> {
	/**
	 * instanceId instance
	 * @param instanceId
	 * @return	Instance
	 */
	public Instance findByinstanceId(String instanceId);
	/**
	 * stackId instance
	 * @param stackId
	 * @return	Instance
	 */
	@Transactional
	@Query(value="select instance.* from (select instance_stack.instance_id from instance_stack where instance_stack.stack_id=?1) as A inner join instance on A.instance_id=instance.instance_id", nativeQuery = true)
	public Instance findBystackId(Integer stackId);
	/**
	 * instanceId instance
	 * @param instanceId
	 */
	@Transactional
	public void deleteByinstanceId(String instanceId);
	/**
	 * instanceOsid instance instanceId
	 * @param instanceOsid
	 * @return	Instance的instanceId
	 */
	@Transactional
	@Query(value="select instance_id from instance where instance_osid=?1", nativeQuery=true)
	public String findInstanceIdByinstanceOsid(String instanceOsid);
	/**
	 * sfcId instance
	 * @param sfcId
	 * @return	sfc instance
	 */
	@Transactional
	@Query(value="select instance.* from (select * from sfc_instance where sfc_instance.sfc_id=?1) as A inner join instance on instance.instance_id=A.instance_id", nativeQuery=true)
	public List<Instance> findBysfcId(String sfcId);
	/**
	 * sfcId head instance
	 * @param sfcId
	 * @return head instance
	 */
	@Transactional
	@Query(value="select instance.* from (select * from sfc_instance where sfc_instance.sfc_id=?1) as A inner join instance on instance.instance_id=A.instance_id where instance_type='head'", nativeQuery=true)
	public Instance findHeadInstanceBysfcId(String sfcId);
	/**
	 * sfcId tail instance
	 * @param sfcId
	 * @return	tail instance
	 */
	@Transactional
	@Query(value="select instance.* from (select * from sfc_instance where sfc_instance.sfc_id=?1) as A inner join instance on instance.instance_id=A.instance_id where instance_type='tail'", nativeQuery=true)
	public Instance findTailInstanceBysfcId(String sfcId);
	/**
	 * instanceId, instanceOsid instanceStatus update instance
	 * @param instanceId
	 * @param instanceOsid
	 * @param instanceStatus
	 * @return	update success or fail
	 */
	@Transactional
	@Query(value="update instance set instance.instance_osid=?2,instance.instance_status=?3 where instance.instance_id=?1", nativeQuery=true)
	public int updateInstance(String instanceId, String instanceOsid, String instanceStatus);
	
}
