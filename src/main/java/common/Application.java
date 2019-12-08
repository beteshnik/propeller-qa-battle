package common;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application {
    private static final String DEFAULT_ENV = "test";
    final static Logger logger = Logger.getLogger(Application.class);

    public static String getEnv() {
        String env = System.getProperty("env");
        if (env == null)
            return DEFAULT_ENV;
        return env;
    }

    public static String getProperty(String key) {
        FileInputStream propFile =
                null;
        try {
            propFile = new FileInputStream( "src/main/resources/" + getEnv() + ".properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties p =
                new Properties(System.getProperties());
        try {
            p.load(propFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperties(p);

        return System.getProperty(key);
    }

    public static void log(String message) {
        logger.info(message);
    }

}
