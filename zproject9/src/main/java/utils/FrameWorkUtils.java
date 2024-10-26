package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameWorkUtils {

	public static void setUpDriver() {
		WebDriverManager.chromedriver().setup();
		
	}

}
