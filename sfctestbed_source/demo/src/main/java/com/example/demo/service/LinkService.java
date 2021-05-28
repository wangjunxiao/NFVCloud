package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LinkDao;
import com.example.demo.modular.Link;

@Service
public class LinkService {
	
	@Autowired
	LinkDao linkDao;
	
	public List<Link> getAll(){
		return linkDao.findAll();
	}
	
	public Link getByLinkId(String linkId){
		return linkDao.findBylinkId(linkId);
	}
	
	public void delByLinkId(String linkId){
		linkDao.deleteBylinkId(linkId);
	}
	
	public Link insertLink(Link link){
		return linkDao.saveAndFlush(link);
	}
	
	public List<Link> getBySfcId(String sfcId){
		return linkDao.findBysfcId(sfcId);
	}
}
