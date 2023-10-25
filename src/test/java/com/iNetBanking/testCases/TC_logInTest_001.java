package com.iNetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBaking.pageObjects.logInPage;

public class TC_logInTest_001 extends baseClass {
	
	@Test
	public void logInTest() throws IOException {
		logger.info("URL is opened");
		logInPage lPageObj=new logInPage(driver);
		lPageObj.setUserName(userName);
		logger.info("Entered UserName");
		lPageObj.setPassword(password);
		logger.info("Entered Password");
		lPageObj.clickSubmit();
		logger.info("Clicked on Submit");
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login successfull");
		}
		else {
			captureScreen(driver,"logInTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
			
			
		}
	}
}
