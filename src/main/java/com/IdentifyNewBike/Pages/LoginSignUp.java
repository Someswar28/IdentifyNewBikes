package com.IdentifyNewBike.Pages;

import java.util.Set;

import org.testng.annotations.Test;

import com.IdentifyNewBikes.Base.BaseUI;
import com.aventstack.extentreports.Status;

public class LoginSignUp extends BaseUI{
	
 
	public void selectLogin()  {
		driver.navigate().to("https://www.zigwheels.com/");
		homepageWindow=driver.getWindowHandle();
		screenShot("HomePage");
		
		Set<String>set=driver.getWindowHandles();
		for(String window:set) {
			driver.switchTo().window(window);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getElement("PopUpBtn_Xpath").click();
		getElement("SignInBtn_Id").click();
	}
 
    public void selectContinueWithGoogle() throws Exception {
    	Set<String>set=driver.getWindowHandles();
		for(String window:set) {
			driver.switchTo().window(window);
			Thread.sleep(5000);
		}
    	getElement("GoogleBtn_Id").click();
    	screenShot("ClickedGoogleBtn");
    }
    public void invalidEmail() throws Exception{
    	Set<String>set=driver.getWindowHandles();
		for(String window:set) {
			driver.switchTo().window(window);
			
		}
		getElement("UserNameTxtBox_Id").sendKeys(data.getCellData(0, 2));
		getElement("UserNxtBtn_Xpath").click();
		String Error=getElement("ErrorMgs1_Xpath").getText();
		System.out.println(Error);
    }
    @Test(priority=4)
    public void validEmailInvalidPassword()  {
    	Set<String>set=driver.getWindowHandles();
		for(String window:set) {
			driver.switchTo().window(window);
			
		}
		getElement("UserNameTxtBox_Id").clear();
		getElement("UserNameTxtBox_Id").sendKeys(data.getCellData(0, 3));
		getElement("UserNxtBtn_Xpath").click();
		logger=report.createTest("Entering Valid UserName and Invalid Password");
    	logger.log(Status.INFO, "Entered valid UserName Successfully");
		logger.log(Status.PASS,"Redirected to Password page Successfully");
    	Set<String>set1=driver.getWindowHandles();
		for(String window:set1) {
			driver.switchTo().window(window);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getElement("PassWordTxtBox_Xpath").sendKeys(data.getCellData(1, 3));
		getElement("PassNxtBtn_ClassName").click();
		String Error=getElement("ErrorMgs2_Xpath").getText();
		System.out.println(Error);
		driver.switchTo().window(homepageWindow);
    }
}
