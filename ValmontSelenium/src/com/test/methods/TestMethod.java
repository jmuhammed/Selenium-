package com.test.methods;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.driven.FunctionalLoginDataDriven;
import com.data.driven.RegressionLoginDataDriven;
import com.data.driven.PassingTags;
import com.data.driven.StaticProvider;
import com.valmont.container.DataSourceInterface;
import com.valmont.container.InjectObjectsContainer;
import com.valmont.functionality.GettingProperty;

public class TestMethod extends TestConfigure {
	
	

	RegressionLoginDataDriven mLoginDataDriven = new RegressionLoginDataDriven();
	com.valmont.utilities.ClickAndClear mClickAndClear = new com.valmont.utilities.ClickAndClear();
	com.valmont.functionality.Login mLogin = new com.valmont.functionality.Login();
	com.data.driven.PassingTags mpaPassingTags = new PassingTags();
	
	ArrayList<String> mClassAndTagNameList;
	
	@Test (dataProvider = "myTest" , dataProviderClass = StaticProvider.class)
	public void testLogin_Functional(String username, String password, String flag)
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

	@Test
	public void testSelectFarms()throws Exception{
		
		prop = GettingProperty.fGettingProperty();  
		mClassAndTagNameList = new ArrayList<String>();
		
		mClassAndTagNameList = mpaPassingTags.fPassingParameters(0);
		
		driver = mLogin.fLogin(driver, prop.getProperty("In_UserName"), prop.getProperty("In_PassWord"));
		driver = mLogin.ffarmSelection(driver, prop.getProperty("In_FarmName"), mClassAndTagNameList);
		mClassAndTagNameList.clear();
		mClassAndTagNameList = mpaPassingTags.fPassingParameters(1);
		driver = mLogin.ffarmSelection(driver, prop.getProperty("In_UnGrouped"), mClassAndTagNameList);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver = mLogin.fSelectDevice(driver, true);
		Thread.sleep(3000);
		
	}

	@Test
	public void testLogOut()throws Exception{
		
		driver = mLogin.fLogin(driver, prop.getProperty("In_UserName"), prop.getProperty("In_PassWord"));
		Thread.sleep(2000);
		System.out.println("The current Url Is: "+driver.getCurrentUrl().toString());
		driver = mLogin.fLogOut(driver);
		Thread.sleep(6000);
		System.out.println("The current Url Is: "+driver.getCurrentUrl().toString());
		Thread.sleep(4000);
		AssertJUnit.assertFalse("Logout Method got FAILED..!!!!", driver.getCurrentUrl().toString().equals("http://basestation.valleyirrigation.com/basestation3/pages/#landing"));
	}
	
	@Test
	public void testSupplementaryStatus() throws Exception{
		
		
		prop = GettingProperty.fGettingProperty();  
		mClassAndTagNameList = new ArrayList<String>();
		
		mClassAndTagNameList = mpaPassingTags.fPassingParameters(0);
		driver = mLogin.fLogin(driver, prop.getProperty("In_UserName"), prop.getProperty("In_PassWord"));
		driver = mLogin.ffarmSelection(driver, prop.getProperty("In_FarmName"), mClassAndTagNameList);
		mClassAndTagNameList.clear();
		
		mClassAndTagNameList = mpaPassingTags.fPassingParameters(1);
		driver = mLogin.ffarmSelection(driver, prop.getProperty("In_UnGrouped"), mClassAndTagNameList);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
//		driver = mLogin.fSelectDevice(driver, false);
		Thread.sleep(3000);
		
		WebElement mSupplementaryDetailsPopup = driver.findElement(By.id(prop.getProperty("Id_supplementaryDetails_popup")));
		WebElement mSupplementaryDetails = mSupplementaryDetailsPopup.findElement(By.id(prop.getProperty("Id_supplementaryDetails")));
		WebElement mSupdetails = mSupplementaryDetails.findElement(By.id(prop.getProperty("Id_supdetails")));
		List<WebElement> mListOfDetails = mSupdetails.findElements(By.className(prop.getProperty("Class_pivotDetail")));
		System.out.println("the etxt in pivot detail is: "+mListOfDetails.get(0).getText());
//		List<WebElement> mListOfDetails = mSupdetails.findElements(By.tagName(prop.getProperty("tag_p")));
		System.out.println("The Count of the list items in supplementary is: "+mListOfDetails.size());
	}
}


