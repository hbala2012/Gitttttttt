package org.gitss;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipCartLocators extends BaseClass{
	
	public WebElement getNext() {
		return next;
	}

	public FlipCartLocators() {
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closePopup;
    
	@FindBy(xpath="//input[@type='text']")
	private WebElement btnText;
	
	public WebElement getClosePopup() {
		return closePopup;
	}

	public WebElement getBtnText() {
		return btnText;
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public List<WebElement> getPrices() {
		return prices;
	}
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> products;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> prices;
	
	@CacheLookup
	@FindBy(xpath="//nav[@class='yFHi8N']//span")
	private WebElement next;

}
