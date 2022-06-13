package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseFunctions;
import testbase.BaseTest;

public class LoginPage extends BaseTest {
	BaseFunctions basefunctions = new BaseFunctions();
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	
	@FindBy(id = "identifierId")
	WebElement emailId;
	
	@FindBy(css = "#identifierNext > div > button > span")
	WebElement emailNxtBtn;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextBtn;

	public void enterEmailId(String email) {
		emailId.sendKeys(email);
	}
	
	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}
	
	public EmailPage clickOnNextBtn() throws IOException {
		nextBtn.click();
		basefunctions.takeScreeenShot("3.logged_in.png");
		return PageFactory.initElements(driver, EmailPage.class);
	}
	
	public void clickOnEmailNxt() {
		emailNxtBtn.click();
	}
}
