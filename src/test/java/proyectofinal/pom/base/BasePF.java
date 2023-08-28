package proyectofinal.pom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class BasePF {

  private WebDriver driver;

  private WebDriverWait wait;

  public BasePF(WebDriver driver) {
    this.driver = driver;
  }

  public void launchBrowser(String url) {
    driver.get(url);
  }

  public void implicitWait() {
    implicitWait(20);
  }

  public void implicitWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
  }

  public void verifyVisibilityOfElementLocated(By element) {
    wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }

  public void verifyTitleContains(String title) {
    wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.titleContains(title));
  }

  public void type(String text, By element) {
    try {
      driver.findElement(element).sendKeys(text);
    } catch (NoSuchElementException e) {
      e.getMessage();
    }
  }

  public void click(By element) {
    try{
      driver.findElement(element).click();
    } catch (NoSuchElementException e) {
      e.getMessage();
    }
  }
  
  public void move(By element) {
    Actions action = new Actions(driver);

    WebElement webElement = driver.findElement(element);

    action.moveToElement(webElement).perform();
  }

  public void selectFromDropDown(By element, String value) {
    Select dropdown = new Select(driver.findElement(element));
    dropdown.selectByVisibleText(value);
  }

  public String getText(By element) {
    return driver.findElement(element).getText();
  }

  public void closeDriver() {
    driver.close();
  }

  public String getJsonValue(String file, String key) {
    InputStream inputStream = null;

    try {
      inputStream = new FileInputStream(GlobalPF.PATH_JSON_DATA + file + ".json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

    return (String) jsonObject.getJSONObject(file).get(key);
  }

  public String takeScreenshot(String filename) {
    String path = GlobalPF.PATH_SCREENSHOTS + filename + ".png";
    Screenshot screenshot = new AShot().takeScreenshot(driver);

    try {
      ImageIO.write(screenshot.getImage(), "PNG", new File(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return path;
  }
}
