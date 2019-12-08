package localDrivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class LocalFirefoxDriver implements LocalDriver {


    @Override
    public void setupEnv() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    }

    @Override
    public WebDriver getDriver() {
        FirefoxOptions options = new FirefoxOptions();
        DesiredCapabilities capa = DesiredCapabilities.firefox();
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        options.addArguments("-private");
        options.addPreference("plugin.disable_full_page_plugin_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
        options.addPreference("extensions.allowPrivateBrowsingByDefault",true);
        capa.setJavascriptEnabled(true);
        capa.setPlatform(Platform.WINDOWS);
        capa.setCapability("takesScreenshot", true);
        capa.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

        return new FirefoxDriver(capa);

    }
}