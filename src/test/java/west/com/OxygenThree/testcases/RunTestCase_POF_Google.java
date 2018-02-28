package west.com.OxygenThree.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import west.com.OxygenThree.utility.Web;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;

import java.util.concurrent.TimeUnit;

public class RunTestCase_POF_Google {
	public WebDriver driver;
	@Test
	public void RunSpecificTestCasePOFAnnotationSeparate() throws InterruptedException {
				
		Log.info("Launch google website");
		driver.get("http://10.103.63.19/mis");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebElement txtUser=driver.findElement(By.id("txtUser"));
		
		//txtUser.sendKeys("admin");
		driver.close();
				
		// This is to Instantiate Home Page and LogIn Page class  
		//OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		//OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
		
		
		// Once both classes Initialised, use their Web Element Objects
		//HomePage.lnk_MyAccount.click();
		//LoginPage.txtbx_UserName.sendKeys("testuser_12345678");
		//LoginPage.txtbx_Password.sendKeys("Test@123");
		//LoginPage.btn_Login.click();
		//System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		
		//OnlineStore_SignIn_Action.Execute(driver);
		
		//HomePage.lnk_LogOut.click();
		//ystem.out.println(" Logout Successfully.");
		//OnlineStore_LogOut_Action.Execute(driver);
		
	}
	@BeforeMethod
	public void beforeMethod() throws Exception {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
		// http://www.toolsqa.com/log4j-logging/
		DOMConfigurator.configure("log4j.xml");
		//driver = Web.OpenBrowser("Mozilla");	
		driver = Web.OpenBrowser("IE");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod() throws Exception {
		System.out.println("Complete the test-RunTestCase PageObjectFactory Annotation Separate For Google");
		//driver.quit();
		//Web.closeBrowser(driver, "IE");
	}


}
