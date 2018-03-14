package west.com.OxygenThree.DataDriven;

import west.com.OxygenThree.utility.Constant;
import west.com.OxygenThree.utility.Log;
import org.openqa.selenium.WebDriver;	//for web driver
import java.util.concurrent.TimeUnit;	//for time unit

import org.openqa.selenium.support.PageFactory;	//for page factory
import west.com.OxygenThree.pageObjects.OnlineStore_HomePage_POF;
import west.com.OxygenThree.pageObjects.OnlineStore_LoginPage_POF;

public class OnlineStore_DataDriven_LoginLogout {
	public static boolean Execute(WebDriver driver, String sUser, String sPass ) throws Exception{
		String sFunction="|Class DataDriven.OnlineStore_DataDriven_LoginLogout | Method Execute |";
		if (Constant.bDebugMode) {
			System.out.println("Function---"+sFunction+"--- gets Started");
		}
		Log.info("Function---"+sFunction+"--- gets Started");
		boolean bRtn;
		bRtn=false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			OnlineStore_HomePage_POF HomePage = PageFactory.initElements(driver, OnlineStore_HomePage_POF.class);
			OnlineStore_LoginPage_POF LoginPage = PageFactory.initElements(driver, OnlineStore_LoginPage_POF.class);
			HomePage.lnk_MyAccount.click();
			LoginPage.txtbx_UserName.sendKeys(sUser);
			LoginPage.txtbx_Password.sendKeys(sPass);
			LoginPage.btn_Login.click();
			Thread.sleep(2000);
			System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
			System.out.println("Complete login from AppModule Login Action");
			HomePage.lnk_LogOut.click();
			Thread.sleep(2000);
			//HomePage.lnk_LogOut.click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    System.out.println(" Logout Successfully, now it is the time to exit Browser buddy.");
			System.out.println("Complete logout from AppModule Logout Action");
			if (Constant.bDebugMode) {
				System.out.println("Function---"+sFunction+"--- gets succeed");
				Log.info("Function---"+sFunction+"--- gets succeed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			Log.info("Function---"+sFunction+"--- gets completed");
			bRtn=true;
			
		} catch (Exception e) {
			if (Constant.bDebugMode) {
				System.out.println(sFunction+" ---Exception desc : "+e.getMessage());
				System.out.println("Function---"+sFunction+"--- gets Failed");
				Log.info("Function---"+sFunction+"--- gets Failed");
				System.out.println("Function---"+sFunction+"--- gets completed");
			}
			
			Log.error(sFunction+"Exception desc : "+e.getMessage());
			Log.info("Function---"+sFunction+"--- gets completed");
			throw (e);
			
			
		}
		return bRtn;
   }

}
