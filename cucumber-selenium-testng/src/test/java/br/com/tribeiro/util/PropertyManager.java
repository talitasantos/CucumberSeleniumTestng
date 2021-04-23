package br.com.tribeiro.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	private static PropertyManager instance;
	private static final Object lock = new Object();
	private static String url;
	private static String navigatorDriver;
	private static String headless;

	// Create a Singleton instance. We need only one instance of Property Manager.
	public static PropertyManager getInstance() {
		if (instance == null) {
			synchronized (lock) {
				instance = new PropertyManager();
				instance.loadData();
			}
		}
		return instance;
	}

	// Get all configuration data and assign to related fields.
	private void loadData() {
		// Declare a properties object
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("properties/environment.properties");

			    // load a properties file
			    prop.load(input);
		} catch (FileNotFoundException e1) {
			// Read enviroment.properties file
			try {
				prop.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
			} catch (IOException e) {
				System.out.println("Configuration properties file cannot be found");
			}
		} catch (IOException e1) {
			System.out.println("Configuration properties file cannot be found");
		}
		
		// Get properties from enviroment.properties
		url = prop.getProperty("url");
		navigatorDriver = prop.getProperty("navigatorDriver");
		headless = prop.getProperty("headless");
		
	}

	public String getURL() {
		return url;
	}

	
	public String getNavigatorDriver() {
		return navigatorDriver;
	}
	
	public String getHeadless() {
		return headless;
	}


}
