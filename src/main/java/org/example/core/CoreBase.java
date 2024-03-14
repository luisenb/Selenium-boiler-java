package org.example.core;

import org.example.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CoreBase {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    protected ThreadLocal<Properties> properties = new ThreadLocal<>();

    protected int TIMEOUT_EXCEPTION = 15;

    public WebDriver getDriver(){
        return driver.get();
    }

    public WebDriverWait getWait(){
        return wait.get();
    }

    public Properties getProperties(){
        return properties.get();
    }


    @BeforeMethod
    protected void init(){
        properties.set(ConfigReader.getProperties());
        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("selenoid:options", options);

        String remoteUrl = getProperties().getProperty("selenoid.url");
        try{
            WebDriver webDriver = new RemoteWebDriver(
                    new URL(remoteUrl),
                    firefoxOptions
            );
            driver.set(webDriver);
            wait.set(new WebDriverWait(webDriver, TIMEOUT_EXCEPTION));
        }catch (MalformedURLException e){
            e.printStackTrace();
            throw new RuntimeException("Error initializing driver configuration: " + e.getMessage());
        }
        getDriver().get(getProperties().getProperty("app.url"));
        getWait().until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));

    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            try{
                driver.get().quit();
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Error when we try to tear down the driver: " + e.getMessage());
            }
        }
    }


}
