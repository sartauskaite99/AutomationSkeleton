package tietoevry.example.automation.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tietoevry.example.automation.pages.CareerPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CareerPageStepDefinitions {

    private final CareerPage careerPage;

    public CareerPageStepDefinitions() {
        careerPage = new CareerPage();
    }

    @Then("list all open positions")
    public void openPositionsAreListed() {
        careerPage.logAllOpenPositions();
    }

    @And("list open positions with text {string}")
    public void listOpenPositionsWithText(String positionType) {
        careerPage.logFilteredPositionTitles(positionType);
    }

    @And("verify open position list is correct in {string}")
    public void verifyOpenPositionListIsCorrect(String location, DataTable dataTable) {
        List<String> expectedList = dataTable.asList();
        List<String> openPositionTitleList = careerPage.getOpenPositionTitlesInSpecificLocation(location);
        assertTrue(expectedList.containsAll(openPositionTitleList), "List assertion failed");
    }
}
