package POM.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Base {

    private WebDriver driver;
    private WebDriverWait wait;

    /*
    Constructor
     */
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    /*
    Chrome Driver
     */
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    /*
    Launch browser
     */
    public void launchBrowser(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    /*
    Implicit wait
     */
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /*
     Explicit Wait
     */
    public void verifyVisibilityOfElementLocated(By element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void verifyTitleContains(String title) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(title));
    }

    /*
    Common Actions (Keywords)
     */

    // Type
    public void type(String text, By element) {
        try{
            driver.findElement(element).sendKeys(text);
        }
        catch (NoSuchElementException e) {
            e.getMessage();
        }
    }

    // Click
    public void click(By element) {
        try{
            driver.findElement(element).click();
        }
        catch (NoSuchElementException e) {
            e.getMessage();
        }
    }

    // GetText
    public String getText(By element) {
        return driver.findElement(element).getText();
    }


    /*
    Close driver
     */
    public void closeDriver(){
        driver.close();
    }


    /*
    Read Json File Java
     */
    public String getJSONValue(String jsonFileObj, String jsonKey){
        try {

            // JSON Data
            InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

            // Get Data
            String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
            return jsonValue;

        } catch (FileNotFoundException e) {
            //Assert.fail("JSON file is not found");
            return null;
        }
    }

    /*
    Take Screenshot
     */
    public String takeScreenshot(String fileName) {
        try{
            String pathFileName = GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
            return pathFileName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
