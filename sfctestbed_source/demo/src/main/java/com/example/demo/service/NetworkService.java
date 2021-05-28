package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NetworkDao;
import com.example.demo.modular.Network;

@Service
public class NetworkService {

	@Autowired
	NetworkDao networkDao;
	
	public List<Network> getAll(){
		return networkDao.findAll();
	}
	
	public Network insertNetwork(Network network){
		return networkDao.saveAndFlush(network);
	}
	
	public void delByNetworkId(int networkId){
		networkDao.deleteBynetworkId(networkId);
	}
	
	public Network getByNetworkId(int networkId){
		return networkDao.findBynetworkId(networkId);
	}
	
	public Network getByNetworkStatus(String networkStatus){
		return networkDao.findBynetworkStatus(networkStatus);
	}
}
