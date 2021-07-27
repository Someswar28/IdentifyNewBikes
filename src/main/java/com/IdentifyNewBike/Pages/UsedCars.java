package com.IdentifyNewBike.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.IdentifyNewBikes.Base.BaseUI;
import com.IdentifyNewBikes.Utils.WriteExcelUtils;

public class UsedCars extends BaseUI{
	

	public void cars() {
		driver.navigate().to("https://www.zigwheels.com/");
		getElement("PopUpBtn_Xpath").click();
		WebElement UsedCars = getElement("UsedCarsBtn_Xpath");
		Actions action1 = new Actions(driver);
		action1.moveToElement(UsedCars).build().perform();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOf(getElement("ChennaiBtn_Xpath")));
		getElement("ChennaiBtn_Xpath").click();
		
	}
	
	public void getUsedCars() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		
		try {
			
			Thread.sleep(2000);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollBy(0,800)", "");
		
		try {
			
			Thread.sleep(2000);					
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
        js.executeScript("window.scrollBy(0,1200)", "");
		
		try {
			
			Thread.sleep(2000);					
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		int i=0;
		List<WebElement> cars=driver.findElements(By.xpath("//a[contains(@class,'fnt-22 zm-cmn')]"));
		for(WebElement element:cars) {
			if(i==25) {
				break;
			}else {
				Cars[i]=element.getText();
				i++;
			}
		}
		WriteExcelUtils write=new WriteExcelUtils();
		try {
			write.writeData1(Cars);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int j=0;j<25;j++) {
			System.out.println(Cars[j]);
		}
	}
		
}
