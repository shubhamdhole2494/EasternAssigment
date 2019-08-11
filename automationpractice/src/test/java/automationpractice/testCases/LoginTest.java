package automationpractice.testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationpractice.PageObject.Home_Page;
import automationpractice.PageObject.Register_Page;
import automationpractice.PageObject.Sign_In_Page;
import automationpractice.base.TestBase;

public class LoginTest extends TestBase {

	public Home_Page home;
	public Sign_In_Page signIn;
	public Register_Page reg;

	@Test
	public void login() throws IOException {

		System.out.println(RegisterTest.emailID);
		TestBase.setUp();
		home = new Home_Page();
		signIn = new Sign_In_Page();
		home.clickedOnSignInButton();
		signIn.loginToWebsite(RegisterTest.emailID, "123456");
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		wait = new WebDriverWait(driver, 5000);
		TestBase.tearDown();

	}
}
