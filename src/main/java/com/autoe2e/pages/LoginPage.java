package com.autoe2e.pages;

import javax.sound.midi.Track;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * This is te loginpage class , 
 *  where the objects and actions of the login page are defined
 * 
 * Checking the PR 
 * 
 */

public class LoginPage {
	
	
	public WebDriver driver;
	
	
	
	
	// 1. Colllect the locators
	private By userName =By.id("input-1");
	private By passWord =By.id("input-2");//a[@href='/auth/forgot_password']
	private By LoginButton =By.xpath("//button[@type='button' and contains(@class,'auth-button')]");
	private By forgotPasswordLink =By.xpath("//a[@href='/auth/forgot_password']");
	
	
	//2.Constructor of the Login page class
	
	public  LoginPage(WebDriver driver) {
		
		this.driver= driver;
		
	}
	
	
	//3.Page Actions or the features of the class
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean isForgotPasswordExist() {
		
		return driver.findElement(forgotPasswordLink).isDisplayed();
		
	}
	
	public void enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(passWord).sendKeys(pwd);
	}
	
	
	public void clickOnLogin() {
		driver.findElement(LoginButton).click();
	}
	
	public DashBoardpage doLogin(String Username ,String password ) {
		driver.findElement(userName).sendKeys(Username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(LoginButton).click();
		
		return new DashBoardpage(driver);
	}
	

}
