package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {		

		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="Email")

	WebElement email;

	@FindBy(id="Password")

	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")

	WebElement login;
	
	@FindBy(linkText = "Logout")
	
	WebElement logout;

	public void enterEmail(String Email) {
		
		email.clear();

		email.sendKeys(Email);

	}
	public void enterPassword(String Password) {
		
		password.clear();

		password.sendKeys(Password);

	}
	public void clickLoginButton() {

		login.click();

	}	
	public void clickLogout() {

		logout.click();

	}

}
