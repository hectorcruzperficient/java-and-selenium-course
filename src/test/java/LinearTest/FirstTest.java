package LinearTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    // Linear Scripting
    // Locators:
    /*
     - Id
     - Name
     - Link Text
     - Partial Link Text
     - Class name
     - Tag name
     - CSS Path
     - Xpath (Absoluto y Relativo)
    */

    /* Assertions
        Hard assertion: Validates the expected and actual results on the spot
        Soft assertion: Validates all assertions, will fail after validating all assertions
     */

    /* Pausas y sincronizacion
        Implicit wait: Una sincronizacion del script con el DOM (Document Object Model)
        Explicit wait: Una sincronizacion del script con un elemento en particular
     */


    /* Xpath Axis
    AxisName	        Result
    ancestor	        Selects all ancestors (parent, grandparent, etc.) of the current node
    ancestor-or-self	Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
    attribute	        Selects all attributes of the current node
    child	            Selects all children of the current node
    descendant	        Selects all descendants (children, grandchildren, etc.) of the current node
    descendant-or-self	Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
    following	        Selects everything in the document after the closing tag of the current node
    following-sibling	Selects all siblings after the current node
    namespace	        Selects all namespace nodes of the current node
    parent	            Selects the parent of the current node
    preceding	        Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes and namespace nodes
    preceding-sibling	Selects all siblings before the current node
    self	            Selects the current node
     */
    @Test
    public void firsTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);

//        driver.get("https://computer-database.gatling.io/computers");
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        // Forced wait
//        Thread.sleep(20000);

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement menMenu = driver.findElement(By.xpath("//span[text()='Men']"));
        WebElement topsMenu = driver.findElement(By.xpath("(//span[text()='Tops'])[2]"));
        WebElement jacketsMenu = driver.findElement(By.xpath("(//span[text()='Jackets'])[2]"));

        action.moveToElement(menMenu).perform();
        action.moveToElement(topsMenu).perform();
        jacketsMenu.click();

        // Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox")));
//
//        driver.findElement(By.id("searchbox")).sendKeys("ARRA");
//
//        driver.findElement(By.id("searchsubmit")).click();
//
//        String actualComputerName = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a")).getText();
//        Assert.assertEquals(actualComputerName,"ARA");

//        driver.close();

        // Actividad
        // Navegar a https://magento.softwaretestingboard.com/
        // Buscar un articulo
        // Seleccionar un articulo de los resultados
        // Seleccionar talla y color
        // Agregar al carrito


        // Actividad
        // Crear un test donde se genere un record de una computadora nueva
        // Select company = new Select(driver.findElement(By.());
        // company.selectBy();
    }
}
