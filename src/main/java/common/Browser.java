package common;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public enum Browser {

    INSTANCE;
    private WebDriver driver;
    private final String DEFAULT_BROWSER = "Chrome";
    private final String browserName;

    public final static int DEFAULT_TIMEOUT = 20;

    Browser() {
        String name = Application.getProperty("browser");

        if (name == null || name.isEmpty()) {
            name = DEFAULT_BROWSER;
        }

        this.browserName = name;

        try {
            driver = DriverFactory.getSpecificDriver(browserName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return INSTANCE.driver;
    }

    public static String getName() {
        return INSTANCE.browserName;
    }

    public static void setDriver(WebDriver driverNew) {
        INSTANCE.driver = driverNew;
        INSTANCE.driver.manage().window().maximize();
        INSTANCE.driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        INSTANCE.driver.manage().deleteAllCookies();
    }
}