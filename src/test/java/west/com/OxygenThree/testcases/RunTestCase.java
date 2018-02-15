package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class RunTestCase {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void RunSpecificTestCase() {
		driver.get("http://www.google.com");
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
    		// http://www.toolsqa.com/log4j-logging/
		System.setProperty("webdriver.gecko.driver","C:\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Start to test--RunTestCase");
		System.out.println("Add from slave machine");
		//Update at slave after second clone
		//Update by master machine after cloned
		//update from slave one more time
	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
