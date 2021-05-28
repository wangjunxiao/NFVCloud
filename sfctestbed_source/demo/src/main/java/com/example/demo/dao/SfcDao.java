package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Sfc;

/**
 * @class SfcDao
 * @brief Sfc
 * @author ychuang
 *
 */
public interface SfcDao extends JpaRepository<Sfc, Integer> {
	/**
	 * sfcId sfc
	 * @param sfcId
	 * @return	Sfc
	 */
	public Sfc findBysfcId(String sfcId);
	/**
	 * sfcId sfc
	 * @param sfcId
	 */
	@Transactional
	public void deleteBysfcId(String sfcId);
	/**
	 * linkId Sfc
	 * @param linkId
	 * @return	sfc
	 */
	@Transactional
	@Query(value="select sfc.* from (select * from sfc_link where sfc_link.link_id=?1) as A inner join sfc on sfc.sfc_id=A.sfc_id", nativeQuery=true)
	public List<Sfc> findBylinkId(String linkId);
	/**
	 * instanceId sfc
	 * @param InstanceId
	 * @return	sfc
	 */
	@Transactional
	@Query(value="select sfc.* from (select * from sfc_instance where sfc_instance.instance_id=?1) as A inner join sfc on sfc.sfc_id=A.sfc_id", nativeQuery=true)
	public Sfc findByInstanceId(String InstanceId);
	/**
	 * stackId sfc
	 * @param stackId
	 * @return	sfc
	 */
	@Transactional
	@Query(value="select sfc.* from (select sfc_vnf.* from (select * from vnf_stack where vnf_stack.stack_id=?1) as A inner join sfc_vnf on sfc_vnf.vnf_id=A.vnf_id) as B inner join sfc on sfc.sfc_id=B.sfc_id", nativeQuery=true)
	public Sfc findBystackId(Integer stackId);
	/**
	 * sfcId sfcStatus sfc
	 * @param sfcId
	 * @param sfcStatus
	 * @return	update success or fail
	 */
	@Transactional
	@Query(value="update sfc set sfc.sfc_status=?2 where sfc.sfc_id=?1", nativeQuery=true)
	public int updateSfc(String sfcId, String sfcStatus);
}
