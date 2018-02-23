package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.support.PageFactory;

import west.com.OxygenThree.pageObjects.OnlineStore_HomePage_POF;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage_POF;
import west.com.OxygenThree.appModule.OnlineStore_SignIn_Action;
import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import java.util.concurrent.TimeUnit;

public class RunTestCase_POFAnnotationSeparate {
	static WebDriver driver;

	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void RunSpecificTestCasePOFAnnotationSeparate() throws InterruptedException {
				
		Log.info("Launch onlinestore website");
		driver.get("http://www.store.demoqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		// This is to Instantiate Home Page and LogIn Page class  
		OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
		
		
		// Once both classes Initialised, use their Web Element Objects
		//HomePage.lnk_MyAccount.click();
		//LoginPage.txtbx_UserName.sendKeys("testuser_12345678");
		//LoginPage.txtbx_Password.sendKeys("Test@123");
		//LoginPage.btn_Login.click();
		//System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		
		OnlineStore_SignIn_Action.Execute(driver);
		
		HomePage.lnk_LogOut.click();
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
		System.out.println("Start to test--RunTestCase PageObjectFactory Annotation Separate");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test-RunTestCase PageObjectFactory Annotation Separate");
		driver.quit();
	}

}
