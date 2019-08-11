package automationpractice.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Nav_bar_locator {
	
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	public WebElement womenNavBar;

}
