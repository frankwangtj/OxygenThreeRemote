package west.com.OxygenThree.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import west.com.OxygenThree.utility.FileSystems;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import west.com.OxygenThree.utility.Log;

public class DebugUtils {
	//static WebDriver driver;
	
	// In order to use the PageFactory, first declare some fields on a PageObject that are WebElements
	//static WebElement log;
	//static WebElement pwd;
	//static WebElement submit;
	//static WebElement account;
	//static WebElement account_logout;
	String sFunction="|Class-testcases|Method-DebugUtils| ";


	// Following TestNg Test case pattern, and divided a Test case in to three different part.
	// In Before Method, your code will always be the same for every other test case.
	// In other way before method is your prerequisites of your main Test Case	
	@Test
	public void ExecuteDebugUtils() throws InterruptedException {
				
		//Log.info("Launch onlinestore website");
		//driver.get("http://www.store.demoqa.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// In order for this code to work and not throw a NullPointerException because 
		// the "log", "pwd" nd "submit" fields aren't instantiated, we need to initialise the PageObject
		//PageFactory.initElements(driver, RunTestCase_POFV1.class);
		// Once Instantiated, we can now use the above created WebElements
		
		//OnlineStore_HomePage.lnk_MyAccount(driver).click();
		//account.click();
		
		//Thread.sleep(2000);
		
		//Verify Function isFolderExist
		//-------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\test";
		//Boolean bExist;
		//try {
		//	bExist=FileSystems.isFolderExists(sFolder);
			
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//-------------------------------------------------------------------------
		//Verify Function getFileSize
		//-------------------------------------------------------------------------
		//String sFolder="D:\\FRWeb\\004_FileSystemPractice\\TestFolder";
		//String sFile="testx.txt";
		//long lSize;
		//try {
		//	 lSize=FileSystems.getFileSize(sFolder, sFile);
			
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		//Verify Function isFileExists
				String sActFile="D:\\FRWeb\\004_FileSystemPractice\\TestFolder\\SipLog.txt";
				
				boolean bExists;
				try {
					 bExists=FileSystems.isFileExists(sActFile);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}
	@BeforeMethod
	public void beforeMethod() {
		// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
		// http://www.toolsqa.com/test-case-with-log4j/
    	// http://www.toolsqa.com/log4j-logging/
		//Log4j should be initialize at least once!!!
		DOMConfigurator.configure("log4j.xml");
		//System.setProperty("webdriver.gecko.driver","D:\\FRWeb\\003_RunningEnvironment\\02_GeckoDriver16\\geckodriver.exe");
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start to test--" +sFunction);
		Log.info("Start to test--" +sFunction);
		
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Complete the test--"+sFunction);
		Log.info("Complete the test--"+sFunction);
		//driver.quit();
	}

}
