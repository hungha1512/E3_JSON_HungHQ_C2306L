package com.hunghq.e3_json_hunghq_c2306l.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static Properties properties = new Properties();
    private static final String PROPERTIES_FILE = "app.properties";

    static {
        try (InputStream in = AppProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (in != null) {
                properties.load(in);
            } else {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try(FileOutputStream fos = new FileOutputStream(AppProperties.class.getClassLoader().getResource(PROPERTIES_FILE).getPath())) {
            properties.store(fos, null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
