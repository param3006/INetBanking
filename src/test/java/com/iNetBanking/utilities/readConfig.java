package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	Properties properties;

	    public readConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = properties.getProperty("baseURL");
		return url;
	}

	public String getuserName() {
		String userName = properties.getProperty("username");
		return userName;
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

	public String getChromeDriverPath() {
		String chromePath = properties.getProperty("chromepath");
		return chromePath;
	}

	public String getEdgeDriverPath() {
		String edgePath = properties.getProperty("edgepath");
		return edgePath;
	}

	public String getFireFoxDriverPath() {
		String fireFoxPath = properties.getProperty("firefoxpath");
		return fireFoxPath;
	}
}
