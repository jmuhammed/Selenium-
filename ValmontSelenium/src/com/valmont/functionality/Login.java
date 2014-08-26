package com.valmont.functionality;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.data.driven.RegressionLoginDataDriven;
import com.valmont.utilities.ClickAndClear;
import com.valmont.utilities.DragAndDrop;

public class Login {

	Properties prop;
	RegressionLoginDataDriven mLoginDataDriven = new RegressionLoginDataDriven();
	ClickAndClear mClickAndClear = new com.valmont.utilities.ClickAndClear();
	DragAndDrop mDragAndDrop = new DragAndDrop();

	public WebDriver fLogin(WebDriver driver, String username, String password)
			throws Exception {

		Thread.sleep(6000);

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
		mLoginButton.click();
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(6000);

		return driver;
	}

	public WebDriver ffarmSelection(WebDriver driver, String mFarmName,
			List mClassAndTagNameList) throws Exception {

		int flag = 0;
		System.out.println("The total count in the list is: "
				+ mClassAndTagNameList.size());
		WebElement mfarmandadmin_div = driver.findElement(By.id(prop
				.getProperty("Id_farmandadmin_div")));
		WebElement mrole_farms = mfarmandadmin_div.findElement(By
				.id((mClassAndTagNameList.get(0).toString())));

		WebElement mFarmPicker = mrole_farms.findElement(By.tagName(prop
				.getProperty("tag_a")));
		System.out.println("The Farm Picker arrow text is: "
				+ mFarmPicker.getText().toString());
		mFarmPicker.click();

		WebElement mfarmdropdowndiv = mrole_farms.findElement(By
				.id((mClassAndTagNameList.get(1).toString())));
		mfarmdropdowndiv.click();

		WebElement mFarmList = mfarmdropdowndiv.findElement(By.tagName(prop
				.getProperty("tag_ul")));
		System.out.println("Clicked");

		List<WebElement> mListofFarms = mFarmList.findElements(By
				.className(prop.getProperty("Class_ui-btn-text")));
		WebElement mDraggerBar = mfarmdropdowndiv.findElement(By.className(prop
				.getProperty("Class_mCSB_dragger_bar")));

		System.out.println("-->>>The total item in the Farm List is: "
				+ mListofFarms.size());

		if (mListofFarms.size() > 0) {

			for (int i = 0; i < mListofFarms.size(); i++) {

				if (flag == 0) {
					if (mClassAndTagNameList.get(2).equals("group")) {
						flag = flag + 1;
						mListofFarms.get(0).click();
						Thread.sleep(3000);
					}
				}

				if (!mListofFarms.get(i).getText().isEmpty()) {

					if (mFarmName.equalsIgnoreCase(mListofFarms.get(i)
							.getText())) {
						mListofFarms.get(i).click();

						System.out.println("Entering...????");
						break;
					}

					System.out
							.println("The element in the farm list at the position [ "
									+ i
									+ " ] is : "
									+ mListofFarms.get(i).getText());
				} else {

					driver = mDragAndDrop.fDragAndDrop(driver, mDraggerBar);

					if (mFarmName.equalsIgnoreCase(mListofFarms.get(i)
							.getText())) {
						mListofFarms.get(i).click();

						System.out.println("Entering...????");
					}

					System.out
							.println("The element in the farm list at the position [ "
									+ i
									+ " ] is : "
									+ mListofFarms.get(i).getText());
				}

			}
			
			if(mClassAndTagNameList.get(2).equals("group")){
				
				mFarmPicker.click();
				
			}
		}

		Thread.sleep(3000);
		return driver;
	}

	public WebDriver fLogOut(WebDriver driver){
		
		WebElement mLoginStatus = driver.findElement(By.id(prop.getProperty("Id_LoginStatus")));
		WebElement mLoginForm1 = mLoginStatus.findElement(By.id(prop.getProperty("Id_LoginForm1")));
		WebElement maLogout = mLoginForm1.findElement(By.id(prop.getProperty("Id_aLogout")));
		maLogout.click();
		
		return driver;
	}

	/*public WebDriver fSelectDevice(WebDriver driver){
		
		WebElement mId_content = driver.findElement(By.id(prop.getProperty("Id_content")));
		WebElement mId_pivotWrap = mId_content.findElement(By.id(prop.getProperty("Id_pivotWrap")));
		WebElement mDeviceId = driver.findElement(By.id(prop.getProperty("Id_pivot_main_div")));
		
		WebElement mDeviceSelection = mDeviceId.findElement(By.id(prop.getProperty("Id_DeviceSelection")));
		WebElement mCircleSelection = mDeviceSelection.findElement(By.id(prop.getProperty("Id_CircleSelection")));
		
		mCircleSelection.click();
		
		return driver;
	}*/
	
	public WebDriver fSelectDevice(WebDriver driver, boolean mSelectDevice) throws Exception{
		
		WebElement mPivotPanel = driver.findElement(By.id(prop.getProperty("Id_pivot_main_div")));
		WebElement mInnerPanel = mPivotPanel.findElement(By.id(prop.getProperty("Id_pivot_main_div_1")));
		List<WebElement> mDeviceList = mInnerPanel.findElements(By.tagName(prop.getProperty("tag_g")));
		System.out.println("Total number of device in the screen is: "+mDeviceList.size());
		for(int i=0; i<mDeviceList.size(); i++){
			
			if(i== Integer.parseInt(prop.getProperty("In_DeviceIndex"))){
//			WebElement mCircleSelection = mDeviceList.get(Integer.parseInt(prop.getProperty("In_DeviceIndex"))).findElement(By.id(prop.getProperty("Id_CircleSelection")));
				WebElement mCircleSelection = mDeviceList.get(Integer.parseInt(prop.getProperty("In_DeviceIndex")));
				
				if(mSelectDevice==true){
					mCircleSelection.click();
				}
				else
				{
//					WebElement mTagname = mCircleSelection.findElement(By.tagName(prop.getProperty("tag_g")));
					System.out.println("Enetring the loop to mousehover..!!!");
					Actions actions = new Actions(driver);
					
					actions.click(mCircleSelection).build();
//					actions.moveToElement(mCircleSelection).build();
					actions.perform();
					Thread.sleep(5000);
				   actions.release();
					
					
				}
			}
			
		}
		
		return driver;
		
	}
	
}
