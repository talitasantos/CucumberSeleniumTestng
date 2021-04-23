package br.com.tribeiro.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
	
	private WebDriver driver;
	protected String pageTitle;
//	private static Logger log = Logger.getLogger(BaseTest.class.getName());

	String url = PropertyManager.getInstance().getURL();

	public BaseTest(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // 20 seconds Implicit Wait
		this.driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public abstract boolean isAt();
	
}
