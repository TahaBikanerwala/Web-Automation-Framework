package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utils.Constants;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		prop.load(fis);
	} 
	
	public static void initBrowser() {
		String browser = (String) prop.get("browser");
//		String browser = "chrome";
		if(browser.equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Other Browser mentioned");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
//		String url = prop.getProperty("ApplicationURL");
//		driver.get(url);
	}
	
	public HomePage openWebsite(String url) {
		driver.get(url);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
