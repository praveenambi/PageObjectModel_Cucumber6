package com.autoe2e.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriveFactory {
	
	
	public WebDriver driver ;
	public static ThreadLocal<WebDriver> TLocalDriver = new ThreadLocal<WebDriver>();
	
	
	/*
	 *  This method is used to initialise the webdriver based on the locathread instance
	 * 
	 */
	
	public WebDriver initialise_driver(String browsername) {
		
		if (browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//WebDriverManager.chromedriver().browserVersion("88.0.4324.104 ").setup();
			
			TLocalDriver.set(new ChromeDriver());
			
		} else if (browsername.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			TLocalDriver.set(new FirefoxDriver());
			
		}else if (browsername.equals("safari")) {
			
			TLocalDriver.set(new SafariDriver());
			
		}
		else {
			
			System.out.println("Please pass the required broswer name");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	/*
	 * This method is used to get the synchronised driver instance, so that helps in the parellel execution
	 */
	public static synchronized WebDriver getDriver() {
		
		return TLocalDriver.get();
		
	}
	
	
	
	
	
	
	
	
	

}
