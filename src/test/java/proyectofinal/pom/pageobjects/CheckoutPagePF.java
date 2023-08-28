package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class CheckoutPagePF extends BasePF {

  private By firstnameTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");

  private By lastnameTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[2]/div[1]/input[1]");

  private By addressTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]");

  private By cityTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[4]/div[1]/input[1]");

  private By stateDropDown = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[5]/div[1]/select[1]");

  private By zipTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[7]/div[1]/input[1]");

  private By countryDropDown = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[8]/div[1]/select[1]");

  private By phoneNumberTxt = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[9]/div[1]/input[1]");

  private By shippingRadioBtn = By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]");

  private By nextBtn = By.xpath("//span[contains(text(),'Next')]");

  public CheckoutPagePF(WebDriver driver) {
    super(driver);
  }

  public void fillShipping(String email, String firstname, String lastname, String address, 
      String city, String state, String zip, String country, String phoneNumber) {
    verifyTitleContains("Checkout");
    verifyVisibilityOfElementLocated(firstnameTxt);
    type(firstname, firstnameTxt);
    type(lastname, lastnameTxt);
    type(address, addressTxt);
    type(city, cityTxt);
    selectFromDropDown(stateDropDown, state);
    type(zip, zipTxt);
    selectFromDropDown(countryDropDown, country);
    type(phoneNumber, phoneNumberTxt);
    takeScreenshot("Fill_Shipping");
    click(shippingRadioBtn);
    click(nextBtn);
    takeScreenshot("Payment_Page");
  }
}
