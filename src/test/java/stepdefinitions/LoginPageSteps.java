package stepdefinitions;

import org.junit.Assert;

import com.autoe2e.factory.DriveFactory;
import com.autoe2e.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String loginPageTitle;
	private LoginPage loginPage = new LoginPage(DriveFactory.getDriver());
	
	
	@Given("User is on the Hackerrank page")
	public void user_is_on_the_hackerrank_page() {
	    
		DriveFactory.getDriver().get("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login");
		
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		loginPageTitle = loginPage.getLoginPageTitle();
	  
	}

	@Then("the page title should be  {string}")
	public void the_page_title_should_be(String expected) {
		
		Assert.assertTrue(loginPageTitle.contains(expected));
	    
	}

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Forgot password link should be present")
	public void forgot_password_link_should_be_present() {
	   
		
		boolean forgotLink = loginPage.isForgotPasswordExist();
		Assert.assertTrue(forgotLink);
	}

	@When("user enters the emails id {string}")
	public void user_enters_the_emails_id(String userName) {
		
		loginPage.enterUserName(userName);
	  
	}

	@When("User enters the password {string}")
	public void user_enters_the_password(String pwd) {
		
		loginPage.enterPassword(pwd);
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		
		loginPage.clickOnLogin();
	   
	}

	@Then("User should navigate to the home page and Title should be {string}")
	public void user_should_navigate_to_the_home_page_and_title_should_be(String HomeTitle) {
		
		
		Assert.assertTrue(loginPageTitle.contains(HomeTitle));

}
	
}
