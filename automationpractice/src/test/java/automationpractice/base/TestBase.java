package automationpractice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static final Logger log = LogManager.getLogger(TestBase.class.getName());
	
	
	//@BeforeSuite
	public static void setUp() throws IOException{
		if(driver==null){
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/properties/config.properties");
			config.load(fis);
			log.debug("Config file Loaded");
			
			if(config.getProperty("browser").equals("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome browser opened");
			}else if(config.getProperty("browser").equals("firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(config.getProperty("browser").equals("IE")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/IEDriverServer.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			log.debug("Maximize");
			driver.get(config.getProperty("baseURL"));
			log.debug("Get URL");
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
		}
		
		
	}
	//@AfterSuite
	public static void tearDown(){
		driver.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/log4j.properties");
		config.setProperty("user", "abcd");
		config.load(fis);
	}

}
