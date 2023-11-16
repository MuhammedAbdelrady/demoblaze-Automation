package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import root.Home;

import java.time.Duration;

public class ChkItem extends Home {

    public static void checkAddedItem  (String itemName) throws InterruptedException {
        //Here we go to cart table
        driver.findElement(By.linkText("Cart")).click();

        //Here we get the item name from this table
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By actualItemNameLocator = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");
        WebElement actualItemName = wait.until(ExpectedConditions.elementToBeClickable(actualItemNameLocator));
        String name = actualItemName.getText();

        //here we check the actual name against expected name
        Boolean result = name.contains(itemName);
        Assert.assertTrue(result,"Item matched");
        System.out.println("Cart is good");
        Cart.PlaceOrder.purchaseDataForm();

    }
}
