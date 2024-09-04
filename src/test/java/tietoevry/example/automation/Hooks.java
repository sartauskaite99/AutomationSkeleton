package tietoevry.example.automation;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import tietoevry.example.automation.enums.DriverTypes;
import tietoevry.example.automation.utils.DriverManager;

public class Hooks {
    private static final DriverManager driverManager = DriverManager.getInstance();

    private Hooks() {
    }

    @BeforeAll
    public static void setup() {
        driverManager.initializeDriver(DriverTypes.CHROME);
    }

    @AfterAll
    public static void destroy() {
        driverManager.quitDriver();
    }
}
