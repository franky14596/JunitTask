package com.flipkart;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GameBuyValidation {
	
	static WebDriver driver;
	static String text1;
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

@Before
public void beforemethods() {
	long starttime = System.currentTimeMillis();
}

@After
public void aftermethods() {
	long endtime = System.currentTimeMillis();
	System.out.println("Time Taken:" +(endtime - starttime));
}

@Test	 
public void method1() {
WebElement closebtn = driver.findElement(By.xpath("//button[text()='✕']"));	
closebtn.click();
}

@Test
public void method2() {
	Actions a = new Actions(driver);
   WebElement Electronics = driver.findElement(By.xpath("//div[text()='Electronics']"));
   a.moveToElement(Electronics).perform();
   WebElement Gaming = driver.findElement(By.xpath("//a[text()='Gaming']"));
   a.moveToElement(Gaming).perform();
   WebElement Games = driver.findElement(By.xpath("//a[text()='Games']"));
   Games.click();
}

@Test
public void method3() {
	WebElement spiderman = driver.findElement(By.xpath("//a[contains(text(),'Spider-Man')]"));	
    text1 = spiderman.getText();
    System.out.println(text1);
    spiderman.click();

}

@Test
public void method4() {
	String parent = driver.getWindowHandle();
	Set<String> subtab1 = driver.getWindowHandles();
	for (String x : subtab1) {
		if(!parent.equals(subtab1)) {
			driver.switchTo().window(x);
		}
	}
	
}

@Test
public void method5() {
	WebElement spider = driver.findElement(By.xpath("(//span[contains(text(),'Spider-Man')])[1]"));
	String text2 = spider.getText();
	System.out.println(text2);
	if(text1.equals(text2)) {
		System.out.println("PASS");}
	else { System.out.println("FAIL");
	}
	
	
	driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	
	
	
}

@Test
public void method6() throws Exception {
	TakesScreenshot ss =(TakesScreenshot)driver;
	File source = ss.getScreenshotAs(OutputType.FILE);
	File target = new File("C:\\Users\\Franky\\Desktop\\Tasks\\Cartpage.png");
	
	FileUtils.copyFile(source, target);
}

}
