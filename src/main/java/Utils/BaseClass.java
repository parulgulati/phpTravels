package Utils;

import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;

import gherkin.lexer.Sr_cyrl;

public class BaseClass {
	public BaseClass() {

	}

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	public static WebDriverWait wait;

	//intiate the Driver
	public void WebDriverInit(String Browser) throws IOException {
		if (Browser.equalsIgnoreCase("Chrome")) {
			deleteScreenshotFolder();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			System.out.println("Launching Chrome and clearing all the cache and cookies");
		}

		else if (Browser.equalsIgnoreCase("IE")) {

		}

		else if (Browser.equalsIgnoreCase("FireFox")) {

		}

	}

	public void LoadProperties(String path) throws FileNotFoundException {
		fis = new FileInputStream(path);
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String GetData(String Key, String path) throws FileNotFoundException {
		LoadProperties(path);
		String Value = prop.getProperty(Key);
		return Value;
	}

	public void SetData(String Key, String Value, String path) throws FileNotFoundException {
		LoadProperties(path);
		prop.setProperty(Key, Value);
		StoreData(path);

	}

	public void StoreData(String path) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(path);
		try {
			prop.store(fos, "This prop stored");
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initURL(String URL) throws FileNotFoundException {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Successful to " + URL);

	}

	public void waitForTheElementToVisible(WebElement Element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(Element));

	}

	public void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String location = "Print\\Screenshots";
		File DestFile = new File(location + fileName + "_" + ".png");
		FileUtils.copyFile(srcFile, DestFile);
	}

	public static void deleteScreenshotFolder() throws IOException {

		String filePath = "Print";
		File file = new File(filePath);
		FileUtils.deleteDirectory(file);
		System.out.println("Files deleted........");

	}

	public boolean verifyText(WebElement element, String expText) {
		try {
			if (element.isDisplayed()) {
				String text = element.getText();
				if (text.equalsIgnoreCase(expText)) {
					System.out.println("Match found "+text);
					return true;
				}
				
				else {
					System.out.println("Match not found "+text);
					return false;
				}
			}
			else {
				System.err.println("Element not visible");
			
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

	public void verifyElementsText(String message, String actualText, String expText) {
		try {
			Assert.assertEquals(message, actualText, expText);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyElementNotPresent(WebElement element, String text) {
		try {
			if(element.isDisplayed()) {
				System.err.println("Element is present");
				return false;
			}
			else {
				System.out.println("Element is not present- Expected Result");
				return true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean verifyElementPresent(WebElement element, String name) {
		try {
			waitForTheElementToVisible(element, 30);
			if (element.isDisplayed()) {
				System.out.println(name + " is present on screen");
				return true;
			} else {
				System.out.println(name + " is not present on screen");
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean setText(WebElement element, String text) {
		try {
			waitForTheElementToVisible(element, 20);
			if (element.isDisplayed() && element.isEnabled()) {
				element.clear();
				element.sendKeys(text);
				System.out.println("Value is set to: " + text);
				return true;
			} else {
				System.out.println("textbox is not editable");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public boolean clickElement(WebElement element, String text) {
		try {
			waitForTheElementToVisible(element, 30);
			if (element.isDisplayed() && element.isEnabled()) {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				System.out.println(text + " is clicked");
				return true;
			} else {
				System.out.println(text + " is not clickable");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void clickByJavascript(WebElement element, String text) {
		try {
			waitForTheElementToVisible(element, 30);
			Thread.sleep(3000);
			// scrollIntoView(element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println(text + " is clicked using Javascript");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void refresh() {
		driver.navigate().refresh();
		System.out.println("Page refreshed");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void scrollIntoView(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void windowscrollUp() {

		((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void windowscrollDown() {

		((JavascriptExecutor) driver).executeScript("scroll(0, 500);");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void javawait(int time) throws Exception {
		Thread.sleep(time);
	}

	public void selectByValue(WebElement element, String text, String list) {

		Select dropdown = new Select(element);
		dropdown.selectByValue(text);
		System.out.println(text + "is selected from dropdown from list " + list);
	}

	public void switchWindow() {

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterating using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

			}
		}

	}
}