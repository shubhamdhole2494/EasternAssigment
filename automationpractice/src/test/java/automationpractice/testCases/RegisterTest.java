package automationpractice.testCases;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationpractice.PageObject.Home_Page;
import automationpractice.PageObject.Nav_bar;
import automationpractice.PageObject.Register_Page;
import automationpractice.PageObject.Register_Page_Locator;
import automationpractice.PageObject.Sign_In_Page;
import automationpractice.base.TestBase;
import automationpractice.utilities.Utilities;

public class RegisterTest extends TestBase{
	
	public static String emailID = Utilities.getAlphaNumericString(6)+"@gmail.com";
	double tPrice;
	double shippingCharge = 2.00;
	public Home_Page home;
	public Sign_In_Page signIn;
	public Register_Page reg;
	public Nav_bar navBar;
	
	
	
	@Test(priority = 1)
	public void registerNewUser() throws IOException{
		TestBase.setUp();
		home = new Home_Page();
		signIn = new Sign_In_Page();
		reg = new Register_Page();
		
		home.clickedOnSignInButton();
		
		signIn.enterEmailAddress(emailID);
		signIn.clickedOnRegisterButton();
		reg.fillRegistrationForm("logi", "tech", "123456", "1", "2019", "1", "logi", "tech", "pune katraj", "pune", "9", "00000", "21", "1234567890", "pune katraj");
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		wait = new WebDriverWait(driver, 5000);
		
		
	}
	@Test(priority = 2)
	public void login() throws IOException{
		
		/*System.out.println(emailID);
		
		home = new Home_Page();
		signIn = new Sign_In_Page();
		home.clickedOnSignInButton();
		signIn.loginToWebsite(emailID, "123456");
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		wait = new WebDriverWait(driver, 5000);*/
		//driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		navBar = new Nav_bar();
		navBar.clickedOnwomenNav();
		wait = new WebDriverWait(driver, 5000);
		
	}
	@Test(priority = 3)
	public void verifyFinalPrice() throws InterruptedException {

		driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
		for (int i = 1; i < 4; i++) {

			driver.findElement(
					By.xpath("//div[@class='button-container col-xs-7 col-md-12']/a[@data-id-product='" + i + "']"))
					.click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
			Thread.sleep(10000);
		}
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		
		List<WebElement> unitPrice = driver.findElements(By.xpath("//td[@data-title='Unit price']/span[@class='price']"));
		String str = "";
		ArrayList<String> str1 = new ArrayList<String>();
		for(WebElement ele : unitPrice){
			str = ele.getText();
			str1.add(str.replaceAll("[-+^:,$]", ""));
		}
		List<Double> newList = new ArrayList<Double>(str1.size()) ;
		for (String myInt : str1) 
        { 
          newList.add(Double.valueOf(myInt)); 
        }
		System.out.println(newList);
		
		double totalProductPrice = 0;
		for(int i=0;i<newList.size();i++){
			totalProductPrice += newList.get(i);
		}
		System.out.println("Total product price" + totalProductPrice);
		
		String totalPrice = driver.findElement(By.xpath("//td[@id='total_product']")).getText();
		totalPrice.replaceAll("[-+^:,$]", "");
		tPrice = Double.valueOf(totalProductPrice);
		Assert.assertEquals(totalProductPrice, tPrice);
	
	}
	@Test(priority = 4)
	public void verifyPriceIncludingShipping(){
		
		
		String wShipping = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
		wShipping.replaceAll("[-+^:,$]", "");
		double shippingP = Double.valueOf(wShipping);
		
			Assert.assertTrue(tPrice+shippingCharge == shippingP);
		
	}
	
	

}
