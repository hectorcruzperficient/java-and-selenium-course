package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class PaymentPagePF extends BasePF {

  private By placeOrderBtn = By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]");

  private By sucessTxt = By.xpath("//span[contains(text(),'Thank you for your purchase!')]");

  public PaymentPagePF(WebDriver driver) {
    super(driver);
  }

  public void placeOrder() {
    verifyTitleContains("Checkout");
    verifyVisibilityOfElementLocated(placeOrderBtn);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    click(placeOrderBtn);
    takeScreenshot("Placed_Order");
  }

  public boolean verifySuccessText(String expectedMessage) {
    verifyVisibilityOfElementLocated(sucessTxt);

    String actualMessage = getText(sucessTxt);

    takeScreenshot("Final_Result");

    return actualMessage.equals(expectedMessage);
  }
}
