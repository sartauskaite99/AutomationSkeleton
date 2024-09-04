package tietoevry.example.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tietoevry.example.automation.enums.DriverTypes;

import java.time.Duration;

public class DriverManager {
    private static final int TIMEOUT_TIME = 10;
    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait driverWait;

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void initializeDriver(DriverTypes driverType) {
        switch (driverType) {
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions().addArguments("--disable-search-engine-choice-screen");
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            }
//                    driver = WebDriverManager.chromedriver().create();
            case FIREFOX -> driver = WebDriverManager.firefoxdriver().create();
            case EDGE -> driver = WebDriverManager.edgedriver().create();
            default -> throw new IllegalArgumentException("Invalid driver type: " + driverType);
        }
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_TIME));
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    public WebDriverWait getDriverWait() {
        if (driverWait == null) {
            throw new IllegalStateException("DriverWait is not initialized. Call initializeDriver() first.");
        }
        return driverWait;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
