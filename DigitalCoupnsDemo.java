package com.heb;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HebDigitalCouponsDemo1 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.heb.com");
	}

	@Test
	public void useDigitalCoupons() throws InterruptedException {

		// click on Coupons button
		driver.findElement(By.xpath("//*[.='Coupons']")).click(); // xpath by text name.
		// click on Log in button on a pop-up
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[.='Log In'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-email")).sendKeys("vokiwafaya@99pubblicita.com");
		Thread.sleep(1000);
		driver.findElement(By.id("reg-password")).sendKeys("hebdemo1");
		Thread.sleep(1000);
		driver.findElement(By.id("login-submit")).click();

		// verify "Howdy, John" is displayed
		String expectedName = "Howdy, John";
		// getting actual name text from the top right corner of the page
		String actualName = driver.findElement(By.id("myaccountSId")).getText();
		// verifying I logged in successfully and seeing an expected name
		Assert.assertEquals(actualName, expectedName);

		// assigning all select coupon buttons to a list
		List<WebElement> allSelectButtons = driver.findElements(By.xpath("//*[.='Select Coupon']"));

		// clicking on all visible select coupons using for each loop
		for (WebElement eachButton : allSelectButtons) {
			// clicking on select coupon button
			Thread.sleep(1000);
			eachButton.click();
		}
	}

	@AfterClass
	public void tearDownClass() throws InterruptedException {
		Thread.sleep(80000);
		driver.quit();
	}
}
