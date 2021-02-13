package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.autoe2e.factory.DriveFactory;
import com.autoe2e.pages.DashBoardpage;
import com.autoe2e.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardPageSteps {

	private LoginPage loginPage = new LoginPage(DriveFactory.getDriver());
	private DashBoardpage dashbord;
	public String dashboardTitle;



	@Given("User is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable dataTable) {

		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("Username");
		String password = credList.get(0).get("Password");

		DriveFactory.getDriver().get("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login");
		dashbord = loginPage.doLogin(username, password);

	}


	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {


		dashboardTitle = dashbord.getDashBoardPageTitle();


	}

	@Then("title of the page should be {string}")
	public void title_of_the_page_should_be(String string) {

		Assert.assertTrue(dashboardTitle.contains(string)); 

	}

	@Given("User is on the Dashboard page")
	public void user_is_on_the_dashboard_page() {



	}

	@Then("User gets the links count")
	public void user_gets_the_links_count(DataTable footerlinks) {

		List<String> expFooterLinks = footerlinks.asList();
		System.out.println("Expected footerlinks are" + expFooterLinks );

		List<String> actualFooterLinks = dashbord.getFooterLinks();
		System.out.println("Actual footerlinks are" + actualFooterLinks );

		Assert.assertTrue(expFooterLinks.containsAll(actualFooterLinks));

	}

	@Then("Links count should be {int}")
	public void links_count_should_be(Integer footersSize) {

		Assert.assertTrue(dashbord.getFooterLinksSize()==footersSize);	    
	}

}
