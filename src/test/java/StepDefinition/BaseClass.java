package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//It is a parent class

public class BaseClass {
	
public static WebDriver driver;
	
	public LoginPage loginpg;
	
	public AddNewCustomerPage Adncpg;
	
	public SearchCustomerPage SCpg;

	public static Logger log;
	
	public ReadConfig rc;
	
	
	//generates unique email id
	
	public String generateEmailId() {
		
		return(RandomStringUtils.randomAlphabetic(5));
		
	}
	

}
