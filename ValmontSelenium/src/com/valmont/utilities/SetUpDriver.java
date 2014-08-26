package com.valmont.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetUpDriver{

	public WebDriver fConfigureDriver() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.navigate()
				.to("http://basestation.valleyirrigation.com/BaseStation3/Pages/Default.aspx#login");
		Thread.sleep(2000);
		return driver;
	}

	

}
