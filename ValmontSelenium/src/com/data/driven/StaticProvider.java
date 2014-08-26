package com.data.driven;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import com.valmont.container.InjectObjectsContainer;

public class StaticProvider {
	
	@DataProvider(name = "myTest")
	

	public static Object[][] ReadDataFromExcel(Method M) throws Exception {

		System.out.println("The testMethod Name whihc it invokes is:=====>"+ M.getName().toString());
		System.out.println("The testMethod Name whihc it invokes is:=====>"+ M.getDeclaringClass().toString());
		InjectObjectsContainer mInjectObjectsContainer = new InjectObjectsContainer(M.getName().toString());
		Object[][] mUserCredentials = mInjectObjectsContainer.ReadingDataFromFile();
		return mUserCredentials;

	}

}
