package com.autoe2e.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties props;
	
	
	/*
	 * This method is used to initilaise the properties file.
	 */
	
	public Properties init_properties() {
		props = new Properties();
		try {
			FileInputStream inputstream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/autoe2e/config/config.properties");
		
			props.load(inputstream);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return props;
	}
	
	
	

}
