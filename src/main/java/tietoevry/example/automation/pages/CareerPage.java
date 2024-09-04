package tietoevry.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CareerPage extends CommonBase {
    private static final By openPositionListLocator = By.xpath("//div[@class='jobBlock listing']//a[@class='tile_Sub']");

    public void logAllOpenPositions() {
        System.out.println("Log all open positions\n");

        List<WebElement> openPositionList = getElements(openPositionListLocator);

        for (WebElement position : openPositionList) {
            System.out.println(position.getText());
            System.out.println("\n-------------\n");
        }
    }

    public void logFilteredPositionTitles(String title) {
        System.out.printf("Filter positions by title %s\n", title);

        List<WebElement> openPositionList = getElements(openPositionListLocator);
        openPositionList.stream()
                .filter(p -> p.getText().toLowerCase().contains(title))
                .forEach(p -> {
                    System.out.println(p.getAttribute("title"));
                });
    }

    public List<String> getOpenPositionTitlesInSpecificLocation(String location) {
        return getElements(openPositionListLocator).stream()
                .filter(p -> p.getText().toLowerCase().contains(location))
                .map(e -> e.getAttribute("title"))
                .collect(Collectors.toList());
    }
}
