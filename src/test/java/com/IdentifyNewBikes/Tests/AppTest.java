package com.IdentifyNewBikes.Tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.IdentifyNewBikes.Base.BaseUI;
import com.IdentifyNewBikes.Utils.WriteExcelUtils;
import com.aventstack.extentreports.Status;

public class AppTest extends BaseUI{

	@Test(priority = 1, groups = { "SmokeTest" })
	public void callingBrowser() {
		invokeBrowser();
		logger = report.createTest("Invoking BrowserInstance");
		logger.log(Status.INFO, "Calling BrowserInstance");
		logger.log(Status.PASS, "Called BrowserInstance Successfully");
		report.flush();
	}

	@Test(priority = 2, groups = { "SmokeTest" })
	public void pageOpening() {
		driver.navigate().to("https://www.zigwheels.com/");
		screenShot("HomePage");
	}

	@Test(priority = 3)
	public void pageTitle() {
		verifyPageTitle("ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, Forum");
	}

	@Test(priority = 4, groups = { "SmokeTest" })
	public void selectLogin() {

		homepageWindow = driver.getWindowHandle();

		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
			driver.switchTo().window(window);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getElement("PopUpBtn_Xpath").click();
		getElement("SignInBtn_Id").click();
		logger = report.createTest("Clicking SignIn Btn");
		logger.log(Status.INFO, "Inentifying Element SignInBtn_Id");
		logger.log(Status.PASS, "Identified Element and Clicked Successfully");
		report.flush();
	}

