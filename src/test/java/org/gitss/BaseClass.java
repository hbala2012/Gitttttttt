package org.gitss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	  public static WebDriver driver;
	public static WebDriver chrome() {
		
		WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
		return driver;
        
	}
	 
	public static WebDriver firefox() {
		WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
	return driver;

	}
	
	public static void urlLaunch(String url) {
	 driver.get(url);
	 driver.manage().window().maximize();

	}
	
	public static void  implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}
	
	public static void  sendKeys(WebElement e, String value) {
		e.sendKeys(value);
		
	}
	
	public static void bala(WebElement b, String value) {
		
	   b.sendKeys(value);

	}
	
	
	
	public static void click(WebElement e) {
		
		e.click();
	}

	public static String getCurrentUrl() {
		
		//String currentUrl = driver.getCurrentUrl();
		// return currentURl
		return driver.getCurrentUrl();
	
	}
	
	public static String getTitle() {
		return driver.getTitle();
		
	}
	
	
	public static String getText(WebElement e) {
		return e.getText();

	}
	
	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
		
	}
	
	public static void quit() {
		driver.quit();

	}
	
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		
	}
	
	public static void  dragAndDrop(WebElement source , WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source , target).perform();
	}
	
	public static void alertAccept() {
		 Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	public static void alertDismiss() {
		 Alert alert = driver.switchTo().alert();
		alert.dismiss();
	
	}
	
	public static void alertSendKeys(String value) {
	
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		
	}
	
	public static String alertGetText() {
		Alert alert = driver.switchTo().alert();
		// String text = alert.getText();
		// return text;
		return alert.getText();
	
	}
	
	public static void selectByIndex(WebElement e, int index) {
		
	Select s = new Select(e);
	s.selectByIndex(index);

	}
	
	public static void selectbyValue(WebElement e, String value) {
		
		Select s = new Select(e);
		s.selectByValue("value");
	}
	
	public static void  selectByVisibleText(WebElement e, String value) {
		
		Select s = new Select(e);
		s.selectByVisibleText("value");
		
	}
	
     // to take screen shot 
	public static void screenShot(String filename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		 File sourceFile = tk.getScreenshotAs(OutputType.FILE);
	 File destinationFile = new File(System.getProperty("user.dir")+"\\screenshot\\"+filename+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
	}
	
//	public static File sourceFile() {
//		TakesScreenshot tk = (TakesScreenshot)driver;
//		 File sourceFile = tk.getScreenshotAs(OutputType.FILE);
//		return sourceFile;
//	}
//	
//	public static void saveScreenshot(String path) throws IOException {
//			 File destinationFile = new File(path);
//			 FileUtils.copyFile(sourceFile(), destinationFile);
//
//		}
	
	
	public static void  executeScript(String value , WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		 js.executeScript("arguments[0].setAttribute('value','"+value+"')", e);
		
		
	}

	public static void  scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].scrollIntoView(true)", e);
	
	}
	
	public static void  scrollup(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].scrollIntoView(false)", e);
	
	}
	
	public static void  jsScriptClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].click()", e);
	
	}
	
	public static String  jsGetAttribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;   
        Object executeScript2 = js.executeScript("return arguments[0].getAttribute('value')", e);
		String string2 = executeScript2.toString();
		//System.out.println(string2);
		return string2;
	
	}
	
	  public static String getExcelData(String filename, String sheetname, int rowno, int cellno) throws IOException {          
		 
		  File loc = new File(System.getProperty("user.dir")+"\\Excel\\"+filename+".xlsx");
          FileInputStream st = new FileInputStream(loc);
		   Workbook w = new XSSFWorkbook(st);
		    Sheet sheet = w.getSheet(sheetname);
		   Row row = sheet.getRow(rowno);
		   Cell cell = row.getCell(cellno);
		   int type = cell.getCellType();
		  
	
		  String value=null;
		   if(type==1) {
			   value = cell.getStringCellValue();
		   }
		   
		   else {
			   
			   if(DateUtil.isCellDateFormatted(cell)) {
				   value = new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
			   }
			   else {
			
			  value = String.valueOf((long)cell.getNumericCellValue());
			    		
			   }
			    		
		   }
		return value;
    
	}
	  
	  public static void get(WebElement e) {
		e.getAttribute("value");
	}
	  
	  public static void enter() throws AWTException {
	    	Robot r =new Robot();
			 r.keyPress(KeyEvent.VK_ENTER);
			 r.keyRelease(KeyEvent.VK_ENTER);
			 

		}
	  
	  public static void repeat() {
		  FlipCartLocators f = new FlipCartLocators();
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
	        System.out.println(Collections.max(PriceList));
	        System.out.println(Collections.min(PriceList));
	      
			       
	}
	  

	}
	  
	  
	

