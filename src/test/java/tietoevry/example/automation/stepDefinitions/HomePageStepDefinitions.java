package tietoevry.example.automation.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import tietoevry.example.automation.pages.HomePage;

public class HomePageStepDefinitions {
    private final HomePage homePage;

    public HomePageStepDefinitions() {
        this.homePage = new HomePage();
    }

    @Given("navigate to home page")
    public void navigateToPage() {
        homePage.navigateToPage();
    }

    @And("open {string} page")
    public void goToSpecifiedPage(String pageName) {
        homePage.navigateToSpecifiedPage(pageName);
        System.out.printf("%s page is successfully opened\n", pageName);
    }
}
