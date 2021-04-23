package br.com.tribeiro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.tribeiro.util.BaseTest;

public class IndexPage extends BaseTest {
	
	private WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signInButton;
	
	public void clickSignInBtn() {
		this.signInButton.click();
	}

	@Override
	public boolean isAt() {
		return false;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

}
