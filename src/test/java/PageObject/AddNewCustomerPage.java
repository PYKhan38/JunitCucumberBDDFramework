package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;


	public AddNewCustomerPage(WebDriver rdriver) {

		ldriver=rdriver;		

		PageFactory.initElements(rdriver, this);			
	}

	@FindBy(xpath ="//a[@href='#']//p[contains(text(),'Customers')]")

	WebElement Customer_menu;

	@FindBy(xpath ="//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]")

	WebElement Customer_menuitem;

	@FindBy(xpath ="//a[@class='btn btn-primary']")

	WebElement Add_new_button;
	
	@FindBy(xpath ="//input[@id='Email']")

	WebElement New_Email;
	
	@FindBy(xpath ="//input[@id='Password']")

	WebElement New_Password;
	
	@FindBy(xpath ="//input[@id='FirstName']")

	WebElement Firstname;
	
	@FindBy(xpath ="//input[@id='LastName']")

	WebElement Lastname;
	
	@FindBy(xpath ="//input[@id='Gender_Female']")

	WebElement FeMaleGender;
	
	@FindBy(id = "Gender_Male")
	
	WebElement MaleGender;	
	
	@FindBy(xpath ="//input[@id='DateOfBirth']")

	WebElement Date_Of_Birth;		
	
	@FindBy(xpath ="//input[@id='Company']")

	WebElement Company_Name;		
	
	@FindBy(xpath ="//input[@id='IsTaxExempt']")

	WebElement Is_Tax_Exempted;		
	
	@FindBy(xpath ="//input[@class='k-input k-readonly']")

	WebElement News_Letter;		
	
	@FindBy(xpath ="//li[text()='Your store name']")

	WebElement Your_store_name;	
	
	@FindBy(xpath ="//li[text()='Test store 2']")

	WebElement Test_Strore;		
	
	@FindBy(xpath ="//select[@id='VendorId']")

	WebElement Manager_Of_Vendor;	
	
	@FindBy(xpath ="//textarea[@id='AdminComment']")

	WebElement AdminComment;
	
	@FindBy(xpath="//button[@name='save']")
	
	WebElement Save;
	
	@FindBy(tagName="body")
	
	WebElement Confirmation;
	
//////////////Actions///////////
	
	public String getPageTitle() {
		
		return ldriver.getTitle();		
	}	
	public void clickCustomersMenu() {

		Customer_menu.click();  	
	}
	public void clickCustomersMenuItem() {

		Customer_menuitem.click();  	
	}
	public void clickAddNewButton() {

		Add_new_button.click();  
	}
    public String getNewCustomerPageTitle() {
		
		return ldriver.getTitle();		
	}		
	public void enterNewEmail(String email) {

		New_Email.sendKeys(email);
	}
	public void enterNewPassword(String pwd) {

		New_Password.sendKeys(pwd);;  
	}
	public void enterFirstName(String firstName) {

		Firstname.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {

		Lastname.sendKeys(lastName);
	}
	
	public void enterGender(String gender) {

		if(gender.equals("Male"))
		{
			MaleGender.click();
		}
		else 
		{
			FeMaleGender.click();				
		}		
	}
	
	public void enterDateOfBirth(String dob) {

		Date_Of_Birth.sendKeys(dob);   		
	}	
	
	public void enterCompanyName(String companyname) {

		Company_Name.sendKeys(companyname);  
	}
	
	public void enterTaxExmpted(String yes) {

		if(yes.equals("Yes"))
			
		Is_Tax_Exempted.click();		
	}	
	
	public void enterNewsLetters(String storename) {		

		News_Letter.click();
		
		if(storename.equals("Your store name"))
		{
			Your_store_name.click();				
		}
		else if(storename.equals("Test store 2")) 
		{
			Test_Strore.click();				
		}			
	}		
	
	public void selectManagerOfVendor(String text) {
		
		Select s= new Select(Manager_Of_Vendor);
		
		s.selectByVisibleText(text);
	}
		
	public void enterAdminComment(String admincontent) {

		AdminComment.sendKeys(admincontent);
	}
	public void clickOnSave() {

		Save.click();  
	}
	
	public String getBodyText() {

		return Confirmation.getText();  
	}

}
