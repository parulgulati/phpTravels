package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelsAdminPage {

	WebDriver driver;
    public PHPTravelsAdminPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//h2[contains(strong,'Admin')]")
    public WebElement verifyAdmin;
    
    @FindBy(xpath="//a[@href='#Hotels']")
    public WebElement lnkHotels;
  
    @FindBy(xpath="//ul[@id='Hotels']//a[text()='Hotels']")
    public WebElement optHotels;
    
    @FindBy(xpath="//button[contains(text(),'Add')]")
    public WebElement btnAdd;
    
    @FindBy(xpath="//span[text()='Enter Location']")
    public WebElement cmbLocation;
    
    @FindBy(xpath="//li[text()='Please enter 3 more characters']//..//..//input")
    public WebElement txtLocation;
  
    @FindBy(xpath="//select[@name='hotelstars']")
    public WebElement cmbStars;
   
    @FindBy(xpath="//select[@name='hoteltype']")
    public WebElement cmbHotelType;
    
    @FindBy(xpath="//select[@name='isfeatured']")
    public WebElement cmbFeatured;
  
    
    @FindBy(xpath="//input[@name='hotelname']")
    public WebElement txtHotelName;
    
    @FindBy(xpath="//iframe[@title='Rich Text Editor, hoteldesc']")
    public WebElement frmDescription;
    
    @FindBy(xpath="(/html/body/p)")
    public WebElement txtDescription;
    
    @FindBy(xpath="//input[@id='mapaddress']")
    public WebElement txtMapAddress;
  
    @FindBy(xpath="//a[@href='#FACILITIES' and @data-toggle='tab']")
    public WebElement tabFacilities;
    
    @FindBy(xpath="//input[@id='select_all']//..")
    public WebElement chkSelectAll;
    
    //@FindBy(xpath="//label[contains(text(),'"+service+"')]//input[@name='hotelamenities[]']")
    //public WebElement chkHotelServices;
  
    @FindBy(xpath="//a[@href='#META_INFO' and @data-toggle='tab']")
    public WebElement tabMetaInfo;
    
    @FindBy(xpath="//input[@name='hotelmetatitle']")
    public WebElement txtHotelmetatitle;
    
    @FindBy(xpath=" //textarea[@name='hotelkeywords']")
    public WebElement txthotelkeywords;
    
    @FindBy(xpath="//textarea[@name='hotelmetadesc']")
    public WebElement txthotelmetadesc;
  
    @FindBy(xpath="//a[@href='#POLICY' and @data-toggle='tab']")
    public WebElement tabPolicy;
    
    @FindBy(xpath="//input[@name='checkintime'")
    public WebElement txtCheckinTime;
    
    @FindBy(xpath="//input[@name='checkouttime']")
    public WebElement txtcheckouttime;
    
    @FindBy(xpath="//label[text()='Payment Options']//following::ul")
    public WebElement listPaymentOptions;
 
    @FindBy(xpath="//textarea[@name='hotelpolicy']")
    public WebElement txtHotelPolicy;
    
    @FindBy(xpath="//a[@href='#CONTACT' and @data-toggle='tab']")
    public WebElement tabContact;
    
    @FindBy(xpath="//input[@name='hotelemail']")
    public WebElement txtHotelemail;
    
    @FindBy(xpath="//input[@name='hotelwebsite']")
    public WebElement txtHotelWebsite;
    
    @FindBy(xpath="//input[@name='hotelphone']")
    public WebElement txtHotelPhone;
    
    @FindBy(xpath="//a[@href='#TRANSLATE' and @data-toggle='tab']")
    public WebElement tabTranslate;
  
    @FindBy(xpath="//button[text()='Submit']")
    public WebElement btnSubmit;
  
    
    //CMS Page
    @FindBy(xpath="//a[@href='#CMS']")
    public WebElement lnkCMS;
    
    @FindBy(xpath="//ul[@id='CMS']//a[text()='Pages']")
    public WebElement optPages; 
    
    @FindBy(xpath="(//td[text()='Support']//following::a[@title='Edit'])[1]")
    public WebElement lnkSupportEdit; 
 
    @FindBy(xpath="(//td[contains(text(),'Contact')]//following::a[@title='Edit'])[1]")
    public WebElement lnkContactEdit; 
    
    @FindBy(xpath="//input[@placeholder='Permalink']")
    public WebElement lnkSupportPermalink; 
    
    @FindBy(xpath="//input[@placeholder='Page Title']")
    public WebElement lnkContactTitle; 
    
    @FindBy(xpath="//input[@placeholder='Keywords']")
    public WebElement lnkSEOKeywords; 
    
    @FindBy(xpath="//input[@placeholder='Description']")
    public WebElement lnkSEODescription; 
  
}

