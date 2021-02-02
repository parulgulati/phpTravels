package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsHomePage {

	WebDriver driver;
    public PHPTravelsHomePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//h3[text()]")
    public WebElement verifyName;
    
    @FindBy(xpath="//a[@href='#profile']")
    public WebElement lnkMyProfile;
  
    @FindBy(xpath="//a[@href='#bookings']")
    public WebElement lnkMyBookings;
    
    @FindBy(xpath="//h3[text()='My Profile']")
    public WebElement verifyMyProfile;
    
    @FindBy(xpath="//input[@name='city']")
    public WebElement txtCity;
    
    @FindBy(xpath="//input[@name='phone']")
    public WebElement txtPhone;
  
    @FindBy(xpath="//button[@type='submit' and contains(text(),'Submit')]")
    public WebElement btnSubmit;
    
    @FindBy(xpath="//a[@title='home']")
    public WebElement lnkHome;
  
}

