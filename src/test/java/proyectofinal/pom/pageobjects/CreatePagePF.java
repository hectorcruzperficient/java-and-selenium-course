package proyectofinal.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyectofinal.pom.base.BasePF;

public class CreatePagePF extends BasePF {

  private By firstNameTxt = By.id("firstname");

  private By lastNameTxt = By.id("lastname");

  private By emailTxt = By.id("email_address");

  private By passwordTxt = By.id("password");

  private By passwordConfirmationTxt = By.id("password-confirmation");

  private By btnCreateAccount = By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]");

  public CreatePagePF(WebDriver driver) {
    super(driver);
  }

  public void createAccount(String firstname, String lastname, String email, String password, String passwordConfirmation) {
    verifyTitleContains("Create New Customer Account");
    verifyVisibilityOfElementLocated(firstNameTxt);
    type(firstname, firstNameTxt);
    type(lastname, lastNameTxt);
    type(email, emailTxt);
    type(password, passwordTxt);
    type(passwordConfirmation, passwordConfirmationTxt);
    takeScreenshot("Enter_Account_Information");
    click(btnCreateAccount);
    takeScreenshot("Results_After_Create_Account");
  }
}
