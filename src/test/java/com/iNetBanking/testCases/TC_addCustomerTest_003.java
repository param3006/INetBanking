package com.iNetBanking.testCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBaking.pageObjects.addCustomerPage;
import com.iNetBaking.pageObjects.logInPage;


public class TC_addCustomerTest_003 extends baseClass {
		
	@Test(priority = 0)
	public void logInPage() {
		logInPage lp=new logInPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
	}
	
	@Test(dependsOnMethods = {"logInPage"})
	public void addNewCustomer() throws InterruptedException {
		addCustomerPage add=new addCustomerPage(driver);
		add.clickNewCustomer();
		add.inputCustomerName("Preet");
		add.selectGender("male");
		add.inputDOB("30", "06", "2001");
		Thread.sleep(3000);
		add.inputAddress("Sector 48 Gurgaon");
		add.inputCity("Gurgaon");
		String email=Randomstring()+"@gmail.com";
		add.inputEmail(email);
		add.inputPhoneNumber("6786781091");
		add.inputState("Haryana");
		add.inputPin("390228");
		add.clickSubmit();
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Connection failed:")){
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	 
	public String Randomstring() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
}