	@Test(priority = 5, groups = { "SmokeTest" })
	public void selectContinueWithGoogle() throws Exception {
		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
			driver.switchTo().window(window);
			Thread.sleep(5000);
		}
		screenShot("ClickedSignInBtn");
		getElement("GoogleBtn_Id").click();
		screenShot("ClickedGoogleBtn");
		logger = report.createTest("Clicking GoogleSignIn Btn");
		logger.log(Status.INFO, "Inentifying Element GoogleBtn_Id");
		logger.log(Status.PASS, "Identified Element and clicked Successfully");
		report.flush();
	}

	@Test(priority = 6, groups = { "SmokeTest" })
	public void invalidEmail() throws Exception {
		Set<String>set=driver.getWindowHandles();
		for(String window:set) {
			driver.switchTo().window(window);
			
		}
		getElement("UserNameTxtBox_Id").sendKeys(data.getCellData(0, 2));
	}

	@Test(priority = 7, groups = { "SmokeTest" })
	public void ClickOnNextBtn() throws Exception {
		getElement("UserNxtBtn_Xpath").click();
		logger = report.createTest("Entering Invalid UserName");
		logger.log(Status.INFO, "Entered Invalid UserName Successfully");
		logger.log(Status.PASS, "Retrived Error Message Successfully");
		report.flush();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		screenShot("InvalidUserName");
		String Error = getElement("ErrorMgs1_Xpath").getText();
		System.out.println("*******************************");
		System.out.println(Error);
	}

	@Test(priority = 8, groups = { "SmokeTest" })
	public void validEmailInvalidPassword() {
		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
			driver.switchTo().window(window);

		}
		getElement("UserNameTxtBox_Id").clear();
		getElement("UserNameTxtBox_Id").sendKeys(data.getCellData(0, 3));
		getElement("UserNxtBtn_Xpath").click();
		logger = report.createTest("Entering Valid UserName and Invalid Password");
		logger.log(Status.INFO, "Entered valid UserName Successfully");
		logger.log(Status.PASS, "Redirected to Password page Successfully");
		Set<String> set1 = driver.getWindowHandles();
		for (String window : set1) {
			driver.switchTo().window(window);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getElement("PassWordTxtBox_Xpath").sendKeys(data.getCellData(1, 3));
	}

	@Test(priority = 9, groups = { "SmokeTest" })
	public void clickNxt2Btn() {
		getElement("PassNxtBtn_ClassName").click();
		logger.log(Status.INFO, "Entered Invalid Password Successfully");
		logger.log(Status.PASS, "Retrived Error Message Successfully");
		report.flush();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		screenShot("InvalidPassword");
		String Error = getElement("ErrorMgs2_Xpath").getText();
		System.out.println(Error);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().window(homepageWindow);

	}
	@Test(priority = 10, groups = { "SmokeTest" })
	public void clickOnNewBikes() {

		getElement("ExitBtn_Id").click();
		logger = report.createTest("Upcoming Bikes");
		WebElement NewBikes = getElement("NewBikesBtn_Xpath");
		logger.log(Status.INFO, "Identifying Element NewBikesBtn_Xpath");
		Actions act = new Actions(driver);
		act.moveToElement(NewBikes).build().perform();
		logger.log(Status.PASS, "Identified Element and clicked Successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		screenShot("ClickOnNewBikes");
	}

	@Test(priority = 11, groups = { "SmokeTest" })
	public void clickOnUpcomingBikes() {
		WebElement UpBikes = getElement("UpcomingBikesBtn_Xpath");
		logger.log(Status.INFO, "Identifying Element UpcomingBikesBtn_Xpath");
		Actions act = new Actions(driver);
		act.moveToElement(UpBikes).click().build().perform();
		screenShot("ClickOnUpcomingBikes");
		logger.log(Status.PASS, "Identified Element and clicked Successfully");
	}

	@Test(priority = 12)
	public void pageTitle1() {
		verifyPageTitle("Upcoming Bikes in India 2021/22, See Price, Launch Date, Specs @ ZigWheels");
	}

	@Test(priority = 13)
	public void selectHondaCompanyBikes() {
		logger.log(Status.INFO, "Identifying Element HondaBtn_Id");
		WebElement DropDown = getElement("HondaBtn_Id");

		Select company = new Select(DropDown);
		company.selectByVisibleText("Honda");
		screenShot("HondaBikePage");
		logger.log(Status.PASS, "Successfully displaying Honde Bikes");
		logger.log(Status.PASS, "Successfully Retrived Bike Details under 4lac");
		report.flush();
	}

	@Test(priority = 14)
	public void selectingBikes() throws Exception {
		WebElement ViewMore = getElement("ViewMoreBtn_ClassName");
		WebElement moveTo = getElement("MoveTo_ClassName");
		scroll(driver, moveTo);
		click(driver, ViewMore);
		Thread.sleep(5000);

		List<WebElement> bikes = driver.findElements(By.xpath("//div[@class='b fnt-15']"));
		int i = 1;
		int j = 0;
		for (WebElement element : bikes) {
			String price1 = element.getText();
			String price2 = price1.replace("Rs.", "");
			boolean isLakhs = price2.contains("Lakh");
			if (isLakhs) {
				String price3 = price2.replaceAll("[^0-9.0-9]", "");
				float price4 = Float.parseFloat(price3) * 100000;
				int price5 = (int) price4;
				if (price5 < 400000) {

					if (i == 7) {
						i = i + 1;
					}
					WebElement price = driver
							.findElement(By.xpath("//*[@id='modelList']/li[" + i + "]/div/div[3]/div[2]"));
					prices[j] = price.getText();
					WebElement name = driver
							.findElement(By.xpath("//*[@id='modelList']/li[" + i + "]/div/div[3]/a/strong"));
					BikeName[j] = name.getText();
					WebElement Lunch = driver
							.findElement(By.xpath("//*[@id='modelList']/li[" + i + "]/div/div[3]/div[3]"));
					LunchDate[j] = Lunch.getText();
					j++;
				}
				i++;
			}

		}
		System.out.println("*******************************");
		for (int k = 0; k <= 7; k++) {
			WriteExcelUtils write = new WriteExcelUtils();
			write.writeData(prices[k], BikeName[k], LunchDate[k], k + 1);
			System.out.println(prices[k]);
			System.out.println(BikeName[k]);
			System.out.println(LunchDate[k]);
			System.out.println("*******************************");
		}

	}
	@Test(priority = 15,groups = { "SmokeTest" })
	public void clickOnUsedCars() throws InterruptedException {
        driver.navigate().refresh();
		Thread.sleep(2000);
		logger=report.createTest("UsedCars");
		logger.log(Status.INFO, "Identifying Element");
		WebElement UsedCars = driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[5]/a"));
		logger.log(Status.PASS, "Identified Element Successfully");
		Actions action1 = new Actions(driver);
		action1.moveToElement(UsedCars).build().perform();

	}

	@Test(priority = 16,groups = { "SmokeTest" })
	public void clickOnChennaiBtn() {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOf(getElement("ChennaiBtn_Xpath")));
		logger.log(Status.INFO, "Identifying Element: ChennaiBtn_Xpath ");
		getElement("ChennaiBtn_Xpath").click();
		logger.log(Status.PASS, "Identified Element Successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		screenShot("ClickOnChennaiBtn");
	}

	@Test(priority = 17)
	public void pageTile2() {
		verifyPageTitle("Used Cars in Chennai - Certified Second Hand Cars for Sale @ ZigWheels");
	}

	@Test(priority = 18)
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

		int i = 0;
		List<WebElement> cars = driver.findElements(By.xpath("//a[contains(@class,'fnt-22 zm-cmn')]"));
		for (WebElement element : cars) {
			if (i == 25) {
				break;
			} else {
				Cars[i] = element.getText();
				i++;
			}
		}
		WriteExcelUtils write = new WriteExcelUtils();
		try {
			write.writeData1(Cars);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int j = 0; j < 25; j++) {
			System.out.println(Cars[j]);
		}
		screenShot("UsedCarsHomePage");
		logger.log(Status.PASS, "Collect Top Brand Vechicles Details Successfully");
		logger.log(Status.PASS, "------BROWSER CLOSED SUCCESSFULLY------");
		report.flush();
		System.out.println("*******************************");
	}


}
