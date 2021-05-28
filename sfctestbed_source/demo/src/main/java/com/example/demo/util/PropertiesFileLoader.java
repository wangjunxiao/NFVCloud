package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @class PropertiesFileLoader
 * @brief load config file
 * @author ychuang
 *
 */
public class PropertiesFileLoader {

	private Properties properties  = new Properties();

	private Logger logger = LoggerFactory.getLogger(PropertiesFileLoader.class);
	
	public PropertiesFileLoader(String fileName){
		if (StringUtils.isBlank(fileName)) {
			return;
		}
		try {
			InputStream in = null;
			int index = fileName.lastIndexOf(".");
			if (index != -1) {
				in = this.getClass().getClassLoader().getResourceAsStream(fileName.substring(0, index) + "_self" + fileName.substring(index));
			}else {
				in = this.getClass().getClassLoader().getResourceAsStream(fileName.substring(0, index) + "_self");
			}
			if (in == null) {
				in = this.getClass().getClassLoader().getResourceAsStream(fileName);
			}			
			properties.load(in);
		} catch (IOException e) {
			logger.error("load " + fileName + " error", e);			
		}
	}

	public Object get(String key) {
		return properties.get(key);
	}
	
}
