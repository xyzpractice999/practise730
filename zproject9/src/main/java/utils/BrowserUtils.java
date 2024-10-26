package utils;

import static app.Common.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtils {

	public static void launchBrowser() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	public static void invokeApp() {
		driver.get("https://parabank.parasoft.com/");
		
	}

	public static void killBrowser() {
		driver.quit();
		
	}

}
