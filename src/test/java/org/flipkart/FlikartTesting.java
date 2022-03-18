package org.flipkart;

import java.awt.AWTException;

import org.gitss.BaseClass;
import org.gitss.FlipCartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlikartTesting extends BaseClass {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		chrome();
		urlLaunch("https://www.flipkart.com/");
		implicitWait(20);
		FlipCartLocators f = new FlipCartLocators();
		click(f.getClosePopup());
		sendKeys(f.getBtnText(), "iphone");
		enter();
		
		repeat();
		System.out.println("======================Second Page============================");
		
		click(f.getNext());
        Thread.sleep(3000);
	    
		repeat();
		
		System.out.println("======================Third Page============================");
      
		click(f.getNext());
	    Thread.sleep(3000);
		 
		 repeat();	
		
	}
	

}
