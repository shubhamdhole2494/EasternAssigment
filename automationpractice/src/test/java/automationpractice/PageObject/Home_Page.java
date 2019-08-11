package automationpractice.PageObject;


import org.openqa.selenium.support.PageFactory;

import automationpractice.base.TestBase;

public class Home_Page extends TestBase {
	public Home_Page_Locator home;
	
	public Home_Page() {
		this.home = new Home_Page_Locator();
		PageFactory.initElements(driver, this.home);
	}
	
	public void clickedOnSignInButton(){
		home.sinInButton.click();
	}

}
