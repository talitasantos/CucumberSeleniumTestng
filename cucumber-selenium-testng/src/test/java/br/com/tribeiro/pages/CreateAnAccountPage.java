package br.com.tribeiro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import br.com.tribeiro.util.BaseTest;

public class CreateAnAccountPage extends BaseTest {

	private WebDriver driver;
	
	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "id_gender2")
	private WebElement titleRadio;

	@FindBy(id = "customer_firstname")
	private WebElement firstNameInput;

	@FindBy(id = "customer_lastname")
	private WebElement lastNameInput;

	@FindBy(id = "passwd")
	private WebElement passwordInput;
	
	@FindBy(id = "days")
	private WebElement daySelect;
	
	@FindBy(id = "months")
	private WebElement monthSelect;
	
	@FindBy(id = "years")
	private WebElement yearSelect;

	@FindBy(id = "company")
	private WebElement dateOfBirthDate;

	@FindBy(id = "newsletter")
	private WebElement newsletterCheckbox;
	
	@FindBy(id = "company")
	private WebElement companyInput;

	@FindBy(id = "address1")
	private WebElement addressInput;

	@FindBy(id = "address2")
	private WebElement alternativeAddressInput;

	@FindBy(id = "city")
	private WebElement cityInput;

	@FindBy(id = "id_state")
	private WebElement stateSelect;

	@FindBy(id = "postcode")
	private WebElement postalCodeInput;

	@FindBy(id = "phone")
	private WebElement homePhoneInput;

	@FindBy(id = "phone_mobile")
	private WebElement mobilePhoneInput;

	@FindBy(id = "alias")
	private WebElement aliasInput;

	@FindBy(id = "submitAccount")
	private WebElement registerBtn;

	public void selectTitle() {
		titleRadio.click();
	}

	public void fillFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void fillPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void selectDateOfBirth(String day, String month, String year) {
		Select dayOptions = new Select(daySelect);
		dayOptions.selectByValue(day);
		
		Select monthOptions = new Select(monthSelect);
		monthOptions.selectByValue(month);
		
		Select yearOptions = new Select(yearSelect);
		yearOptions.selectByValue(year);
		
	}
	
	public void selectToReceiveNewsletter() {
		newsletterCheckbox.click();
		
	}

	public void fillCompany(String company) {
		this.companyInput.sendKeys(company);
	}

	public void fillAddress(String address) {
		this.addressInput.sendKeys(address);

	}

	public void fillAddressLineTwo(String addressLineTwo) {
		alternativeAddressInput.sendKeys(addressLineTwo);

	}

	public void fillCity(String city) {
		cityInput.sendKeys(city);
	}

	public void fillState(String state) {
		Select stateOptions = new Select(stateSelect);
		stateOptions.selectByVisibleText(state);

	}

	public void fillPostalCode(String postalCode) {
		postalCodeInput.sendKeys(postalCode);

	}

	public void fillHomePhone(String homePhone) {
		homePhoneInput.sendKeys(homePhone);

	}

	public void fillMobilePhone(String mobilePhone) {
		mobilePhoneInput.sendKeys(mobilePhone);

	}
	
	public void submitAccount() {
		registerBtn.click();
	}
	
	public void verifyMyAccountPage(String myAccountUrl) {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, myAccountUrl );
		
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
