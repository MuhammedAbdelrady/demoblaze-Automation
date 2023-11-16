package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import root.Home;

import java.time.Duration;


public class PlaceOrder extends Home {
    static PurcaseData data = new PurcaseData();
    public static void purchaseDataForm() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
        formDataEnter();
    }

    public static void formDataEnter() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys(data.name);
        driver.findElement(By.id("country")).sendKeys(data.Country);
        driver.findElement(By.id("city")).sendKeys(data.city);
        driver.findElement(By.id("card")).sendKeys(data.creditCard);
        driver.findElement(By.id("month")).sendKeys(data.month);
        driver.findElement(By.id("year")).sendKeys(data.year);
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
    }

}
