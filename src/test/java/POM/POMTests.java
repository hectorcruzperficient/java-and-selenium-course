package POM;

import POM.Base.GlobalVariables;
import POM.PageObjects.HomePage;
import POM.Base.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMTests {

    // Variables
    WebDriver driver;
    Base base;
    HomePage homePage;
    String expectedComputer;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeTest
    public void Setup(){
        base = new Base(driver);
        driver = base.chromeDriver();
        homePage = new HomePage(driver);
        expectedComputer = base.getJSONValue("testCase01", "computer");
        extent = new ExtentReports(GlobalVariables.PATH_REPORTS);
    }

    @Test
    public void TestCase01() {

        logger = extent.startTest(new Object() {}.getClass().getEnclosingMethod().getName());

        // Step 1
        base.launchBrowser(GlobalVariables.URL);
        logger.log(LogStatus.INFO, "Open Browser with URL: " + GlobalVariables.URL);

        // Step 2
        homePage.filterByComputerName(expectedComputer);
        logger.log(LogStatus.INFO, "Filter computer name with value: " + expectedComputer);

        // Step 3
        Assert.assertTrue(homePage.verifyComputerTable("ACE"));
        logger.log(LogStatus.PASS, "Valdation is successful for test: " + new Object() {}.getClass().getEnclosingMethod().getName());
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("Failed_Step")));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case was skipped.");
        }
        extent.endTest(logger);
    }

    @AfterTest
    public void cleanUp(){
        extent.flush();
        extent.close();
        base.closeDriver();
    }

}
