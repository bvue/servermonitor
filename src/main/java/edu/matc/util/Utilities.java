package edu.matc.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by bvue0 on 12/5/2016.
 */
public class Utilities {

    private static final Logger log = Logger.getLogger(Utilities.class);

    /**
     * This method will load the values from the properties files
     *
     * @param propertiesPath the path for the properties file
     * @return the properties values
     */
    public static Properties loadProperties(String propertiesPath) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(propertiesPath)) {
            log.info("Loading properties...");
            properties.load(resourceStream);
        } catch (IOException exception) {
            log.error(exception.getStackTrace());
        }

        return properties;
    }

}
