/**
 * 
 */
package hooks;

import java.util.Properties;

import org.apache.pdfbox.util.filetypedetector.FileType;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.autoe2e.factory.DriveFactory;
import com.autoe2e.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author PRAAMBI
 *This class is used  to define the hooks  for predefined methods to launch  the broswer and teardown the broowser
 */
public class ApplciationHooks {

	private DriveFactory driverfactory;
	private ConfigReader configread;
	private WebDriver driver;
	private Properties prop;

	
	
	/*How to skip a scenario in excecution using the hooks concepts*/
	@Before(value = "@Skip_scenario",order = 0)
	public void skip_scenario(Scenario scenario){
		System.out.println("SKIPPED SCENARIO IS " +scenario.getName() );
		Assume.assumeTrue(false);


	}




	@Before(order = 1)
	public void getProperty(){

		configread = new ConfigReader();
		prop = configread.init_properties();

	}


	@Before(order = 2)
	public void launchBrowser(){

		String browserName = prop.getProperty("browser");
		driverfactory = new DriveFactory();
		driver = driverfactory.initialise_driver(browserName);


	}

	@After(order = 0)
	public void quitBrowser() {

		driver.quit();
	}



	/*
	 * 
	 * Take the output type of file as Bytes , as its easy,
	 * to  show the screenshots in reports of any CI/CD tools as jenkins
	 */
	@After(order = 1)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			String scenarioName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", scenarioName);

		}


	}

}
