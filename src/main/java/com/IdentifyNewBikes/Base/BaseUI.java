package com.IdentifyNewBikes.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.IdentifyNewBikes.Utils.ExtendProjectManager;
import com.IdentifyNewBikes.Utils.ReadExcelUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseUI {
	public static WebDriver driver;
	public ReadExcelUtils data=new ReadExcelUtils(System.getProperty("user.dir")+"\\Excel_Input\\Login.xlsx");
	public String[] prices = new String[8];
	public String[] BikeName = new String[8];
	public String[] LunchDate = new String[8];
	public String[] Cars=new String[25];
	public ExtentReports report=ExtendProjectManager.getInstance();
	public static ExtentTest logger;
	public Properties prop;
	public static String homepageWindow;
   
	public void invokeBrowser() {
		driver = DriverSetUp.invokeBrowser("chrome");
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\com\\IdentifyNewBikes\\config\\ProjectConfig.properites");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	


	public void scroll(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void click(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
    @AfterTest
	public void closeBrowser() {
      		driver.quit();
	}
	
	public void verifyPageTitle(String exceptedTitle) {
		Assert.assertEquals(driver.getTitle(), exceptedTitle);
	}

	public WebElement getElement(String LocatorKey) {
		WebElement element=null;
		if (LocatorKey.endsWith("_Xpath")) {
			element=driver.findElement(By.xpath(prop.getProperty(LocatorKey)));
		}else if(LocatorKey.endsWith("_Id")) {
			element=driver.findElement(By.id(prop.getProperty(LocatorKey)));

		}else if(LocatorKey.endsWith("_ClassName")) {
			element=driver.findElement(By.className(prop.getProperty(LocatorKey)));
		}else if(LocatorKey.endsWith("_Css")) {
			element=driver.findElement(By.cssSelector(prop.getProperty(LocatorKey)));
		}
		return element;
	}
	
	public void screenShot(String picName) {
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"\\ScreenShots"+picName+".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
