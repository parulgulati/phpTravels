package StepdefFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.PHPTravelsLoginPage;
import pageobjects.PHPTravelsHomePage;
import pageobjects.PHPTravelsSupplierLoginPage;
import pageobjects.PHPTravelsAdminPage;

public class AdminRelatedStepDef extends BaseClass {

	private PHPTravelsLoginPage loginpage = PageFactory.initElements(driver, PHPTravelsLoginPage.class);
	private PHPTravelsHomePage homepage = PageFactory.initElements(driver, PHPTravelsHomePage.class);
	private PHPTravelsSupplierLoginPage supLogin = PageFactory.initElements(driver, PHPTravelsSupplierLoginPage.class);
	private PHPTravelsAdminPage admin = PageFactory.initElements(driver, PHPTravelsAdminPage.class);

	private String envfile = "PropertiesFile\\Environment.properties";

	// verify Username after Login
		@And("^User verify Profile after Login$")
		public Boolean user_verify_Profile_after_Login() throws Throwable {
			waitForTheElementToVisible(admin.verifyAdmin, 50);
			System.out.println("Admin Profile is Logged in");
			return true;
		}
		
		@Then("^Open Hotels Section$")
		public void open_Hotels_Section() throws Throwable {
		    clickElement(admin.lnkHotels, "Hotels Section");
		    clickElement(admin.optHotels, "Hotels Link");
		    
		}

		@Then("^Add a new hotel with all the details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void hotelname(String hotelname,String hoteldesc,String place) throws Throwable {
			clickElement(admin.btnAdd, "Add Button");
			setText(admin.txtHotelName, hotelname);
			driver.switchTo().frame(admin.frmDescription);
			setText(admin.txtDescription, hoteldesc);
			driver.switchTo().defaultContent();
			clickElement(admin.cmbLocation, "Location");
			setText(admin.txtLocation, place);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//ul//li//span[text()='"+place+"']")).click();
			System.out.println("Dropdown Selected "+place);
			selectByValue(admin.cmbStars, "4", "Stars");
			
		}
		
		@Then("^Add facilities to hotel \"([^\"]*)\" \"([^\"]*)\"$")
		public void add_facilities_to_hotel(String facilitiesToOmit1, String facilitiesToOmit2) throws Throwable {
		 clickElement(admin.tabFacilities, "Facilities");
		 clickByJavascript(admin.chkSelectAll, "Select All checkbox");
		 driver.findElement(By.xpath("//label[contains(text(),'"+facilitiesToOmit1+"')]//input[@name='hotelamenities[]']//..")).click();
		 driver.findElement(By.xpath("//label[contains(text(),'"+facilitiesToOmit2+"')]//input[@name='hotelamenities[]']//..")).click();
		 System.out.println(facilitiesToOmit1+","+facilitiesToOmit2+" facilities are deselected");
		 takeScreenshot("Facilities Selected for New Hotel");
		}

		@Then("^Add Contact for hotel \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void add_Contact_for_hotel(String hotelemail, String hotelwebsite, String hotelphone) throws Throwable {
			windowscrollUp();
			
			clickElement(admin.tabContact, "Contact Tab");
			setText(admin.txtHotelPhone, hotelphone);
			setText(admin.txtHotelemail, hotelemail);
			setText(admin.txtHotelWebsite, hotelwebsite);
		 
		}

		@Then("^Add Translate Languages for hotel Info \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void add_Translate_Languages_for_hotel_Info(String language1, String language2, String hotelname, String metatitle) throws Throwable {
				windowscrollUp();
			  clickElement(admin.tabTranslate, "Translate Tab");
			  driver.findElement(By.xpath("//div[contains(text(),'"+language1+"')]//following::input[@placeholder='Hotel Name'][1]")).sendKeys(hotelname);
			  driver.findElement(By.xpath("//div[contains(text(),'"+language1+"')]//following::input[@placeholder='Title'][1]")).sendKeys(metatitle);
			  driver.findElement(By.xpath("//div[contains(text(),'"+language2+"')]//following::input[@placeholder='Hotel Name'][1]")).sendKeys(hotelname);
			  driver.findElement(By.xpath("//div[contains(text(),'"+language2+"')]//following::input[@placeholder='Title'][1]")).sendKeys(metatitle);
			  System.out.println("Translate language selected are:"+language1 +","+language2);
		}

		@Then("^Save the Hotel Details$")
		public void save_the_Hotel_Details() throws Throwable {
		  clickElement(admin.btnSubmit, "Submit Button");
		  Thread.sleep(5000);
		  
		  takeScreenshot("New Hotel Added");
		}

		@Then("^Navigate to CMS Pages$")
		public void navigate_to_CMS_Pages() throws Throwable {
			clickElement(admin.lnkCMS, "Link CMS");
			clickElement(admin.optPages, "CMS Pages");
			javawait(5000);
		   
		}

		@Then("^Edit Contact CMS Information \"([^\"]*)\"$")
		public void edit_Contact_CMS_Information(String contactTitle) throws Throwable {
			windowscrollDown();
		  clickByJavascript(admin.lnkContactEdit, "Edit Contact");
		  setText(admin.lnkContactTitle, contactTitle);
		}

		@Then("^Add SEO information \"([^\"]*)\" \"([^\"]*)\"$")
		public void add_SEO_information(String keywords, String description) throws Throwable {
			setText(admin.lnkSEOKeywords, keywords);
			setText(admin.lnkSEODescription, description);
		}

		@Then("^Save the CMS$")
		public void save_the_CMS() throws Throwable {
		    clickElement(admin.btnSubmit, "Submit Button for CMS Page");
		    javawait(5000);
		}
		
		@Then("Verify CMS Updates \"([^\"]*)\"$")
		public void verify_CMS_Updates(String pagetitle) throws Throwable {
			
		   windowscrollDown();
		   WebElement eleContact= driver.findElement(By.xpath("(//a[text()='"+pagetitle+"'])[2]"));
		   clickByJavascript(eleContact, pagetitle);
		   
		   javawait(5000);
		   String title=driver.getTitle();
		   if(title.equalsIgnoreCase(pagetitle)) {
			   System.out.println("CMS Details updated successfully "+pagetitle+" :Pagetitle is updated");
		   }
		   else {
			   System.err.println("CMS Details are not updated");
		   }
		
		}


}
