package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseTest;


public class HomePage extends BaseTest {
	
	
	@FindBy(linkText = "Sign in")
	WebElement signinButton;
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
	}
	
	public LoginPage clickonSignIn() {
		signinButton.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	

}
