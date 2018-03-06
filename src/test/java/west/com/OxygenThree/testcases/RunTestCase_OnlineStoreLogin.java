package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import west.com.OxygenThree.pageObjects.OnlineStore_HomePage;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage;
import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import java.util.concurrent.TimeUnit;

public class RunTestCase_OnlineStoreLogin {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void RunSpecificTestCase() throws InterruptedException {
		
		//driver.get("http://www.google.com");
		Log.info("Launch onlinestore website");
		driver.get("http://www.store.demoqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		OnlineStore_HomePage.lnk_MyAccount(driver).click();
		OnlineStore_LoginPage.txtbx_UserName(driver).sendKeys("testuser_12345678");
		OnlineStore_LoginPage.txtbx_Password(driver).sendKeys("Test@123");
		OnlineStore_LoginPage.btn_LogIn(driver).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Thread.sleep(2000);
		OnlineStore_HomePage.lnk_LogOut(driver).click();
		OnlineStore_HomePage.lnk_LogOut(driver).click();
		System.out.println(" Logout Successfully.");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
    	// http://www.toolsqa.com/log4j-logging/
		DOMConfigurator.configure("log4j.xml");
		
		System.setProperty("webdriver.gecko.driver", "D:\\FRWeb\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Start to test--RunTestCase");
		//System.out.println("Add from slave machine");
		//Update at slave after second clone
		//Update by master machine after cloned
		//update from slave one more time
		//Submit update
		//Modify on slave after USB key setup
		//Modify and sync with slave
		//Log.info("Test started--RunTestCase");
		//Log.debug("output on console");
		//Log.debug("test");
		//Log.error("sth wrong");
		//Log.startTestCase("RunTestCase");
		//Log.endTestCase("RunTestCase");
		//Log.warn("warning");
		//Log.step("step1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Add comment to submit to USB
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test-RunTestCase");
		driver.quit();
	}
}
