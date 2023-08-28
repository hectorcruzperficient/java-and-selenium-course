package POM.PageObjects;

import POM.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    By txtSearchBox = By.id("searchbox");
    By btnFilterByName = By.id("searchsubmit");
    By tblActualResult = By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a");

    // Action Keywords
    public void filterByComputerName(String computer) {
        verifyTitleContains("Computers");
        verifyVisibilityOfElementLocated(txtSearchBox);
        type(computer, txtSearchBox);
        takeScreenshot("Enter_Search_Criteria");
        click(btnFilterByName);
        takeScreenshot("Results_After_Click");
    }

    public boolean verifyComputerTable(String expectedComputer) {
        String actualComputer = getText(tblActualResult);
        takeScreenshot("Final_Results");
        if (actualComputer.equals(expectedComputer)) {
            return true;
        } else {
            return false;
        }
    }

}
