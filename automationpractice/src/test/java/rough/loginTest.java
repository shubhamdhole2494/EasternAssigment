package rough;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationpractice.base.TestBase;
import automationpractice.utilities.Utilities;

public class loginTest extends TestBase{
	
	double shippingCharge = 2.00;
	@Test
	public  void testPra() throws IOException, InterruptedException{
		
		setUp();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		String emailId = Utilities.getAlphaNumericString(6)+"@gmail.com";
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("logitech1@gmail.com");
		System.out.println(emailId);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		//Assert.assertEquals(currentURL, "http://automationpractice.com/index.php?controller=my-account");
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
		List<WebElement> product = driver.findElements(By.xpath("//a[@title='Add to cart']"));
		List<WebElement> product2 = driver.findElements(By.xpath("//span[contains(text(),'Add to cart')]"));
		//WebElement ele = driver.findElement(By.id("fancybox-frame1565515924966"));
		//System.out.println(size);
		//div[@class='button-container col-xs-7 col-md-12']/a[@data-id-product='2']
		
		for(int i=1;i<4;i++){
			
			driver.findElement(By.xpath("//div[@class='button-container col-xs-7 col-md-12']/a[@data-id-product='" +i
					+ "']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
			Thread.sleep(5000);
		}
		
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		
		List<WebElement> unitPrice = driver.findElements(By.xpath("//td[@data-title='Unit price']/span[@class='price']"));
		String str = "";
		ArrayList<String> str1 = new ArrayList<String>();
		for(WebElement ele : unitPrice){
			
			str = ele.getText();
			
			
			str1.add(str.replaceAll("[-+^:,$]", ""));
			
		}
		//System.out.println(str1);
		//ArrayList<Integer> resultList = getIntegerArray(str1);
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
		double tPrice = Double.valueOf(totalProductPrice);
		Assert.assertEquals(totalProductPrice, tPrice);
		System.out.println("pass");
		String wShipping = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
		System.out.println(wShipping);
		String str2 = wShipping.replaceAll("[-+^:,$]", "");
		double shippingP = Double.parseDouble(str2);
		System.out.println(shippingP);
		//System.out.println(shippingP);*/
		/*double ttt = tPrice + shippingCharge;
		System.out.println(ttt);*/
		
	
	}
	
	public ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
               //System.out.println("Could not parse " + nfe);
               
            } 
        }       
        return result;
    }

}
