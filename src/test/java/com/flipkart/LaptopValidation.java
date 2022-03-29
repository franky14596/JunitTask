package com.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaptopValidation {
	
	static WebDriver driver;
	static long starttime;
	
@BeforeClass		
public static void beforeclass() {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

@AfterClass
public static void afterclass() {
	driver.quit();
}

@Test
public void method1() {
	WebElement closebtn = driver.findElement(By.xpath("//button[text()='✕']"));	
	closebtn.click();
	
}

@Test
public void method2() {
	WebElement search = driver.findElement(By.name("q"));
    search.sendKeys("Asus Laptop",Keys.ENTER);
}

@Test
public void method3() {
	WebElement product1 = driver.findElement(By.xpath("(//div[contains(text(),'ASUS')])[1]"));
	product1.click();
	String text1 = product1.getText();
	System.out.println(text1);
	
	WebElement product2 = driver.findElement(By.xpath("(//div[contains(text(),'ASUS')])[2]"));
	product2.click();
	WebElement product3 = driver.findElement(By.xpath("(//div[contains(text(),'ASUS')])[3]"));
	product3.click();
}

@Test
public void method4() {
	
	String parent = driver.getWindowHandle();
	Set<String> subtabs = driver.getWindowHandles();
	List<String> sublist = new ArrayList<String>(subtabs);
	
	String buy = sublist.get(1);
	driver.switchTo().window(buy);
}

@Test
public void method5() {
	WebElement finalprod = driver.findElement(By.xpath("//span[contains(text(),'X413EA')]"));
	String fintext = finalprod.getText();
	System.out.println(fintext); 
	
	
}


@Test
public void method6 () {
	WebElement atc = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
    atc.click();
}
}
