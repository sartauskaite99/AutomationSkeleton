package tietoevry.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tietoevry.example.automation.utils.DriverManager;

import java.util.List;

public class CommonBase {
    protected final WebDriverWait driverWait;
    protected final WebDriver driver;

    public CommonBase() {
        DriverManager driverManager = DriverManager.getInstance();
        this.driverWait = driverManager.getDriverWait();
        this.driver = driverManager.getDriver();
    }

    public void clickButton(By byLocator) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
        driver.findElement(byLocator).click();
    }

    public List<WebElement> getElements(By byLocator) {
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
        return driver.findElements(byLocator);
    }
}
