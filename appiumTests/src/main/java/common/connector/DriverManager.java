package common.connector;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static Logger LOG = Logger.getLogger(DriverManager.class.getName());
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static URL url;
    static AndroidDriver<WebElement> driver;

    static {
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private DriverManager() {
    }
    private static DesiredCapabilities getCapabilities() {
        LOG.info("Create new driver");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.gm");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.gm.ConversationListActivityGmail");
        return capabilities;
    }


    public static AndroidDriver<WebElement> getDriver() throws MalformedURLException {
        LOG.info("Getting the android driver instance...");
        if (driver == null) {
            setCapabilities();
        }
        return driver;
    }


    public static void setCapabilities() throws MalformedURLException {
        driver = new AndroidDriver(url, getCapabilities());
        LOG.info("The capabilities are set and driver is instanciated.");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    public static void closeDriver() throws MalformedURLException {
        getDriver().quit();
    }

}