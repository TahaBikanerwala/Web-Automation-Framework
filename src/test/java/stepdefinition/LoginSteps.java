 	package stepdefinition;

import java.io.IOException;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.BaseFunctions;
import testbase.BaseTest;

public class LoginSteps extends BaseTest{
	
	HomePage homePage;
	LoginPage loginPage;
	EmailPage emailPage;
	BaseFunctions basefunctions = new BaseFunctions();
	public LoginSteps() throws IOException {
		// TODO Auto-generated constructor stub
	}
	@BeforeAll
	public static void before_or_after_all() {
		BaseTest.initBrowser();
	}
	
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() throws Throwable {
		String url = prop.getProperty("ApplicationURL");
		homePage = openWebsite(url);
	}

	@When("User clicks on login")
	public void user_clicks_on_login() throws IOException {
		loginPage = homePage.clickonSignIn();
	}

	@When("^Enters username$")
	public void enters_username() throws IOException {
		String email = basefunctions.getExcelData("data.xls", 0, 1, 0);
		loginPage.enterEmailId(email);
		basefunctions.takeScreeenShot("1.email_entered.png");
	}

	@When("^Enters password$")
	public void enters_password() throws InterruptedException, IOException {
		loginPage.clickOnEmailNxt();
		String password = basefunctions.getExcelData("data.xls", 0, 1, 1);
		loginPage.enterPassword(password);
		basefunctions.takeScreeenShot("2.password_entered.png");
	}

	@Then("^User should be redirected to emailpage$")
	public void user_should_be_redirected_to_homepage() throws IOException {
		emailPage = loginPage.clickOnNextBtn();
	}


}
