package com.iNetBaking.pageObjects;

import org.apache.commons.codec.language.bm.PhoneticEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage {

	WebDriver driver;

	public addCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement newCustomerlink;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	@CacheLookup
	WebElement customerName;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement radioBtnFemale;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement radioBtnMale;

	@FindBy(xpath = "//*[@id=\"dob\"]")
	@CacheLookup
	WebElement dateOfBirth;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	@CacheLookup
	WebElement Address;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
	@CacheLookup
	WebElement Pin;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
	@CacheLookup
	WebElement telephoneNumber;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[2]")
	@CacheLookup
	WebElement btnReset;

	public void clickNewCustomer() {
		newCustomerlink.click();
	}

	public void inputCustomerName(String valCustomerName) {
		customerName.sendKeys(valCustomerName);
	}

	public void selectGender(String gender) {
		if (gender.equals("male")) {
			radioBtnMale.click();
		} else if (gender.equals("female")) {
			radioBtnFemale.click();
		} else {
			System.out.println("Specify Gender please!!!");
		}
	}

	public void inputAddress(String address) {
		Address.sendKeys(address);
	}

	public void inputCity(String city) {
		this.city.sendKeys(city);
	}

	public void inputState(String state) {
		this.state.sendKeys(state);
	}

	public void inputPin(String pin) {
		Pin.sendKeys(pin);
	}

	public void inputPhoneNumber(String phoneNumber) {
		telephoneNumber.sendKeys(phoneNumber);
	}

	public void inputEmail(String email) {
		this.email.sendKeys(email);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

	public void clickReset() {
		btnReset.click();
	}

	public void inputDOB(String dd, String mm, String yy) {
		dateOfBirth.sendKeys(dd+"-"+mm+"-"+yy);
	}
}
