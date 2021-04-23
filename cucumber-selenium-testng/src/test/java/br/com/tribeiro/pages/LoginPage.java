package br.com.tribeiro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.tribeiro.util.BaseTest;

public class LoginPage extends BaseTest {

	private WebDriver driver;
	
	@FindBy(id = "SubmitCreate")
	private WebElement createAnAccountButton;

	@FindBy(id = "email_create")
	private WebElement emailAddressLeftInput;

	@FindBy(css = "email")
	private WebElement emailAddressRightInput;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void accessCreateAnAccountPage() {
		createAnAccountButton.click();
	}
	
	public void enterEmailAddressLeft(String emailLeft) {
		emailAddressLeftInput.sendKeys(emailLeft);
	}
	
	@Override
	public boolean isAt() {
		return false;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
