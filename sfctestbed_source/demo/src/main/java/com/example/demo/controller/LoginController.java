package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modular.Vtenant;
import com.example.demo.service.VtenantService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @class LoginController
 * @brief frontend API
 * @author ychuang
 * @note
 * handle the request from /Login 
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
public class LoginController {
	
	@Autowired
	VtenantService vtenantService;
	
//	@RequestMapping("/user/getAll")
//	@ResponseBody
//	public List<Vtenant> findAll(){
//		List<Vtenant> v = vtenantService.getAll();
//		return v;
//	}
	
	/**
	 * handle login request
	 * @param vfunc_vtenant
	 * @return	return login result
	 */
	@RequestMapping(method=RequestMethod.POST,value="/Login")
	@CrossOrigin
	public boolean loginController(@RequestBody String vfunc_vtenant){
//		JSONObject vtenant = new JSONObject(vfunc_vtenant);
//		if(vfunc_vtenant != null){
//			System.out.println(vtenant.getString("tenant_name"));
//			return true;
//		}
		return false;
	} 
	
//	@RequestMapping("/get-by-id/{id}")
//	@ResponseBody
//	public Vtenant getById(@PathVariable int id){
//		return vs.getById(id);
//	}
	
//	@RequestMapping(method=RequestMethod.POST , value="/get-by-id/{id}")
//	@ResponseBody
//	public Vfunc_vtenant findById(@PathVariable int id){
//		return vs.getById(id);
//	}
}
