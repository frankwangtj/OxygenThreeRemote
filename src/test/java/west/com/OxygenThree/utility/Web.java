package west.com.OxygenThree.utility;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web {
	public static WebDriver driver = null;
	public static WebDriver OpenBrowser(String sBrowserName) throws Exception{
		//String sBrowserName;
		String sProjectName;
		try{
			//--- KEEP in mind, if browser type is IE, we need to setup security and ADD the site to trust zone
			//---------------------------------------------------------------------------------------------------
			
			
			//
			//sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			//sBrowserName=Constant.sBrowserType;
			//sProjectName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Project);
			if(sBrowserName.equals("Mozilla")){
				//WebDriver driver1;
				//DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
				//firefoxCapabilities.setCapability("marionette", true);
				System.setProperty("webdriver.gecko.driver",Constant.Path_Geckodriver+"\\geckodriver.exe");
				driver = new FirefoxDriver();
				Log.info("New driver instantiated for FireFox");
				//Options opts = driver.manage();
				//Timeouts to = opts.timeouts();
				//to.implicitlyWait(new Long(20), TimeUnit.SECONDS);
		
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 5 seconds");
				
	    
				
				//driver.get(Constant.URL_Google);
				//Log.info("Onlinestore is the project name");
	   
				//Log.info("Onlinestore Web application launched successfully");
			}
			else if (sBrowserName.equals("IE")) {
				//--- KEEP in mind, if browser type is IE, we need to setup security and ADD the site to trust zone
				//---------------------------------------------------------------------------------------------------
				//WebDriver obj = new InternetExplorerDriver();
				//System.setProperty("webdriver.ie.driver", "F:\\RemoteRepoSquareOne\\OnlineStoreSquareOne\\IEExecutable\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",Constant.Path_IE+"\\IEDriverServer.exe");
				//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver=new InternetExplorerDriver();
				Log.info("IE browser started");
		
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 1 seconds");
				//Thread.sleep(2000);
				//driver.get(Constant.URL_PMIS);	
		    	//Log.info("PMIS Web application launched successfully");
	    
	        
	
		
	}
	}catch (Exception e){
		Log.error("Class Utils-Web | Method OpenBrowser | Exception desc : "+e.getMessage());
		e.printStackTrace();
	}
	return driver;
	}
}


