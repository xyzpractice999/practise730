package pages;

import org.openqa.selenium.By;
import static app.Common.driver;

public class LoginPage {

	public By edit_username = By.xpath("//input[@name='username']");
	public By edit_password = By.xpath("//input[@name='password']");
	public By btn_login = By.xpath("//input[@value='Log In']");
	public By txt_customer_login = By.xpath("//h2[normalize-space()='Customer Login']");

	public void performlogin(String userid, String pswd, String msg) {
		driver.findElement(edit_username).sendKeys(userid);
		driver.findElement(edit_password).sendKeys(pswd);
		driver.findElement(btn_login).click();
		try {
			if (driver.findElement(By.xpath("//*[text()='" + msg + "']")).isDisplayed()) {
				System.out.println("Pass - login is successfull");
			}
		} catch (Exception e) {
			System.out.println("Fail - login is not successfull");
		}

	}

	public void verifyLoginPage() {
		if (driver.findElement(txt_customer_login).isDisplayed()) {
			System.out.println("Pass - user is in login page");
		} else {
			System.out.println("Fail - user is not in login page");
		}

	}

}
