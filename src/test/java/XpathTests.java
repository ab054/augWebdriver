import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTests {

    WebDriver driver;

    @BeforeSuite
    private void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/win64/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test0001() {
        String xpath01 = "/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input";
        String xpath02 = "//form/div[2]/div[1]/div[1]/div/div[2]/input";

        String xpath03 = "//<input>[@name='q']";
        String xpath04 = "//*[@name='q']";
        String xpath05 = "//*[@name='q'][@title='search']";

        String xpath06 = "//*[@name='q' and @title='Search']";

        String xpath07 = "/*[@title='search' and @title='Search']";
        String xpath08 = "/*[@title='search' or @title='Search']";

        //TODO: try to find the element with contains()
        String xpath09 = "//<input>[contains(@class,'inputClass')]";

        String xpath10 = "//<input>[starts-with(@class,'inputClass')]";

        String xpath11 = "//*[text()='Log In']";

        String xpath12 = "//*[text()=' Login']";

        String xpath13 = "(//a)[1]";
        String xpath14 = "(//a)[last()]";
        String xpath15 = "(//a)[position()=1]";
        driver.findElement(By.xpath(xpath06));
    }
}
