package com.training.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static com.training.Utilities.Constants.APPLICATION_PROPERTIES;
import static com.training.Utilities.Constants.USER_DIR;

public class CommonUtilities {

	static Properties props = new Properties();
	static FileInputStream fileIn = null;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	//private static final String APPLICATION_PROPERTIES = null;

	public String getApplicationProperty(String key) throws IOException {
		
		Properties properties = new Properties();
		String filePath = USER_DIR+File.separator+APPLICATION_PROPERTIES;
		FileInputStream inputfile = new FileInputStream(filePath);
		String value ="";
		
		try {
			properties.load(inputfile);
			value = properties.getProperty(key);
			System.out.println("value we got " +value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			inputfile.close();
		}
		
		
		return value;
		
	}
	
}
