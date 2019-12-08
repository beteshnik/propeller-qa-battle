package localDrivers;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface LocalDriver {
    public abstract void setupEnv();
    public abstract WebDriver getDriver() throws IOException;
}
