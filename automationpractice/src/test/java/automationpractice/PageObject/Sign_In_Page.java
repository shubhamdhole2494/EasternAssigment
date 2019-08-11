package automationpractice.PageObject;


import org.openqa.selenium.support.PageFactory;

import automationpractice.base.TestBase;

public class Sign_In_Page extends TestBase {
	
	public Sign_In_Page_Locator singInPage;
	
	public Sign_In_Page(){
		this.singInPage = new Sign_In_Page_Locator();
		PageFactory.initElements(driver, this.singInPage);
	}
	
	public void clickedOnRegisterButton(){
		
		singInPage.registerButton.click();
	}
	
	public void enterEmailAddress(String email){
		
		singInPage.register_emailField.sendKeys(email);
	}
	
	public void loginToWebsite(String email, String pass){
		singInPage.signIn_emailField.sendKeys(email);
		singInPage.signIn_passwordField.sendKeys(pass);
		singInPage.signIn_button.click();
	}
	
	
	
	
	

}
