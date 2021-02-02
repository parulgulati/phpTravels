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
import pageobjects.PHPTravelsHotelBooking;

public class HotelBookingStepDef extends BaseClass {

	private PHPTravelsLoginPage loginpage = PageFactory.initElements(driver, PHPTravelsLoginPage.class);
	private PHPTravelsHomePage homepage = PageFactory.initElements(driver, PHPTravelsHomePage.class);
	private PHPTravelsHotelBooking hotel = PageFactory.initElements(driver, PHPTravelsHotelBooking.class);

	private String envfile = "PropertiesFile\\Environment.properties";

	@Then("^Search for Hotel with Dates \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void search_for_Hotel_with_Dates(String place, String checkin, String checkout) throws Throwable {
		try {
			clickElement(hotel.lnkHotels, "Hotels Tab");
			clickElement(hotel.txtHotelLists, "List of Hotel");
			Thread.sleep(2000);
			hotel.inputHotelLists.sendKeys(place);
			Thread.sleep(2000);
			clickElement(hotel.listLocation, place);
			clickByJavascript(hotel.txtCheckin, "Checkin");
			setText(hotel.txtCheckin, checkin);
			clickByJavascript(hotel.txtCheckout, "Checkout");
			setText(hotel.txtCheckout, checkout);
			clickElement(hotel.btnAddChildren, "Add Children");
			clickByJavascript(hotel.btnSearch, "Search Button");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Search for Hotel \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void search_for_Hotel(String place, String checkin, String checkout) throws Throwable {
		try {
			clickElement(hotel.lnkHotels, "Hotels Tab");
			clickElement(hotel.txtHotelLists, "List of Hotel");
			Thread.sleep(2000);
			hotel.inputHotelLists.sendKeys(place);
			Thread.sleep(2000);
			clickElement(hotel.listHotels, place);
			clickByJavascript(hotel.txtCheckin, "Checkin");
			setText(hotel.txtCheckin, checkin);
			clickByJavascript(hotel.txtCheckout, "Checkout");
			setText(hotel.txtCheckout, checkout);
			clickElement(hotel.btnAddChildren, "Add Children");
			clickByJavascript(hotel.btnSearch, "Search Button");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// div[contains(@class,'rating-icons')]//input[@value='4']
	@And("^User Filter out from hotels \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_Filter_out_from_hotels(String rating, String amenities, String propType, String priceFilter)
			throws Throwable {
		WebElement elePriceFilter = driver.findElement(
				By.xpath("//input[@type='radio'][@name='priceOrder']//following::label[text()='" + priceFilter + "']"));
		scrollIntoView(elePriceFilter);
		clickElement(elePriceFilter, priceFilter);
		Thread.sleep(2000);
		WebElement eleRating = driver.findElement(
				By.xpath("//div[contains(@class,'rating-icons')]//following::label[@for='" + rating + "']"));
		scrollIntoView(eleRating);
		clickElement(eleRating, rating);
		WebElement eleAmenities = driver.findElement(
				By.xpath("//input[@type='checkbox'][@name='amenities[]']//following::label[@for='" + amenities + "']"));
		scrollIntoView(eleAmenities);
		clickElement(eleRating, amenities);
		WebElement elePropType = driver.findElement(
				By.xpath("//input[@type='checkbox'][@name='type[]']//following::label[@for='" + propType + "']"));
		scrollIntoView(elePropType);
		clickElement(elePropType, propType);
		clickElement(hotel.btnSearchform, "Search Button");
		takeScreenshot("Hotel Booking");

	}

	@Then("^Select a Hotel and choose a room and confirm booking$")
	public void select_a_Hotel_and_choose_a_room_and_confirm_booking() throws Throwable {
		clickElement(hotel.lnkDetails, "Details Link");
		scrollIntoView(hotel.chkRoom);
		javawait(5000);
		clickByJavascript(hotel.chkRoom, "Room Type checkbox");
		javawait(10000);
		scrollIntoView(hotel.btnBookNow);
		clickByJavascript(hotel.btnBookNow, "Book now button");
		javawait(5000);
		takeScreenshot("Booking Complete");
		clickByJavascript(hotel.btnConfirmBooking, "Confirm Booking");
		clickByJavascript(hotel.btnPayOnArrival, "PayOnArrival");
		String Alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(Alert + " Alert is accepted");
		scrollIntoView(hotel.verifyBooking);
		verifyElementPresent(hotel.verifyBooking, "Booking Reserved");
		javawait(10000);
	}

	@Then("^Navigate to MyAccount$")
	public void navigate_to_MyAccount() throws Throwable {
		scrollIntoView(loginpage.myAccountDropDown);
		clickElement(loginpage.myAccountDropDown, "Account Dropdown");
		clickElement(loginpage.lnkAccount, "Account link");
	}

	@Then("^Verify Hotel Booking \"([^\"]*)\"$")
	public boolean verify_Hotel_Booking(String place) throws Throwable {
		javawait(5000);
		WebElement elePlace = driver.findElement(By.xpath("//span[text()='" + place + "']"));
		if (elePlace.getText().equalsIgnoreCase(place)) {
			verifyElementPresent(hotel.verifyReserved, "Hotel Status Reserved");
			return true;
		} else {
			System.out.println("Hotel with " + place + " Place is not found in booking");
			return false;
		}

	}

	@Then("^Verify Omitted Facilities \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_Omitted_Facilities(String facilitiesOmit1, String facilitiesOmit2) throws Throwable {
		javawait(5000);
		clickElement(hotel.lnkFacilities, "Facilities");
		takeScreenshot("Facilities of Created Hotel");
		/*
		 * WebElement eleF1 = driver.findElement(By.xpath(
		 * "//ul[contains(@class,'facility-list')]//span[text()='"+facilitiesOmit1+"']")
		 * ); WebElement eleF2 = driver.findElement(By.xpath(
		 * "//ul[contains(@class,'facility-list')]//span[text()='"+facilitiesOmit2+"']")
		 * ); verifyElementNotPresent(eleF2, facilitiesOmit2);
		 * verifyElementNotPresent(eleF1, facilitiesOmit1);
		 */

	}

	@Then("^Verify Language Translation \"([^\"]*)\"$")
	public void verify_Language_Translation(String name) throws Throwable {
		javawait(5000);
		verifyText(homepage.lnkHome, name);

	}
	@Then("^Close Browser$")
	public void close_Browser() throws Throwable {
		javawait(5000);
		closeBrowser();

	}
}
