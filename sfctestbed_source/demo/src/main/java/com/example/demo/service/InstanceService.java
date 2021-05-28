package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstanceDao;
import com.example.demo.modular.Instance;

@Service
public class InstanceService {
	
	@Autowired
	InstanceDao instanceDao;
	
	public List<Instance> getAll(){
		return instanceDao.findAll();
	}
	
	public Instance getByInstanceId(String instanceId){
		return instanceDao.findByinstanceId(instanceId);
	}
	
	public Instance getByStackId(int stackId){
		return instanceDao.findBystackId(stackId);
	}
	
	public String getInstanceIdByInstanceOsid(String instanceOsid){
		return instanceDao.findInstanceIdByinstanceOsid(instanceOsid);
	}
	
	public void delByInstanceId(String instanceId){
		instanceDao.deleteByinstanceId(instanceId);
	}
	
	public List<Instance> getBySfcId(String sfcId){
		return instanceDao.findBysfcId(sfcId);
	}
	
	public Instance getHeadInstanceBySfcId(String sfcId){
		return instanceDao.findHeadInstanceBysfcId(sfcId);
	}
	
	public Instance getTailInstanceBySfcId(String sfcId){
		return instanceDao.findTailInstanceBysfcId(sfcId);
	}
	
	public Instance insertInstance(Instance instance){
		return instanceDao.saveAndFlush(instance);
	}
	
	public int updateInstance(Instance instance){
		return instanceDao.updateInstance(instance.getInstanceId(), instance.getInstanceOsid(), instance.getInstanceStatus());
	}
}
