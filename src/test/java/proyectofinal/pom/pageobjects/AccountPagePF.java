package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class AccountPagePF extends BasePF {

  private By gearsMenu = By.xpath("//span[contains(text(),'Gear')]");

  private By watchesMenu = By.xpath("//span[contains(text(),'Watches')]");

  public AccountPagePF(WebDriver driver) {
    super(driver);
  }

  public void openWatchesPage() {
    verifyTitleContains("My Account");
    verifyVisibilityOfElementLocated(gearsMenu);
    move(gearsMenu);
    move(watchesMenu);
    click(watchesMenu);
    takeScreenshot("Watches_Page");
  }
}
