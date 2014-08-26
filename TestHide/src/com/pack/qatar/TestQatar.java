package com.pack.qatar;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestQatar {

	public void testdrop() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\IronWASP\\chromedriver.exe");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capability.setCapability(ChromeOptions.CAPABILITY, options);

		//capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
	//	WebDriver driver = new ChromeDriver(options);
		WebDriver driver=new FirefoxDriver();
		JavascriptExecutor jex=(JavascriptExecutor)driver;
		driver.get("http://www.qatarairways.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 List <WebElement> wtabs=driver.findElements(By.id("tabContainerDIV_Home").id("flighttab_wrapper").className("darkpurple_tabs"));
		System.out.println(wtabs.toString());
		driver.findElement(By.className("darkpurple_tabs"));
		
		Thread.sleep(3000);
		/*Boolean result=(Boolean) jex.executeScript("$(document).ready()");
	  System.out.println(result);*/
		jex.executeScript(" $(\"[title=Click to search our timetables]\").click();");
		
		WebElement text=driver.findElement(By.id("TFromTemp"));
	    text.click();
	    text.sendKeys("maa");
	    Thread.sleep(3000);
	    jex.executeScript("$(\".ui-menu-item\").click();");
	    WebElement textdest=driver.findElement(By.id("TToTemp"));
	    textdest.click();
	    Thread.sleep(3000);
	    textdest.sendKeys("qat");
	    Thread.sleep(3000);
	    jex.executeScript("$(\".ui-menu-item\").click();");
	    Thread.sleep(3000);
	    jex.executeScript("$('#timeTableResult').click();");
	}
	public static void main(String[] args) throws Exception {
		TestQatar tq=new TestQatar();
		tq.testdrop();
	}

}
