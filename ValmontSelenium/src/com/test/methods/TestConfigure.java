package com.test.methods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.valmont.functionality.GettingProperty;

public class TestConfigure {

	public Properties prop;
	public WebDriver driver;

	
	/*@BeforeMethod
	
	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		prop = GettingProperty.fGettingProperty();
		driver.navigate().to(prop.getProperty("In_Url"));
		System.out.println("Before Test----> Configured");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Thread.sleep(3000);
	}*/

	
	@AfterMethod
	
	public void tearDown() throws Exception {

		driver.quit();

		System.out.println("After Test----> Ending the Execution");

	}

@BeforeMethod
	
	public void setUp() throws Exception {

	
	URL hubUrl = new URL("http://10.5.50.40:4444/wd/hub");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName("firefox");
	capabilities.setPlatform(Platform.WINDOWS);
	driver = new RemoteWebDriver(hubUrl, capabilities);
	
	
		
		prop = GettingProperty.fGettingProperty();
		driver.navigate().to(prop.getProperty("In_Url"));
		System.out.println("Before Test----> Configured");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Thread.sleep(3000);
	}
	
}
