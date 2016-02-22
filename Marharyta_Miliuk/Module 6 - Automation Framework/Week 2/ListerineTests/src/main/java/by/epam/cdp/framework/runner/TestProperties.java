package by.epam.cdp.framework.runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

	public static final String PROPERTY_FILE_NAME = "listerine_test.properties";

    private static ThreadLocal<TestProperties> instance = new ThreadLocal<TestProperties>();

    private TestProperties() {
        setPropValues();
    }

    public static synchronized TestProperties getInstance() {
        if (null == instance.get())
            instance.set(new TestProperties());
        return instance.get();
    }

    private String baseUrl;

    private String browserType;

    private Integer defaultTimeout;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getBrowserType() {
        return this.browserType;
    }

    public Integer getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public void setPropValues() {
        InputStream inputStream = null;
        try {
           
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            if (inputStream == null)
                throw new FileNotFoundException("property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");

            prop.load(inputStream);

            baseUrl = prop.getProperty("environment.url");
            browserType = prop.getProperty("environment.driver");
            defaultTimeout = Integer.parseInt(prop.getProperty("test.variables.timeout"));
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
