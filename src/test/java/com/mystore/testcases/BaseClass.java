package com.mystore.testcases;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getBaseUrl();
//    String browser = readConfig.getBrowser();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){
        switch(browser.toLowerCase())
        {
            case "chrome":
//                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
//            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

            case "msedge":
//            WebDriverManager.firefoxdriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                driver = null;
                break;
        }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger("BaseClass");
        logger.info("BAseclass messahes");
        driver.get(url);
    }
    @AfterClass
    public void teardown(){
        driver.close();
        driver.quit();
    }

    public static void captureScreenshot(WebDriver driver, String testcasename) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File screenshot1 = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"//screenshots//"+testcasename+".png");
        FileUtils.copyFile(screenshot1,des);
    }


}
