package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsSupplierLoginPage {

	WebDriver driver;
    public PHPTravelsSupplierLoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//a[text()='Supplier Login']")
    public WebElement lnkSupplierLogin;
    
    @FindBy(xpath="//input[@name='email']")
    public WebElement txtSupplierEmail;
    
    @FindBy(xpath="//input[@name='password']")
    public WebElement txtSupplierPassword;
  
    @FindBy(xpath="//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy(xpath="//div[text()='Invalid Login Credentials']")
    public WebElement errInvalidCreds;
    
}

