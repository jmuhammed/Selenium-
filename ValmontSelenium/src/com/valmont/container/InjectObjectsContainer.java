package com.valmont.container;

import com.data.driven.FunctionalLoginDataDriven;
import com.data.driven.RegressionLoginDataDriven;

public class InjectObjectsContainer {

	DataSourceInterface mDataSourceInterface;

	public String[][] ReadingDataFromFile() throws Exception {

		return mDataSourceInterface.fReadingData();
	}

	public InjectObjectsContainer(String mParamFromDataSource) {

		if (mParamFromDataSource.equalsIgnoreCase("testLogin_Regression")) {
			
			this.mDataSourceInterface = new RegressionLoginDataDriven();
		} else if (mParamFromDataSource.equalsIgnoreCase("testLogin_Functional")){
			
			this.mDataSourceInterface = new FunctionalLoginDataDriven();
		}

	}

}
