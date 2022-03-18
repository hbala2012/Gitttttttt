package org.gitss;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlipcartFinal extends BaseClass{
	
	public static void main(String[] args) throws AWTException {
		chrome();
		urlLaunch("https://www.flipkart.com/");
		implicitWait(20);
		FlipCartLocators f = new FlipCartLocators();
		click(f.getClosePopup());
		sendKeys(f.getBtnText(), "iphone");
		enter();
		
		List<String> productsList =new ArrayList<>();
	     for(int i=0;i<f.getProducts().size();i++) {
		     productsList.add(f.getProducts().get(i).getText());
		     System.out.println(f.getProducts().get(i).getText());
	     }
	             
         List<Integer> PriceList =new ArrayList<>();
         for(int i=0;i< f.getPrices().size();i++) {
      	   String substring =  f.getPrices().get(i).getText().substring(1);
      	   String r="";
      	   if(substring.contains(",")) {
      		   r = substring.replace(",", "");
      	   }       	   
      	 PriceList.add(Integer.parseInt(r));
      	 System.out.println(Integer.parseInt(r));
         }
        Collections.sort(productsList);
        System.out.println(productsList);
        Collections.sort(PriceList);
        System.out.println(PriceList);
        
//      System.out.println("First Page products");
//      for (int i = 0; i <f.getProducts().size() ; i++) {
//     	 System.out.println(productsList.get(i));			
//		}
//      System.out.println("First page price list");
//     for (int i = 0; i <PriceList.size() ; i++) {
//    	 System.out.println(PriceList.get(i));			
//		}
        
//          WebElement next = driver.findElement(By.xpath("//nav[@class='yFHi8N']//span"));
//          next.click();
          
//          System.out.println("Second page price list");
//          for (int i = 0; i <products.size() ; i++) {
//         	 System.out.println(productsList.get(i));			
 		
          
          
	}

}
