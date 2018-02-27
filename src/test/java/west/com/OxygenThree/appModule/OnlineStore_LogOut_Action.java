package west.com.OxygenThree.appModule;

import org.openqa.selenium.WebDriver;

import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;

import org.openqa.selenium.support.PageFactory;
import west.com.OxygenThree.pageObjects.OnlineStore_HomePage_POF;
public class OnlineStore_LogOut_Action {
	public static void Execute(WebDriver driver){
		// This is to Instantiate Home Page and LogIn Page class
		//DOMConfigurator.configure("log4j.xml");
		//Log.info("Start login from AppModule Login Action");
		System.out.println("Start logout from AppModule Logout Action");
		OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		HomePage.lnk_MyAccount.click();
	    System.out.println(" Logout Successfully, now it is the time to exit Browser buddy.");
		System.out.println("Complete logout from AppModule Logout Action");
   }

}
