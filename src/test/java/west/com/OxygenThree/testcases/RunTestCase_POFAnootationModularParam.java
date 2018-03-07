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
import west.com.OxygenThree.appModule.OnlineStore_SignInWithPara_Action;
import west.com.OxygenThree.appModule.OnlineStore_LogOut_Action;
import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import java.util.concurrent.TimeUnit;

public class RunTestCase_POFAnootationModularParam {
	static WebDriver driver;
	String sFunction="RunTestCase_POFAnootationModularParam";

	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void RunSpecificTestCasePOFAnnotationSeparate() throws InterruptedException {
		String sUser="testuser_12345678";
		String sPass="Test@123";
				
		Log.info("Launch onlinestore website");
		driver.get("http://www.store.demoqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		// This is to Instantiate Home Page and LogIn Page class  
		OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
		
			
		OnlineStore_SignInWithPara_Action.Execute(driver, sUser, sPass);
		Thread.sleep(2000);
		//HomePage.lnk_LogOut.click();
		//ystem.out.println(" Logout Successfully.");
		OnlineStore_LogOut_Action.Execute(driver);
		
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
		// http://www.toolsqa.com/log4j-logging/
		DOMConfigurator.configure("log4j.xml");
		
		System.setProperty("webdriver.gecko.driver","D:\\FRWeb\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Start to test--"+sFunction);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test-"+sFunction);
		driver.quit();
	}


}
