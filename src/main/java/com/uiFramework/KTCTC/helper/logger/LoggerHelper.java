package com.uiFramework.KTCTC.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.uiFramework.KTCTC.helper.resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root=false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}
	

}
