package com.valmont.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickAndClear {
	
	public WebDriver fClickAndClear(WebDriver driver, WebElement element){
		
		element.click();
		element.clear();
		
		return driver;
		
	}

}
