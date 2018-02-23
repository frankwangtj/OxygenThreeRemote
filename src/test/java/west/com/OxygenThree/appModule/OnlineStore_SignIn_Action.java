package west.com.OxygenThree.appModule;
import org.openqa.selenium.WebDriver;

import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;

import org.openqa.selenium.support.PageFactory;
import west.com.OxygenThree.pageObjects.OnlineStore_HomePage_POF;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage_POF;

public class OnlineStore_SignIn_Action {
	public static void Execute(WebDriver driver){
		// This is to Instantiate Home Page and LogIn Page class
		//DOMConfigurator.configure("log4j.xml");
		//Log.info("Start login from AppModule Login Action");
		System.out.println("Start login from AppModule Login Action");
		OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
		HomePage.lnk_MyAccount.click();
	    LoginPage.txtbx_UserName.sendKeys("testuser_12345678");
	    LoginPage.txtbx_Password.sendKeys("Test@123");
	    LoginPage.btn_Login.click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		System.out.println("Complete login from AppModule Login Action");
   }

}
