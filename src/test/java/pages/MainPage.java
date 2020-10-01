package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    String queryInputCSSSelector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://google.com");
    }

    public void typeQuery(String queryForSearch) {
        WebElement element = driver.findElement(By.cssSelector(queryInputCSSSelector));
        element.sendKeys(queryForSearch);
    }

    public void submitQuery() {
        WebElement element = driver.findElement(By.cssSelector(queryInputCSSSelector));
        element.submit();
    }
}
