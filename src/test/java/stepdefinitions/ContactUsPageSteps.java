package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.autoe2e.factory.DriveFactory;
import com.autoe2e.pages.ContactUSPage;
import com.autoe2e.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	
	private ContactUSPage contactUS = new ContactUSPage(DriveFactory.getDriver());
	
	
	@Given("User navugates to the contact page")
	public void user_navugates_to_the_contact_page() {
		DriveFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
		
	}

	@When("User fill the form using the given Sheet name {string} and rownumber {int}")
	public void user_fill_the_form_using_the_given_sheet_name_and_rownumber(String sheetName, Integer rowNum) {
		
		ExcelReader reader = new ExcelReader();
		try {
			List<Map<String, String>>  testData = reader.getData("./ExcelData/UserDetails.xlsx", sheetName);
			String heading = testData.get(rowNum).get("Subject Heading");
			String emailID = testData.get(rowNum).get("Email address");
			String OrderPref = testData.get(rowNum).get("Order reference");
			String message = testData.get(rowNum).get("Message");
			
			contactUS.fillContactUsForm(heading, emailID, OrderPref, message);
			
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@When("User click on the send button")
	public void user_click_on_the_send_button() {
		
		contactUS.clickSend();
		
	}

	@Then("user see a success message {string}")
	public void user_see_a_success_message(String expctedmsg) {
		String actualMSg = contactUS.getSuccessMessg();
		Assert.assertEquals(actualMSg, expctedmsg);
		
		
	}

}
