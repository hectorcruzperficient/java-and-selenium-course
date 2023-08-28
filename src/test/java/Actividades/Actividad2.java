package Actividades;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Actividad2 {
    // Actividad
    // Crear un test donde se genere un record de una computadora nueva

    @Test
    public void newRecordTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://computer-database.gatling.io/computers");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));

        // Find add button
        driver.findElement(By.id("add")).click();

        // Wait for add page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        driver.findElement(By.id("name")).sendKeys("Precision 3561");
        driver.findElement(By.id("introduced")).sendKeys("2021-05-11");

        Select companyDropdown = new Select(driver.findElement(By.id("company")));
        companyDropdown.selectByVisibleText("Lenovo Group");

        driver.findElement(By.xpath("//body/section[@id='main']/form[1]/div[1]/input[1]")).click();
    }
}
