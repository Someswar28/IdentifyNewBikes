package com.IdentifyNewBike.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.IdentifyNewBikes.Base.BaseUI;
import com.IdentifyNewBikes.Utils.WriteExcelUtils;


public class UpcomingBikes extends BaseUI{
	
	public void upcomingBikes() {
        
		driver.navigate().to("https://www.zigwheels.com/");
		getElement("PopUpBtn_Xpath").click();
		
		WebElement NewBikes=getElement("NewBikesBtn_Xpath");
		WebElement UpBikes=getElement("UpcomingBikesBtn_Xpath");
		
		Actions act=new Actions(driver);
		act.moveToElement(NewBikes).build().perform();
		act.moveToElement(UpBikes).click().build().perform();
	}
	
    public void selectHondaCompanyBikes() {
    	WebElement DropDown=getElement("HondaBtn_Id");
    	
    	Select company=new Select(DropDown);
    	company.selectByVisibleText("Honda");
    }

    public void selectingBikes() throws Exception   {
        WebElement ViewMore=getElement("ViewMoreBtn_ClassName");
        WebElement moveTo=getElement("MoveTo_ClassName");
        scroll(driver,moveTo);
        click(driver,ViewMore);
        Thread.sleep(5000);
     
    	List<WebElement> bikes = driver.findElements(By.xpath("//div[@class='b fnt-15']"));
    	int i=1;
    	int j=0;
		for(WebElement element:bikes) {
			String price1=element.getText();
			String price2 =price1.replace("Rs.", "");
			boolean isLakhs = price2.contains("Lakh");
			if(isLakhs) {
				String price3= price2.replaceAll("[^0-9.0-9]", "");
				float price4 = Float.parseFloat(price3) * 100000;
				int price5=(int)price4;
				if(price5<400000) {
					
					if(i==7) {
						i=i+1;
					}
						WebElement price=driver.findElement(By.xpath("//*[@id='modelList']/li["+i+"]/div/div[3]/div[2]"));
			            prices[j]=price.getText();
						WebElement name=driver.findElement(By.xpath("//*[@id='modelList']/li["+i+"]/div/div[3]/a/strong"));
						BikeName[j]=name.getText();
						WebElement Lunch=driver.findElement(By.xpath("//*[@id='modelList']/li["+i+"]/div/div[3]/div[3]"));
						LunchDate[j]=Lunch.getText();
						j++;
					}
					i++;	
			}
			
		}
		for(int k=0;k<=7;k++) {
			WriteExcelUtils write=new WriteExcelUtils();
			write.writeData(prices[k], BikeName[k], LunchDate[k],k+1);
		}
    }   
}
