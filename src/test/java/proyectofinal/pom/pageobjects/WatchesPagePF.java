package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class WatchesPagePF extends BasePF {

  private By firstWatch = By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]");

  private By addToCartBtn = By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]");

  private By cartBtn = By.xpath("//header/div[2]/div[1]/a[1]");

  private By checkoutBtn = By.id("top-cart-btn-checkout");

  public WatchesPagePF(WebDriver driver) {
    super(driver);
  }

  public void addWatchToCart() {
    verifyTitleContains("Watches - Gear");
    verifyVisibilityOfElementLocated(firstWatch);
    move(firstWatch);
    move(addToCartBtn);
    click(addToCartBtn);
    takeScreenshot("Add_Watch_To_Cart");
  }

  public void openCheckoutPage() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    verifyVisibilityOfElementLocated(cartBtn);
    click(cartBtn);
    takeScreenshot("Cart_Dialog");
    verifyVisibilityOfElementLocated(checkoutBtn);
    click(checkoutBtn);
    takeScreenshot("Open_Checkout_Page");
  }
}
