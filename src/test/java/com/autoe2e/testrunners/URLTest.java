package com.autoe2e.testrunners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login");
		
		System.out.println("The test driver title is  " + driver.getTitle());
		driver.quit();
		
		
	}

}
