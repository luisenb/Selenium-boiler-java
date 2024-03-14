package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static String apiConfigPath = rootPath + "api.properties";

    public static Properties getProperties(){
        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(apiConfigPath)){
            properties.load(fis);
        }catch (IOException ioException){
            ioException.printStackTrace();
            throw new RuntimeException("Error loading configuration properties: " + ioException.getMessage());
        }
        return properties;
    }
}
