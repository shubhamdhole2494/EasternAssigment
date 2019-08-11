package automationpractice.PageObject;

import org.openqa.selenium.support.PageFactory;

import automationpractice.base.TestBase;

public class Nav_bar extends TestBase {
	
	public Nav_bar_locator navBar;
	
	public Nav_bar(){
		this.navBar = new Nav_bar_locator();
		PageFactory.initElements(driver, this.navBar);
	}
	
	public void clickedOnwomenNav(){
		navBar.womenNavBar.click();
	}

}
