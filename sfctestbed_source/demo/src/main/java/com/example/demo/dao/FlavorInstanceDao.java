package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modular.FlavorInstance;

/**
 * @class FlavorInstanceDao
 * @brief flavorinstance
 * @author ychuang
 *
 */
public interface FlavorInstanceDao extends JpaRepository<FlavorInstance, Integer> {

//	@Modifying
//	@Query("select sdn.flavor_instance from select sdn.instance from select sdn.instance_controller from select sdn.resource from select  from sdn.Vfunc_executor_Vfunc where sdn.Vfunc_executor_Vfunc.executor_id=?1) as A inner join sdn.Vfunc_Vfunc_resource on A.Vfunc_id=sdn.Vfunc_Vfunc_resource.Vfunc_id and sdn.Vfunc_Vfunc_resource.resource_status='wait' and sdn.Vfunc_Vfunc_resource.resource_type='Controller') as B inner join sdn.Vfunc_instance_controller on B.resource_id=sdn.Vfunc_instance_controller.controller_id) as C inner join sdn.Vfunc_instance on C.instance_id=sdn.Vfunc_instance.instance_id and sdn.Vfunc_instance.instance_status='ACTIVE') UNION ALL (select sdn.Vfunc_instance.* from (select sdn.Vfunc_instance_host.* from (select sdn.Vfunc_Vfunc_resource.* from (select * from sdn.Vfunc_executor_Vfunc where sdn.Vfunc_executor_Vfunc.executor_id=?1) as D inner join sdn.Vfunc_Vfunc_resource on D.Vfunc_id=sdn.Vfunc_Vfunc_resource.Vfunc_id and sdn.Vfunc_Vfunc_resource.resource_status='wait' and sdn.Vfunc_Vfunc_resource.resource_type='Host') as E inner join sdn.Vfunc_instance_host on E.resource_id=sdn.Vfunc_instance_host.host_id) as F inner join sdn.Vfunc_instance on F.instance_id=sdn.Vfunc_instance.instance_id and sdn.Vfunc_instance.instance_status='ACTIVE')) as G inner join sdn.Vfunc_flavor_instance on G.instance_id=sdn.Vfunc_flavor_instance.instance_id")
//	public List<FlavorInstance> getAllActive(int exeId);

	/**
	 * flavorInstanceId flavorInstance
	 * @param flavorInstanceId
	 * @return	flavorInstance
	 */
	public FlavorInstance findByflavorInstanceId(Integer flavorInstanceId);
	/**
	 * instanceId flavorInstance
	 * @param instanceId
	 * @return	flavorInstance
	 */
	public FlavorInstance findByinstanceId(String instanceId);
	/**
	 * flavorInstanceId flavorInstance
	 * @param flavorInstanceId
	 */
	@Transactional
	public void deleteByflavorInstanceId(Integer flavorInstanceId);
	
}
