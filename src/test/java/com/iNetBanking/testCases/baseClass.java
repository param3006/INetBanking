package com.iNetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.iNetBanking.utilities.readConfig;

public class baseClass {

	readConfig read = new readConfig();

	public String baseURL = read.getApplicationURL();
	public String userName = read.getuserName();
	public String password = read.getPassword();
	public WebDriver driver;
	public Logger logger;

	@Parameters("browserName")
	@BeforeClass
	public void setUp(String browserName) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFireFoxDriverPath());
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", read.getEdgeDriverPath());
			driver = new EdgeDriver();
		} else {
			System.out.println("No Browser Specified");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}
	
	public void captureScreen(WebDriver driver,String tName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+tName+".png");
		FileUtils.copyFile(Source, target);
		logger.info("Sceenshot Taken");	
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
