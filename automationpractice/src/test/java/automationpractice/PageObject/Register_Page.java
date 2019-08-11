package automationpractice.PageObject;


import org.openqa.selenium.support.PageFactory;


import automationpractice.base.TestBase;
import automationpractice.utilities.Utilities;

public class Register_Page extends TestBase{
	
	public Register_Page_Locator registerPage;
	
	
	public Register_Page(){
		
		this.registerPage = new Register_Page_Locator();
		PageFactory.initElements(driver, this.registerPage);
	}
	
	public void fillRegistrationForm(String fname ,String lname,String pass,String day, String year, String month, String fname2, String lname2, String address, String city, String state, String postCode, String cuntry, String phone, String alisAddress){
		registerPage.selectTitle.click();
		log.debug("Select Title");
		registerPage.cust_firstName.sendKeys(fname);
		log.debug("Enter first name");
		registerPage.cust_lastName.sendKeys(lname);
		log.debug("Enter last name");
		registerPage.password.sendKeys(pass);
		log.debug("Enter password");
		//registerPage.email.sendKeys(email);
		Utilities.dropDownUtilities(registerPage.dayDropdown, day);
		log.debug("Enter day");
		Utilities.dropDownUtilities(registerPage.monthsDropdown, month);
		log.debug("Enter month");
		Utilities.dropDownUtilities(registerPage.yearsDropDown, year);
		log.debug("Enter year");
		registerPage.firstName.sendKeys(fname2);
		registerPage.lastName.sendKeys(lname2);
		registerPage.address.sendKeys(address);
		registerPage.city.sendKeys(city);
		Utilities.dropDownUtilities(registerPage.state, state);
		registerPage.postCode.sendKeys(postCode);
		Utilities.dropDownUtilities(registerPage.county, cuntry);
		registerPage.phoneNumber.sendKeys(phone);
		registerPage.aliasAddress.sendKeys(alisAddress);
		registerPage.registerButton.click();
	}
	
	

}
