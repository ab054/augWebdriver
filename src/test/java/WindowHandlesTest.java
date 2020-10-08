import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.Set;

public class WindowHandlesTest extends BaseTest {


    //1. Open multiple windows page
    //2. Click on the link
    //3. Verify amount of windows
    //4. Verify text and title of the new window
    @Test
    public void test001() {
        int expectedNumberOfWindows = 2;

        openWindowsPage();
        clickOnLink();
        int actualNumberOfWindows = getAmountOfWindows();
        Assert.assertEquals(actualNumberOfWindows, expectedNumberOfWindows);
        switchToNewWindow();
        verifyTitle();
    }

    //1. Open multiple windows page
    //2. Click on the link
    //3. Verify amount of windows
    //4. Verify text and title of the new window
    @Test
    public void test002() throws InterruptedException {
        int expectedNumberOfWindows = 2;
        String expectedWindowTitle = "New Window";
        String expectedPageText = "New Window";

        openWindowsPage();
        clickOnLink();
        waitUntilNumberOfWindows(2);
        int actualNumberOfWindows = getAmountOfWindows();
        Assert.assertEquals(actualNumberOfWindows, expectedNumberOfWindows, AssertErrorMessages.AMOUNT_OF_WINDOWS);
        boolean windowFound = switchToWindowWithTitle(expectedWindowTitle);
        Assert.assertTrue(windowFound, AssertErrorMessages.NO_WINDOW_FOUND + expectedWindowTitle);

        verifyTitle(); //TODO: move assertions out of test steps
        verifyPageSource(expectedPageText);
    }

    private void waitUntilNumberOfWindows(int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(driver -> driver.getWindowHandles().size() == numberOfWindows);
    }

    private void verifyPageSource(String textToBeOnPage) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(textToBeOnPage));
    }

    private boolean switchToWindowWithTitle(String windowTitleValue) {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String eachHandle : windowHandles) {
            driver.switchTo().window(eachHandle);
            if (driver.getTitle().equalsIgnoreCase(windowTitleValue)) {
                return true;
            }
        }
        return false;
    }

    private void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        String[] arrayOfStrings = windowHandles.toArray(new String[]{});
        String secondHandle = arrayOfStrings[1];
        driver.switchTo().window(secondHandle);
    }

    private void verifyTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "New Window";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    private void clickOnLink() {
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
    }

    private int getAmountOfWindows() {
        return driver.getWindowHandles().size();
    }

    private void openWindowsPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }
}
