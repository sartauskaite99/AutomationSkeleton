package tietoevry.example.automation.pages;

import org.openqa.selenium.By;

public class HomePage extends CommonBase {

    private static final String pageUrl = "https://www.tietoevry.com/lt";

    private By getPage(String pageName) {
        return By.xpath("//a[contains(text(), '" + pageName + "')]");
    }

    public HomePage() {
    }

    public void navigateToPage() {
        driver.navigate().to(pageUrl);
    }

    public void navigateToSpecifiedPage(String pageName) {
        clickButton(getPage(pageName));
    }
}