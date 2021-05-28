package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FlavorInstanceService;
import com.example.demo.service.FlavorService;
import com.example.demo.service.FloatingIpService;
import com.example.demo.service.ImageInstanceService;
import com.example.demo.service.ImageService;
import com.example.demo.service.InstanceService;
import com.example.demo.service.InstanceStackService;
import com.example.demo.service.InstanceSubnetService;
import com.example.demo.service.LinkService;
import com.example.demo.service.SfcInstanceService;
import com.example.demo.service.SfcLinkService;
import com.example.demo.service.SfcNetworkService;
import com.example.demo.service.SfcService;
import com.example.demo.service.SfcVnfService;
import com.example.demo.service.StackService;
import com.example.demo.service.SubnetService;
import com.example.demo.service.VnfFlavorService;
import com.example.demo.service.VnfService;
import com.example.demo.service.VnfStackService;
import com.example.demo.template.Template;
import com.example.demo.template.TemplateLexer;
import com.example.demo.templates.JsonTemplateLexer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @class TemplateController
 * @brief handle frontend sfc creatation Template
 * @author ychuang
 * @note
 * templateLexer, used for resloving resource template
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
public class TemplateController {

	@Autowired
	private JsonTemplateLexer templateLexer;
	
	/**
	 * handle frontend SFC JSON template
	 * @param template
	 * @return SFC creatation success or fail
	 * @throws InterruptedException
	 */
	@RequestMapping(method=RequestMethod.POST,value="/template")
	@CrossOrigin
	public int templateLexer(@RequestBody String template) throws InterruptedException{
		templateLexer.lexer(template);
		return 0;
	} 
	
	/**
	 * handle frontend VNF update
	 * @param vnfUpdate
	 * @return	SFC updating success or fail
	 * @throws InterruptedException
	 */
	@RequestMapping(method=RequestMethod.POST,value="/template/vnf-update")
	@CrossOrigin
	public int templateVnfUpdate(@RequestBody String vnfUpdate) throws InterruptedException{
		templateLexer.lexer(vnfUpdate);
		return 0;
	}
	
	
}
