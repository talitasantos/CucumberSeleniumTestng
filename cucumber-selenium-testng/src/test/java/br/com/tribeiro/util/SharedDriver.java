package br.com.tribeiro.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedDriver extends EventFiringWebDriver implements En {

	private static final WebDriver REAL_DRIVER;
	private static final Thread CLOSE_THREAD = new Thread() {

		@Override
		public void run() {
			REAL_DRIVER.close();
		}
	};

	static {
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		try {
			REAL_DRIVER = getBrowser();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			throw new Error(throwable);
		}
	}

	public SharedDriver() {
		super(REAL_DRIVER);

		Before(manage()::deleteAllCookies);

		After((Scenario scenario) -> {
			try {
				byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		});
	}

	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException(
					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
		}
		super.close();
	}

	private static WebDriver getBrowser() throws Throwable {

		String navigatorDriver = PropertyManager.getInstance().getNavigatorDriver();
		String headless = PropertyManager.getInstance().getHeadless();
		String url = PropertyManager.getInstance().getURL();

		WebDriver driver = null;

		if (navigatorDriver.equals("chrome")) {
			// Execute tests by webdriver manager with chromedriver
			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(Boolean.valueOf(headless));
			driver = new ChromeDriver(chromeOptions);
			driver.navigate().to(url);

		} else if (navigatorDriver.contentEquals("firefox")) {
			// Execute tests by webdriver manager with firefox
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(Boolean.valueOf(headless));

			driver = new FirefoxDriver(firefoxOptions);
			driver.navigate().to(url);
		}
		return driver;
	}

}
