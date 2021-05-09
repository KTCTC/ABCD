package com.uiFramework.KTCTC.helper.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.uiFramework.KTCTC.helper.alert.AlertHelper;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;

public class PropertyFileHelper {
	private Logger log = LoggerHelper.getLogger(PropertyFileHelper.class);
	private Properties propObj = null;	
	public PropertyFileHelper(String propName)
	{
		log.info("Initializing mentioned property file");
		FileInputStream fis = null;
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\configfile\\"+propName);
		
		try {
			 fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 propObj = new Properties();
	 
	 try {
		propObj.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	 log.info("Property file has been initialized");
	}
	
	
	/**
	 * Method takes key from user and returns value from property file
	 * @param key
	 * @return
	 */
	public String getPropertyValueFromFile(String key)
	{
		log.info("Getting value of key from property file");
		String val = propObj.getProperty(key);
		log.info("Value for provided key is  = "+val);
		return val;
	}
	
	

}
