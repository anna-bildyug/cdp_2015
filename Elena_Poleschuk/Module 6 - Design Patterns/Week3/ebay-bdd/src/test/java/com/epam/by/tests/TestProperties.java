package com.epam.by.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	private static final String PROPERTY_FILE_NAME = "test_properties.properties";

	private static ThreadLocal<TestProperties> instance = new ThreadLocal<TestProperties>();

	public static synchronized TestProperties getInstance() {
		if (null == instance.get())
			instance.set(new TestProperties());
		return instance.get();
	}

	private TestProperties() {
		setProperties();
	}

	private String urlMain, urlLogin;

	public void setProperties() {
		InputStream inputStream = null;
		try {

			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
			if (inputStream == null)
				throw new FileNotFoundException(
						"property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");

			prop.load(inputStream);
			urlMain = prop.getProperty("test.variable.url.main");
			urlLogin = prop.getProperty("test.variable.url.login");

		} catch (Exception ex) {
			System.out.println("Exception while initializing test properties. Exception: " + ex);
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getURLMain() {
		return this.urlMain;
	}

	public String getURLLogin() {
		return this.urlLogin;
	}
}