package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StackDao;
import com.example.demo.modular.Stack;

@Service
public class StackService {

	@Autowired
	StackDao stackDao;
	
	public List<Stack> getAll(){
		return stackDao.findAll();
	}
	
	public Stack getByStackId(int stackId){
		return stackDao.findBystackId(stackId);
	}
	
	public void delByStackId(int stackId){
		stackDao.deleteBystackId(stackId);
	}
	
	public Stack insertStack(Stack stack){
		return stackDao.saveAndFlush(stack);
	}
	
	public List<Stack> getBySfcId(String sfcId){
		return stackDao.findBysfcId(sfcId);
	}
	
	public Stack getByVnfName(String vnfName, String sfcId){
		return stackDao.findByvnfName(vnfName, sfcId);
	}
	
	public Stack getByVnfId(String vnfId){
		return stackDao.findByvnfId(vnfId);
	}
	
	public int updateStack(Stack stack){
		return stackDao.updateStack(stack.getStackId(), stack.getStackOsid(), stack.getStackName(), stack.getStackStatus(), stack.getStackIp());
	}
}
