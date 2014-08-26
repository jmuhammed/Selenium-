package com.valmont.utilities;

import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.valmont.functionality.GettingProperty;

public class DragAndDrop {

	Properties prop;

	public WebDriver fDragAndDrop(WebDriver driver, WebElement mDraggerBar)
			throws Exception {

		prop = GettingProperty.fGettingProperty();

		System.out.println("the location of dragger bar is: "
				+ mDraggerBar.getLocation());
		Point location = mDraggerBar.getLocation();

		Actions actions = new Actions(driver);
		Action action = actions.dragAndDropBy(mDraggerBar, (location.x) + 50,
				(location.y) + 30).build();
		action.perform();
		actions.release();
		return driver;
	}

}
