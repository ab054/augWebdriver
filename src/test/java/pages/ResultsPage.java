package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class ResultsPage extends BaseTest {
    private final WebDriver driver;

    By resultsStats = By.id("result-stats");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForStats() {
        waitForElement(resultsStats, driver);
    }

    public boolean isStatsVisible() {
        WebElement element = driver.findElement(resultsStats);
        return element.isDisplayed();
    }
}
