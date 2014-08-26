package com.valmont.functionality;

import java.io.FileInputStream;
import java.util.Properties;

public class GettingProperty {
	
	public static Properties prop =null;
	public static synchronized Properties fGettingProperty() throws Exception{
		if(prop==null){
			
			prop= new Properties();
			//FileInputStream fs = new FileInputStream("D:\\D_drive\\eclipse_workspace\\ValmontSelenium\\RelatedFiles\\Core.properties");
			FileInputStream fs = new FileInputStream(".\\RelatedFiles\\Core.properties");
			prop.load(fs);
		}
		return prop;
	}

}
