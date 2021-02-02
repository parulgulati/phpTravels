package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsHotelBooking {

	WebDriver driver;

	public PHPTravelsHotelBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-name='hotels' and contains(text(),'Hotels')]")
	public WebElement lnkHotels;

	@FindBy(xpath = "(//input[@name='children']//following::button[text()='+'])[1]")
	public WebElement btnAddChildren;

	@FindBy(xpath = "(//input[@name='checkin'])[1]")
	public WebElement txtCheckin;

	@FindBy(xpath = "(//input[@name='checkout'])[1]")
	public WebElement txtCheckout;

	@FindBy(xpath = "(//span[text()='Search by Hotel or City Name'])[1]")
	public WebElement txtHotelLists;

	@FindBy(xpath = "(//label[text()='Destination']//following::input[@name='dest'])")
	public WebElement inputHotelLists;

	@FindBy(xpath = "//div[text()='Locations']//following::li[1]")
	public WebElement listLocation;
	
	@FindBy(xpath = "//div[text()='Hotels']//following::li[1]")
	public WebElement listHotels;
 
	@FindBy(xpath = "//a[text()='Facilities']")
	public WebElement lnkFacilities;
	
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Search')]")
	public WebElement btnSearch;

	@FindBy(xpath = "//button[@type='submit' and @id='searchform']")
	public WebElement btnSearchform;

	@FindBy(xpath = "(//a[text()='Details'])[1]")
	public WebElement lnkDetails;

	@FindBy(xpath = "(//label[contains(text(),'Select Room')])[1]")
	public WebElement chkRoom;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Book Now')]")
	public WebElement btnBookNow;
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'CONFIRM THIS BOOKING')]")
	public WebElement btnConfirmBooking;
	
	@FindBy(xpath = "//button[ contains(text(),'Pay on Arrival')]")
	public WebElement btnPayOnArrival;
	
	@FindBy(xpath = "//h4[ contains(text(),'Your booking status is Reserved')]")
	public WebElement verifyBooking;
	
	@FindBy(xpath = "//span[text()='Reserved']")
	public WebElement verifyReserved;
	

}
