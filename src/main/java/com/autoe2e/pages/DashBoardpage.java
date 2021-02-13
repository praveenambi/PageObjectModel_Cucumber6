package com.autoe2e.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardpage {

	private WebDriver driver;

	// 1. Colllect the locators
	private By footerLinks =By.xpath("//ul[@class='footer-links']//a");

	public DashBoardpage(WebDriver driver) {


		this.driver= driver;
	}
	
	public String getDashBoardPageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public int getFooterLinksSize() {
		
		 return driver.findElements(footerLinks).size()-1;
		
	}


	public List<String> getFooterLinks() {
		List<String> footlinkstext = new ArrayList<String>();

		List<WebElement> footerlinks = driver.findElements(footerLinks);

		for (WebElement element : footerlinks) {
			String eletext = element.getText();
			System.out.println("FooterLinks " + eletext);
			footlinkstext.add(eletext);

		}
		
		return footlinkstext;

	}

}
