package testScripts;

import java.net.MalformedURLException;

import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TablePracticeTest extends BaseTest {

    public TablePracticeTest(){
        super();
    }


    @BeforeClass(alwaysRun = true)
    public void setupTest() throws MalformedURLException {
        initialization();
    }

    @Test (description = "Verify total number of rows for Task table")
    public void verifyTotalNumberOfRowsForTaskTable() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToTasks();
        Assert.assertEquals(7, homePage.getNumberOfResults());
    }

    @Test (description = "Verify total number of results for in progress status filter")
    public void verifyTotalNumberOfRowsHavingStatusInProgress() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToTasks().setFilter("in progress");
        Assert.assertEquals(3, homePage.getNumberOfResults());
    }

    @Test (description = "Verify total number of results for completed status filter")
    public void verifyTotalNumberOfRowsHavingStatusCompleted() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToTasks().setFilter("completed");
        Assert.assertEquals(1, homePage.getNumberOfResults());
    }

    @Test (description = "Verify total number of results for deployed status filter")
    public void verifyTotalNumberOfRowsHavingStatusDeployed() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToTasks().setFilter("deployed");
        Assert.assertEquals(1, homePage.getNumberOfResults());
    }

    @Test (description = "Verify total number of results for failed qa status filter")
    public void verifyTotalNumberOfRowsHavingStatusFailedQA() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToTasks().setFilter("failed qa");
        Assert.assertEquals(2, homePage.getNumberOfResults());
    }

    /*@AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }*/
}