package by.epam.cdp.framework.runner;

import java.io.File;

import com.google.common.base.StandardSystemProperty;

import by.epam.cdp.framework.driver.BrowserType;

public class GlobalConfiguration {
	private static GlobalConfiguration configuration;
    private BrowserType browserType;
    private String downloadsDir;

    private GlobalConfiguration() {
        this.browserType = BrowserType.byName(TestProperties.getInstance().getBrowserType());
    }

    public static GlobalConfiguration getInstance() {
        if (configuration == null)
            configuration = new GlobalConfiguration();
        return configuration;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }


    public String getDownloadsDir() {
        return StandardSystemProperty.JAVA_IO_TMPDIR.value() + File.separatorChar
                + (downloadsDir == null ? "browserDownloads" : downloadsDir);
    }

    @Override
    public String toString() {
        return "GlobalConfiguration [driverType=" + browserType + "]";
    }

}
