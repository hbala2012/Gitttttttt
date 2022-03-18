package org.gitss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlipcartTask extends BaseClass {
	
	public static void main(String[] args) throws AWTException {
		
		chrome();
		urlLaunch("https://www.flipkart.com/");
		implicitWait(20);
	    WebElement closePopup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	    click(closePopup);
		WebElement btnText = driver.findElement(By.xpath("//input[@type='text']"));
		sendKeys(btnText, "iphone");
	    enter();
	    
	     List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	    
	     List<String> productsList =new ArrayList<>();
	     for(int i=0;i<products.size();i++) {
			WebElement webElement = products.get(i);
			String text = products.get(i).getText();
		     System.out.println(text);
		     productsList.add(text);
		   
		}
	  
	        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	           List<Integer> PriceList =new ArrayList<>();
	           for(int i=0;i<prices.size();i++) {
	        	   WebElement webElement = prices.get(i);
	        	  String text = webElement.getText();
	        	   String substring = text.substring(1);
	        	   String r="";
	        	   if(substring.contains(",")) {
	        		   r = substring.replace(",", "");
	        	   }
	        	 int integers = Integer.parseInt(r);
	        	   PriceList.add(integers);	        	   
	        	   System.out.println(integers);
	           }
	           Collections.sort(PriceList);
	           System.out.println(PriceList); 
	           System.out.println(Collections.min(PriceList));
	           System.out.println(Collections.max(PriceList));
	           
//	           for (int i = 0; i <products.size(); i++) {
//	        	   
//	        	   System.out.println(productsList.get(i)+"     "+PriceList.get(i));
//				
//			}
	           
	           Map<String, Integer> mp = new LinkedHashMap<>();
	           for (int i = 0; i <products.size(); i++) {
	        	   mp.put(productsList.get(i), PriceList.get(i));
	           }
	           Set<Entry<String, Integer>> entrySet = mp.entrySet();
	           if(productsList.size()==20) {
	        	   for (Entry<String, Integer> entry : entrySet) {
	        		   System.out.println(entry);
	        	   }
				
	           }
	           	      
		
		
		
	     
	}

}
