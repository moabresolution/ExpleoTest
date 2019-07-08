package com.expleo.seleniumtest;

//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrencyConverterTest {

	@Test
	public void test() {
	
		WebDriver driver;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DJ Leke Lee\\Documents\\SeleniumWebDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(System.getProperty("user.dir"));
		
	//Launch the URL
		driver.get("http://www.xe.com/currencyconverter/");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	//Accept Cookie
		driver.findElement(By.xpath("//button[@class='privacy-basic-button privacy-basic-button-submit']")).click();
		String[] currencies = {"JPY", "GBP", "EUR", "CAD", "AUD"};

		for (String currency : currencies) {
			
	//Click on From button
		  driver.findElement(By.xpath("//*[@id='converterForm']//form//div[2]/div/div/div[1]")).click();			
		  driver.findElement(By.xpath("//*[@id='converterForm']//form//span[contains(text(),'USD')]")).click();
		  
	//Click on To button    
		  driver.findElement(By.xpath("//*[@id='converterForm']//form//div[3]/div/div/div[1]")).click();
		  driver.findElement(By.xpath("//*[@id=\"converterForm\"]//form//span[contains(text(),"+"'"+currency+"')]")).click();
		
	//Click on Submit button
		  driver.findElement(By.xpath("//*[@id='converterForm']//form//button[2]")).click();
		  
	//Get the Text			    
		  String toAmount = driver.findElement(By.xpath("//span[@class='converterresult-toAmount']")).getText();
		  String toCurrency = driver.findElement(By.xpath("//span[@class='converterresult-toCurrency']")).getText();
	
	//Print out the Equivalent rate and the corresponding Currency symbol			    
		  System.out.println("The exchange rate is " + toAmount + " " + toCurrency );
		
		 driver.navigate().back();
		 
	 }
		driver.quit();
    }			
	     
  }


