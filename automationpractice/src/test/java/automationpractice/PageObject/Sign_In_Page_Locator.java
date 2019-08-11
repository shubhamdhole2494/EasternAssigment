package automationpractice.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sign_In_Page_Locator {
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	public WebElement registerButton;
	
	@FindBy(xpath = "//input[@id='email_create']")
	public WebElement register_emailField;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement signIn_emailField;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement signIn_passwordField;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public WebElement signIn_button;
	
	

}
