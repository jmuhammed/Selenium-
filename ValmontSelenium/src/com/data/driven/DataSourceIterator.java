package com.data.driven;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import com.test.methods.TestConfigure;
import com.valmont.container.DataSourceInterface;
import com.valmont.container.InjectObjectsContainer;
import com.valmont.functionality.GettingProperty;
import com.valmont.utilities.ClickAndClear;

public class DataSourceIterator extends TestConfigure {

	ClickAndClear mClickAndClear = new ClickAndClear();
	com.valmont.functionality.Login mLogin = new com.valmont.functionality.Login();
	com.data.driven.PassingTags mpaPassingTags = new PassingTags();
	

	@Test (dataProvider = "myTest", dataProviderClass = StaticProvider.class , groups = {"DataSourceIteration"}) 
	public void testLogin_Regression(String username, String password, String flag)
			throws Exception {

		

		WebDriverWait wait = new WebDriverWait(driver, 300);
		WebElement expectedElement = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.id(prop
						.getProperty("Id_UserTextbox")))));

		prop = GettingProperty.fGettingProperty();
		WebElement mUserName = driver.findElement(By.id(prop
				.getProperty("Id_UserTextbox")));
		driver = mClickAndClear.fClickAndClear(driver, mUserName);
	
		mUserName.sendKeys(username);

		WebElement mUserPassword = driver.findElement(By.id(prop
				.getProperty("Id_UserPassword")));
		driver = mClickAndClear.fClickAndClear(driver, mUserPassword);
		
		mUserPassword.sendKeys(password);

		WebElement mLoginButton = driver.findElement(By.id(prop
				.getProperty("Id_LoginButton")));

		if (flag.equalsIgnoreCase(prop.getProperty("Login_Valid_Yes"))) {

			mLoginButton.click();
			 driver.manage().timeouts().implicitlyWait(3000,
			 TimeUnit.SECONDS);
			Thread.sleep(6000);

			WebElement mLoggedinUsername = driver.findElement(By.id(prop
					.getProperty("Id_LoggedinUsername")));
			String mUsername = mLoggedinUsername.getText().toString();
			System.out.println("The Logged in username is: " + mUsername);

		
			AssertJUnit.assertTrue(
					"Test Method Test Login with the -- " + username
							+ " --and-- " + password + " --is FAILED. ",
							username.equalsIgnoreCase(
							mUsername));
		}

		else {

			mLoginButton.click();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

			Thread.sleep(2000);

			AssertJUnit.assertTrue(
					"Test Method Test Login with the -- " + username
							+ " --and-- " + password + " --is FAILED. ",
					prop.getProperty("Login_ExpectedTitle").equalsIgnoreCase(
							driver.getTitle()));

		}

	}

	
}
