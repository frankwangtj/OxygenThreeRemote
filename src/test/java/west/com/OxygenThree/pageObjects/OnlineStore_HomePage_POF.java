package west.com.OxygenThree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OnlineStore_HomePage_POF {
	final WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='account']/a")
	public WebElement lnk_MyAccount;

	@FindBy(how = How.XPATH, using = ".//*[@id='account_logout']/a")
	public WebElement lnk_LogOut;

	// This is a constructor, as every page need a base driver to find web elements

	public OnlineStore_HomePage_POF(WebDriver driver) {
		this.driver = driver;
	}

}
