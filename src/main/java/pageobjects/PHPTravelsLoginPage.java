package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsLoginPage {

	WebDriver driver;
    public PHPTravelsLoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="(//div[@class='dropdown dropdown-login dropdown-tab']//a)[1]")
    public WebElement myAccountDropDown;
    
    @FindBy(xpath="//a[text()='Login']")
    public WebElement lnkLogin;
    
    @FindBy(xpath="//input[@name='username']")
    public WebElement txtUserName;
    
    @FindBy(xpath="//input[@name='password']")
    public WebElement txtPassword;
  
    @FindBy(xpath="//button[text()='Login']")
    public WebElement btnLogin;
    
    @FindBy(xpath="(//a[text()='Account'])")
    public WebElement lnkAccount;
 
    @FindBy(xpath="//a[@id='dropdownLangauge']")
    public WebElement cmbLanguage;
  
}

