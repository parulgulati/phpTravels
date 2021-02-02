package StepdefFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.PHPTravelsLoginPage;
import pageobjects.PHPTravelsHomePage;
import pageobjects.PHPTravelsSupplierLoginPage;

public class UserLoginAccountStepDef extends BaseClass {

	private PHPTravelsLoginPage loginpage = PageFactory.initElements(driver, PHPTravelsLoginPage.class);
	private PHPTravelsHomePage homepage = PageFactory.initElements(driver, PHPTravelsHomePage.class);
	private PHPTravelsSupplierLoginPage supLogin = PageFactory.initElements(driver, PHPTravelsSupplierLoginPage.class);

	private String envfile = "PropertiesFile\\Environment.properties";

//Fetching the URL from Properties file and hitting the Website after Initializing the WebDriver
	@Given("^User Navigate to Application \"([^\"]*)\"$")
	public void user_Navigate_to_Application(String reqURL) throws Throwable {
		String url = GetData(reqURL, envfile);
		initURL(url);
		takeScreenshot("PHPTravelsLogin");
	}

//Login to the application by entering username password
	@Then("^User should Login Successfully$")
	public void user_Login() throws Throwable {
		String Username = GetData("username", envfile);
		String Password = GetData("password", envfile);

		waitForTheElementToVisible(loginpage.myAccountDropDown, 30);
		loginpage.myAccountDropDown.click();
		loginpage.lnkLogin.click();
		loginpage.txtUserName.sendKeys(Username);
		loginpage.txtPassword.sendKeys(Password);
		loginpage.btnLogin.click();
		System.out.println("Login Successful with " + Username);
		Thread.sleep(5000);

	}

	// verify Username after Login
	@And("^User verify Name \"([^\"]*)\" after Login$")
	public Boolean user__verify_Name_after_Login(String username) throws Throwable {
		waitForTheElementToVisible(homepage.verifyName, 50);
		String name = homepage.verifyName.getText();
		takeScreenshot("HomePage");
		if (name.contains(username)) {
			System.out.println(name + " - userName is correct");
			return true;
		} else {
			System.out.println(name + " - userName is incorrect");
			return false;
		}

	}

	@Then("^Navigate to My Profile Section$")
	public void Navidate_to_My_Profile_Section() throws Throwable {
		waitForTheElementToVisible(homepage.lnkMyProfile, 30);
		homepage.lnkMyProfile.click();

		waitForTheElementToVisible(homepage.verifyMyProfile, 30);
		System.out.println("My Profile section is displayed");
	}

	@Then("^User update the City name \"([^\"]*)\" and phone \"([^\"]*)\"$")
	public void user_update_the_City_name_and_phone(String cityname, String phone) throws Throwable {

		setText(homepage.txtCity, cityname);
		setText(homepage.txtPhone, phone);
		takeScreenshot("Profile Updated");
		clickByJavascript(homepage.btnSubmit, "Submit Button");

		System.out.println("My Profile is updated and saved.");

	}

	@Then("^User Verify the changes are saved succesfully \"([^\"]*)\" \"([^\"]*)\"$")

	public void user_Verify_the_changes_are_saved_succesfully(String cityname, String phone) throws Throwable {
		refresh();
		waitForTheElementToVisible(homepage.lnkMyProfile, 30);
		homepage.lnkMyProfile.click();

		waitForTheElementToVisible(homepage.txtCity, 30);

		String ActualCity = homepage.txtCity.getAttribute("value");
		String ActualPhone = homepage.txtPhone.getAttribute("value");
		scrollIntoView(homepage.txtCity);
		verifyElementsText("Verifying City name", ActualCity, cityname);
		verifyElementsText("Verifying Phone number", ActualPhone, phone);

		System.out.println("Changes in My Profile are verified");
		javawait(3000);
		takeScreenshot("MyProfile");

	}

	@Given("^User Navigate to supplier site$")
	public void user_Navigate_to_supplier_site() throws Throwable {
		scrollIntoView(supLogin.lnkSupplierLogin);
		clickElement(supLogin.lnkSupplierLogin, "Supplier Login Link");
	}

	@Then("^Enter Credentials and Login \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_credentials_and_Login(String username, String password) throws Throwable {
		switchWindow();

		setText(supLogin.txtSupplierEmail, GetData(username, envfile));
		setText(supLogin.txtSupplierPassword, GetData(password, envfile));

		clickByJavascript(supLogin.btnLogin, "Submit Button");
		takeScreenshot("Login");

	}

	@Then("^User verify error Message$")
	public boolean user_verify_error_Message() throws Throwable {
		waitForTheElementToVisible(supLogin.errInvalidCreds, 20);
		if (supLogin.errInvalidCreds.isDisplayed()) {
			System.out.println("Error Message appeared: Invalid Login");
			takeScreenshot("SupplierLogin");
			return true;
		} else {
			System.out.println("Error Message did not appear");
			takeScreenshot("SupplierLogin");
			return false;
		}

	}

	@Then("^Navigate to Home$")
	public void navigate_to_Home() throws Throwable {
		clickElement(homepage.lnkHome, "Home Link");
	}

	@Then("^Switch Language \"([^\"]*)\"$")
	public void switch_Language(String language) throws Throwable {
		clickByJavascript(loginpage.cmbLanguage, "Language DropDown");
		javawait(3000);
		WebElement eleLanguage = driver
				.findElement(By.xpath("//a[contains(text(),'" + language + "')]//span[@class='image']"));
		clickElement(eleLanguage, language);
		System.out.println("Language Switched to: " + language);

		takeScreenshot("Language Translate");
	}

	@Then("^Verify Language Translate \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_Language_Translate(String uname, String booking, String myprofile) throws Throwable {
		javawait(3000);

		verifyText(homepage.verifyName, uname);
		verifyText(homepage.lnkMyBookings, booking);
		verifyText(homepage.lnkMyProfile, myprofile);
	}

}
