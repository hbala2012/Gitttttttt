package org.gitss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlipcartTask extends BaseClass {
	
	public static void main(String[] args) throws AWTException {
		
		chrome();
		urlLaunch("https://www.flipkart.com/");
		implicitWait(20);
	    WebElement btn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	    click(btn);
		WebElement txt = driver.findElement(By.xpath("//input[@type='text']"));
		sendKeys(txt, "iphone");
	    enter();
	    
	     List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	     List<String> productname =new ArrayList<>();
	     for(int i=0;i<products.size();i++) {
			WebElement webElement = products.get(i);
			String text = products.get(i).getText();
		     System.out.println(text);
		     productname.add(text);
		     productname.get(2);
	
		}
	  
	        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	         int size = prices.size();
	           System.out.println(size);
	           for(int i=0;i<prices.size();i++) {
	        	   
	        	   WebElement webElement = prices.get(i);
	        	   String text = webElement.getText();
	        	   System.out.println(text);
	        	   
	           }
	        
		        
//		        Map<String, Integer> mp = new LinkedHashMap<>();
//		         mp.put(key, value)
//		      
//	
	     
	}

}
