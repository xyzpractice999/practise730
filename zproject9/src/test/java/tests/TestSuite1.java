package tests;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.FrameWorkUtils;

public class TestSuite1 {

	@Test
	public void testLogin() throws Exception, IOException {
		String dataPath = "C:\\Users\\suman\\eclipse-workspace237241\\zproject9\\src\\test\\resources\\testdata\\datadriven.xlsx";
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		FrameWorkUtils.setUpDriver();
		BrowserUtils.launchBrowser();
		BrowserUtils.invokeApp();
		loginPage.verifyLoginPage();
		// read data from excel
		XSSFWorkbook w = new XSSFWorkbook(new File(dataPath));
		XSSFSheet s = w.getSheetAt(0);
		int rows = s.getLastRowNum();
		for (int i = 1; i <= rows; i++) {
			String userid=s.getRow(i).getCell(1).getStringCellValue();
			String pswd=s.getRow(i).getCell(2).getStringCellValue();
			String msg=s.getRow(i).getCell(3).getStringCellValue();
			loginPage.performlogin(userid,pswd,msg);
			homePage.logout();
		}
		//homePage.verifyHomepage();
		//homePage.logout();
		BrowserUtils.killBrowser();

	}

}
