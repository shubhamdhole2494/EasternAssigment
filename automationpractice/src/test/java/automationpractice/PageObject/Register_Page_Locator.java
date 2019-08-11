package automationpractice.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page_Locator {

	
	@FindBy(id = "uniform-id_gender1")
	WebElement selectTitle;
	
	@FindBy(id = "customer_firstname")
	WebElement cust_firstName;
	
	@FindBy(id = "customer_lastname")
	WebElement cust_lastName;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	public WebElement password;
	
	@FindBy(id = "days")
	public WebElement dayDropdown;
	
	@FindBy(id = "months")
	public WebElement monthsDropdown;
	
	@FindBy(id = "years")
	public WebElement yearsDropDown;
	
	@FindBy(id = "firstname")
	public WebElement firstName;
	
	@FindBy(id = "lastname")
	public WebElement lastName;
	
	@FindBy(id = "address1")
	public WebElement address;
	
	@FindBy(id = "city")
	public WebElement city;
	
	@FindBy(id = "id_state")
	public WebElement state;
	
	@FindBy(id = "postcode")
	public WebElement postCode;
	
	@FindBy(id = "id_country")
	public WebElement county;
	
	@FindBy(id = "phone_mobile")
	public WebElement phoneNumber;
	
	@FindBy(id = "alias")
	public WebElement aliasAddress;
	
	@FindBy(xpath = "//button[@id='submitAccount']")
	public WebElement registerButton;
	
}
