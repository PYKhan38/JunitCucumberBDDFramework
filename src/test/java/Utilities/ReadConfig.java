package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class ReadConfig {

	Properties pro;

	String path = "config.properties";

	//constructor
	
	public ReadConfig() {
		
		try {
			pro = new Properties();

			FileInputStream  fis = new FileInputStream(path);
			
			pro.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}	

	public String getBrowser()
	{
		String value = pro.getProperty("browser");

		if(value!=null)
			
			return value;
		
		else		
			
			throw new RuntimeException("url not specified in config file.");

	}

	

}