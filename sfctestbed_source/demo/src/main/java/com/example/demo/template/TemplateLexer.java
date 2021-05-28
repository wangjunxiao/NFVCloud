package com.example.demo.template;

import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
/**
 * @interface
 * @brief Resolver
 * @author ychuang
 *
 */
@Service
public interface TemplateLexer {
	/**
	 * resolve template
	 * @param template
	 * @throws InterruptedException
	 */
	public void lexer(String template) throws InterruptedException;
	/**
	 * create resource
	 * @param tenantId
	 * @return
	 * @throws InterruptedException
	 */
	public int templateResourceCreate(int tenantId) throws InterruptedException;
	/**
	 * delete resource
	 */
	public void templateResourceDelete();
	/**
	 * update resource
	 * @param tenantId
	 */
	public void templateResourceUpdate(int tenantId);
	
}
