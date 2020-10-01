package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserType) {
        String osName = System.getProperty("os.name");

        if (osName.equalsIgnoreCase("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/macOS/gecko/geckodriver");

            if (browserType.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macOS/chrome/chromedriver");
                driver = new ChromeDriver();
            }

        }

        if (osName.contains("windows")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/win64/geckodriver.exe");
        }

        if (browserType.equals("FF")) {
            driver = new FirefoxDriver();
        }
    }

    @AfterMethod
    public void finishTest() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    public void waitForElement(By elementToWait, WebDriver driver) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        new WebDriverWait(driver, 10).until(condition);
    }

}
