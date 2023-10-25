package com.iNetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBaking.pageObjects.logInPage;
import com.iNetBanking.utilities.xlsUtils;

public class TC_LoginDDT_002 extends baseClass {
	
	@Test(dataProvider = "LoginData")
	public void logInDDT(String Username, String Password) throws IOException {
		logInPage lpage = new logInPage(driver);
		lpage.setUserName(Username);
		logger.info("user name provided");
		lpage.setPassword(Password);
		logger.info("Set password");
		lpage.clickSubmit();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();//focus on main page
			captureScreen(driver, "TC_LoginDDT_002");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			lpage.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
		}

	}
	
	// user defined method to check if alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

		@DataProvider(name = "LoginData")
		String[][] getData() throws IOException {

		String path = System.getProperty("user.dir")+"iNetBankingV1\\src\\test\\java\\com\\iNetBanking\\testData\\Login Data.xlsx";

		int rowNum = xlsUtils.getRowCount(path, "Sheet1");
		int colNum = xlsUtils.getCellCount(path, "Sheet1", 1);

		String logInData[][] = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				logInData[i][j] = xlsUtils.getCellData(path, "Sheet1", i+1, j);// i=1,j=0
			}
		}
		return logInData;

	}

}
