package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class HomePagePF extends BasePF {

  private By btnCreateAccount = By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]");

  public HomePagePF(WebDriver driver) {
    super(driver);
  }

  public void openCreatePage() {
    verifyVisibilityOfElementLocated(btnCreateAccount);
    click(btnCreateAccount);
    takeScreenshot("Create_Account_Page");
  }
}
