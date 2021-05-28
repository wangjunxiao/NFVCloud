package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.Vnf;

/**
 * @class VnfDao
 * @brief vnf
 * @author ychuang
 *
 */
public interface VnfDao extends JpaRepository<Vnf, Integer> {
	/**
	 * VnfId vnf
	 * @param vnfId
	 * @return vnf
	 */
	public Vnf findByvnfId(String vnfId);
	/**
	 * sfcId Vnf
	 * @param sfcId
	 * @return sfc's vnf
	 */
	@Transactional
	@Query(value="select vnf.* from (select * from sfc_vnf where sfc_vnf.sfc_id=?1) as A inner join vnf on vnf.vnf_id=A.vnf_id", nativeQuery=true)
	public List<Vnf> findBysfcId(String sfcId);
	/**
	 * VNFName vnf
	 * @param vnfName
	 * @return vnf
	 */
	public Vnf findByvnfName(String vnfName);
	/**
	 * VnfId vnf
	 * @param vnfId
	 */
	@Transactional
	public void deleteByvnfId(String vnfId);
	/**
	 * stackId vnf
	 * @param stackId
	 * @return vnf
	 */
	@Transactional
	@Query(value="select vnf.* from ( select * from  vnf_stack where vnf_stack.stack_id=?1) as A inner join vnf on vnf.vnf_id=A.vnf_id", nativeQuery=true)
	public Vnf findBystackId(Integer stackId);
	/**
	 * VnfId VnfStatus update vnf
	 * @param vnfId
	 * @param vnfStatus
	 * @return update success or fail
	 */
	@Transactional
	@Query(value="update vnf set vnf.vnf_status=?2 where vnf.vnf_id=?1", nativeQuery=true)
	public int updateVnf(String vnfId, String vnfStatus);
}
