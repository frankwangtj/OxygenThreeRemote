package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import west.com.OxygenThree.pageObjects.OnlineStore_HomePage;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage;
import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import java.util.concurrent.TimeUnit;

public class RunTestCase_POFAnnotation {
	static WebDriver driver;

	 @FindBy(how = How.XPATH, using = ".//*[@id='account']/a")
	 static WebElement lnk_MyAccount;

	 @FindBy(how = How.ID, using = "log")
	 static WebElement txtbx_UserName;

	 @FindBy(how = How.ID, using = "pwd")
	 static WebElement txtbx_Password;

	 @FindBy(how = How.NAME, using = "submit")
	 static WebElement btn_Login ;

	 @FindBy(how = How.XPATH, using = ".//*[@id='account_logout']/a")
	 static WebElement lnk_LogOut;
	


	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void RunSpecificTestCasePOFAnnotation() throws InterruptedException {
				
		Log.info("Launch onlinestore website");
		driver.get("http://www.store.demoqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// In order for this code to work and not throw a NullPointerException because 
		// the "log", "pwd" nd "submit" fields aren't instantiated, we need to initialise the PageObject
		PageFactory.initElements(driver, RunTestCase_POFAnnotation.class);
		// Once Instantiated, we can now use the above created WebElements
		
		//OnlineStore_HomePage.lnk_MyAccount(driver).click();
		lnk_MyAccount.click();
		
		//OnlineStore_LoginPage.txtbx_UserName(driver).sendKeys("testuser_12345678");
		txtbx_UserName.sendKeys("testuser_12345678");
		//OnlineStore_LoginPage.txtbx_Password(driver).sendKeys("Test@123");
		txtbx_Password.sendKeys("Test@123");
		//OnlineStore_LoginPage.btn_LogIn(driver).click();
		btn_Login.click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		//OnlineStore_HomePage.lnk_LogOut(driver).click();
		lnk_LogOut.click();
		System.out.println(" Logout Successfully.");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
    	// http://www.toolsqa.com/log4j-logging/
		DOMConfigurator.configure("log4j.xml");
		
		System.setProperty("webdriver.gecko.driver","C:\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Start to test--RunTestCase PageObjectFactory Annotation");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test-RunTestCase PageObjectFactory Annotation");
		driver.quit();
	}

}
