package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ResultsPage;

public class GoogleSearchTest extends BaseTest {

    //1. Go to main page
    //2. Type the search query
    //3. Submit the query
    //4. Verify that results page is displayed
    @Test
    public void test0001() {
        String queryForSearch = "Portnov Computer School";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.typeQuery(queryForSearch);
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();

        Assert.assertTrue(statsVisible);
    }

    @Test
    public void test0002() {
        String queryForSearch = "Portnov Computer";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.typeQuery(queryForSearch);
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();

        Assert.assertTrue(statsVisible);
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Portnov Computer"},
                {"Portnov Computer School"},
        };
    }


    @Test(dataProvider = "test1")
    public void test_SearchWithParameter(String dataProviderValue) {
        String queryForSearch = dataProviderValue;

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.typeQuery(queryForSearch);
        mainPage.submitQuery();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.waitForStats();
        boolean statsVisible = resultsPage.isStatsVisible();

        Assert.assertTrue(statsVisible);
    }
}
