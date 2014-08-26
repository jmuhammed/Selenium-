package com.data.driven;

import java.util.ArrayList;
import java.util.Properties;

import com.valmont.functionality.GettingProperty;

public class PassingTags {
	
	Properties prop;
	ArrayList<String> mTagnames;
	public ArrayList<String> fPassingParameters(int flag) throws Exception{
		
		mTagnames = new ArrayList<String>();
		prop = GettingProperty.fGettingProperty();
		if(flag==0){
			
			mTagnames.add(0, prop.getProperty("Id_role_farms").toString());
			mTagnames.add(1,prop.getProperty("Id_farmdropdowndiv").toString());
			mTagnames.add(2,prop.getProperty("In_Farm").toString());
			
		}
		
		else
		{
			mTagnames.add(0, prop.getProperty("Id_role_groups").toString());
			mTagnames.add(1,prop.getProperty("Id_groupdropdowndiv").toString());
			mTagnames.add(2,prop.getProperty("In_Group").toString());
		}
		
		return mTagnames;
	}

}
