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

public class DigitalCoupnsDemo {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.heb.com");
	}
	
	@Test
	public void useDigitalCoupons() {
		driver.findElement(By.xpath("//*[.='Coupons']")).click();
		driver.findElement(By.xpath("(//*[.='Log In'])[2]")).click();
		driver.findElement(By.id("login-email")).sendKeys("vokiwafaya@99pubblicita.com");
		driver.findElement(By.id("reg-password")).sendKeys("hebdemo1");
		driver.findElement(By.id("login-submit")).click();
		String expectedName="Howdy, John";
		String actualName = driver.findElement(By.id("myaccountSId")).getText();
		Assert.assertEquals(actualName, expectedName);
		
		List<WebElement>allSelectCoupns = driver.findElements(By.xpath("//*[.='Select Coupon']"));
		for (WebElement eachButton : allSelectCoupns) {
			eachButton.click();
			
		}
		
		
	}
	@AfterClass
	public void tearDownClass() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
