package common;

import localDrivers.LocalDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {
    public static WebDriver getSpecificDriver(String driverName) throws IOException {
        Class cls;
        LocalDriver clsInstance;
        WebDriver webDriver = null;

        try {
            System.out.println("localDrivers." + "Local" + driverName + "Driver");
            cls = Class.forName("localDrivers." + "Local" + driverName + "Driver");

            clsInstance = (LocalDriver) cls.newInstance();
            clsInstance.setupEnv();
            webDriver = clsInstance.getDriver();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DriverFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return webDriver;
    }
}

