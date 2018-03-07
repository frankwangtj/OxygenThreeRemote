package west.com.OxygenThree.appModule;

import org.openqa.selenium.WebDriver;

import west.com.OxygenThree.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;

import org.openqa.selenium.support.PageFactory;
import west.com.OxygenThree.pageObjects.OnlineStore_HomePage_POF;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage_POF;

public class OnlineStore_SignInWithPara_Action {
	public static void Execute(WebDriver driver, String sUsername, String sPassword ) throws InterruptedException{
		// This is to Instantiate Home Page and LogIn Page class
		//DOMConfigurator.configure("log4j.xml");
		//Log.info("Start login from AppModule Login Action");
		String sFunction="OnlineStore_SignInWithPara_Action";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start login from AppModule "+sFunction);
		OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
		OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
		HomePage.lnk_MyAccount.click();
	    LoginPage.txtbx_UserName.sendKeys(sUsername);
	    LoginPage.txtbx_Password.sendKeys(sPassword);
	    LoginPage.btn_Login.click();
		Thread.sleep(2000);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		System.out.println("Complete login from AppModule "+sFunction);
   }
}
