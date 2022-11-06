package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

//child class
public class StepDef extends BaseClass {

	@Before

	public void setUp() throws IOException {

		log = LogManager.getLogger("StepDef");

		rc = new ReadConfig();

		String browser = rc.getBrowser();

		switch (browser) {

		case "chrome":

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

			break;

		case "default":

			driver = null;

			break;
		}

		log.info("setup method executed");
	}

	@After

	public void tearDown(Scenario sc) throws IOException {

//		if(sc.isFailed()==true) {
//
//			String filePath= "G:\\Frameworks\\PrachiCucumberFramework\\PrachiCucumberFramework\\Screenshot\\Test.png";
//
//			TakesScreenshot scrShot=((TakesScreenshot)driver);
//
//			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//			File DestFile=new File(filePath);
//
//			FileUtils.copyFile(SrcFile, DestFile);
//
//		}

		System.out.println("Teardown method executed");

		driver.quit();
	}

	@BeforeStep

	public void beforeStepMethodDemo() {

		System.out.println("This before step...........");
	}

	@AfterStep

	public void addScreenshot(Scenario sc) throws IOException {

		final byte[] scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		sc.attach(scrShot, "image/png", sc.getName());

		System.out.println("This after step...........");

	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginpg = new LoginPage(driver);

		Adncpg = new AddNewCustomerPage(driver);

		SCpg = new SearchCustomerPage(driver);

		log.info("User launch ChromeBrowser");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);

		log.info("url opened");
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String mail, String pwd) {

		loginpg.enterEmail(mail);

		loginpg.enterPassword(pwd);

		log.info("email and password entered");
	}

	@And("Click on Login")
	public void click_on_login() {

		loginpg.clickLoginButton();

		log.info("User clicks on login");
	}

	///////////// login feature//////////////////////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {

			Assert.assertTrue(true); // passed
		} else {

			Assert.assertTrue(false);
		}

		log.info("Page title verified");
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		loginpg.clickLogout();

		log.info("Page title verified");
	}

	@And("close browser")
	public void close_browser() {

		driver.close();

		driver.quit();
	}

	//////////////////// Add new Customer/////////////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		String ActualTitle = Adncpg.getPageTitle();

		String ExpectedTitle = "Dashboard / nopCommerce administration";

		if (ActualTitle.equals(ExpectedTitle)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {

		Adncpg.clickCustomersMenu();
	}

	@And("click on customers Menu Item")
	public void click_on_customers_menu_item() {

		Adncpg.clickCustomersMenuItem();
	}

	@And("click on Add new button")
	public void click_on_add_new_button() {

		Adncpg.clickAddNewButton();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		String ActualTitle = Adncpg.getNewCustomerPageTitle();

		String ExpectedTitle = "Add a new customer / nopCommerce administration";

		if (ActualTitle.equals(ExpectedTitle)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		// Adncpg.enterNewEmail("cs127@gmail.com");

		Adncpg.enterNewEmail(generateEmailId() + "@gamil.com");

		Adncpg.enterNewPassword("test1");

		Adncpg.enterFirstName("Pragati");

		Adncpg.enterLastName("Kolli");

		Adncpg.enterGender("Female");

		Adncpg.enterDateOfBirth("8/8/1992");

		Adncpg.enterCompanyName("MyStudio");

		Adncpg.enterTaxExmpted("Yes");

		Adncpg.enterNewsLetters("Test store 2");

		Adncpg.selectManagerOfVendor("Vendor 1");

		Adncpg.enterAdminComment("AdminContent");

	}

	@And("click on Save button")
	public void click_on_save_button() {

		Adncpg.clickOnSave();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {

		// String ActualconfirmationMessage= Adncpg.getBodyText();

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();

		if (bodyTagText.contains(expectedConfirmationMessage)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
	}

	////////////////////////// Search Customer by Email//////////////////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {

		SCpg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {

		SCpg.clickOnSearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {

		String ExpectedEmailAddress = "victoria_victoria@nopCommerce.com";

		if (SCpg.searchCustomerByEmail(ExpectedEmailAddress) == true) {

			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

	///////////// Search Customer by Name///////////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {

		SCpg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {

		SCpg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {

		String ExpectedName = "Victoria Terces";

		if (SCpg.searchCustomerByName(ExpectedName) == true) {

			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

}
