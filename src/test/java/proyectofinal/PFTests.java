package proyectofinal;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import proyectofinal.pom.base.GlobalPF;
import proyectofinal.pom.pageobjects.AccountPagePF;
import proyectofinal.pom.pageobjects.CheckoutPagePF;
import proyectofinal.pom.pageobjects.CreatePagePF;
import proyectofinal.pom.pageobjects.HomePagePF;
import proyectofinal.pom.pageobjects.PaymentPagePF;
import proyectofinal.pom.pageobjects.WatchesPagePF;

public class PFTests {

  private WebDriver driver;

  private HomePagePF homePage;

  private CreatePagePF createPage;

  private AccountPagePF accountPage;

  private WatchesPagePF watchesPage;

  private CheckoutPagePF checkoutPage;

  private PaymentPagePF paymentPage;

  private String expectedMessage;

  private ExtentReports extent;

  private ExtentTest logger;

  @BeforeTest
  public void beforeAllTest() {
    setupChromeDriver();
  }

  @BeforeMethod
  public void setup() {
    homePage = new HomePagePF(driver);
    createPage = new CreatePagePF(driver);
    accountPage = new AccountPagePF(driver);
    watchesPage = new WatchesPagePF(driver);
    checkoutPage = new CheckoutPagePF(driver);
    paymentPage = new PaymentPagePF(driver);
    expectedMessage = homePage.getJsonValue("testCasePF", "message");
    extent = new ExtentReports(GlobalPF.PATH_REPORTS);
  }

  @Test
  public void testCase() {
    logger = extent.startTest(new Object() {}.getClass().getEnclosingMethod().getName());
    
    homePage.launchBrowser(GlobalPF.URL);
    logger.log(LogStatus.INFO, "Open Browser with URL: " + GlobalPF.URL);

    homePage.openCreatePage();
    logger.log(LogStatus.INFO, "Open Create Account Page");

    String firstname = "Hector";
    String lastname = "Cruz";
    String email = "a" + (int) Math.floor(Math.random() * 9999) + "@a.com";

    createPage.createAccount(firstname, lastname, email, "P@ssw0rd", "P@ssw0rd");
    logger.log(LogStatus.INFO, "Create Account");

    accountPage.openWatchesPage();
    logger.log(LogStatus.INFO, "Open Account Page");

    watchesPage.addWatchToCart();
    logger.log(LogStatus.INFO, "Add Watch to Cart");

    watchesPage.openCheckoutPage();
    logger.log(LogStatus.INFO, "Open Checkout Page");

    checkoutPage.fillShipping(email, firstname, lastname, "Vermont Avenue", "Menifee", "California",
        "91911", "United States", "666-6666-66");
    logger.log(LogStatus.INFO, "Fill Shipping Information");

    paymentPage.placeOrder();
    logger.log(LogStatus.INFO, "Place Order");

    Assert.assertTrue(paymentPage.verifySuccessText(expectedMessage));
    logger.log(LogStatus.PASS, "Validation is successful for test: " + new Object() {}.getClass().getEnclosingMethod().getName());
  }

  @AfterMethod
  public void getResult(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      logger.log(LogStatus.FAIL, logger.addScreenCapture(homePage.takeScreenshot("Failed_Step")));
    } else if (result.getStatus() == ITestResult.SKIP) {
      logger.log(LogStatus.SKIP, "Test Case was skipped.");
    }

    extent.endTest(logger);
  }

  @AfterTest
  public void cleanUp() {
    extent.flush();
    extent.close();
    homePage.closeDriver();
  }

  public void setupChromeDriver() {
//    WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    driver = new ChromeDriver();
    options();
  }

  public void options() {
    driver.manage().window().maximize();
  }
}
