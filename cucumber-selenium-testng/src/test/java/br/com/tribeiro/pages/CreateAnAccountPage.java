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
	
	/* PERSONAL INFORMATION */

	@FindBy(css = "input[type='radio'][name='id_gender'][id='id_gender2']")
	private WebElement titleRadio;

	@FindBy(css = "input[type='text'][id='customer_firstname'][name='customer_firstname']")
	private WebElement firstNameInput;

	@FindBy(css = "input[type='text'][id='customer_lastname'][name='customer_lastname']")
	private WebElement lastNameInput;

	@FindBy(css = "input[type='password'][id='passwd'][name='passwd']")
	private WebElement passwordInput;
	
	@FindBy(css = "select[id='days'][name='days']")
	private WebElement daySelect;
	
	@FindBy(css = "select[id='months'][name='months']")
	private WebElement monthSelect;
	
	@FindBy(css = "select[id='years'][name='years']")
	private WebElement yearSelect;

	@FindBy(css = "input[type='checkbox'][name='newsletter'][id='newsletter']")
	private WebElement newsletterCheckbox;
	
	/* ADDRESS INFORMATION */
	
	@FindBy(css = "input[type='text'][id='company'][name='company']")
	private WebElement companyInput;

	@FindBy(css = "input[type='text'][id='address1'][name='address1']")
	private WebElement addressInput;

	@FindBy(css = "input[type='text'][id='address2'][name='address2']")
	private WebElement alternativeAddressInput;

	@FindBy(css = "input[type='text'][id='city'][name='city']")
	private WebElement cityInput;

	@FindBy(css = "select[name='id_state'][id='id_state']")
	private WebElement stateSelect;

	@FindBy(css = "input[type='text'][name='postcode'][id='postcode']")
	private WebElement postalCodeInput;

	@FindBy(css = "input[type='text'][id='phone'][name='phone']")
	private WebElement homePhoneInput;

	@FindBy(css = "input[type='text'][id='phone_mobile'][name='phone_mobile']")
	private WebElement mobilePhoneInput;

	@FindBy(css = "input[type='text'][id='alias'][name='alias']")
	private WebElement aliasInput;

	@FindBy(css = "button[type='submit'][id='submitAccount'][name='submitAccount']")
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
