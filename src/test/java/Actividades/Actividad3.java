package Actividades;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Actividad3 {

  // Navegar a https://magento.softwaretestingboard.com/
  // Buscar un articulo
  // Seleccionar un articulo de los resultados
  // Seleccionar talla y color
  // Agregar al carrito
  @Test
  public void addToCartTest() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://magento.softwaretestingboard.com");
    driver.manage().window().maximize();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

    driver.findElement(By.id("search")).sendKeys("jacket");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Jacket for men')]")));

    driver.findElement(By.xpath("//span[contains(text(),'Jacket for men')]")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]")));

    driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]")).click();
    driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")));
    driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")).click();
  }
}
