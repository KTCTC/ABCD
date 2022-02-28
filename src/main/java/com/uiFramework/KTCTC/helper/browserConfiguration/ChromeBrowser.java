
package com.uiFramework.KTCTC.helper.browserConfiguration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.KTCTC.helper.resource.ResourceHelper;

public class ChromeBrowser {

	private ChromeOptions getChromeOptions() {
		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-popup-blocking");
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		//option.setBinary("/path/to/other/chrome/binary");
		//option.addArguments("--headless");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);			
				
		
		  chrome.setCapability("browserName", "chrome");
		  chrome.setCapability("timezone","UTC+05:30");
		  chrome.setCapability("geoLocation","IN");
		 
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);	
		//Linux
		if(System.getProperty("os.name").contains("Linux")){
			option.addArguments("--headless", "window-size=1920,1080", "--no-sandbox");
		}
		return option;
	}

	private WebDriver getChromeDriver(ChromeOptions cap) {

		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Linux")){
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chrome/chromedriver");
			return new ChromeDriver(cap);
		}
		return null;
	}
	
	public static WebDriver getBrowserInstance() {
		ChromeBrowser obj = new ChromeBrowser();
		WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
		return driver;
	}
	

}
