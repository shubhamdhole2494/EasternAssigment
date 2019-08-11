package automationpractice.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page_Locator {

	
	@FindBy(xpath = "//a[@class='login']")
	public WebElement sinInButton;
}
