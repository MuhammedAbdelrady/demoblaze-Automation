package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import root.Home;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ChkItem extends Home {

    public static Boolean checkAddedItem(int numberOfAddedItems) throws InterruptedException {
        driver.findElement(By.linkText("Cart")).click();
        Boolean res = false;
        //Here we go to cart table
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By itemLocator = By.className("success");
        List<WebElement> cartItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemLocator));
        int actualItemSize = cartItems.size();
        if(numberOfAddedItems == actualItemSize){
            res = true;
            return res;
        }
        else{
            return res;
        }
    }
    public static Boolean chkTotal(int cost){
        Boolean res = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String strPrice = driver.findElement(By.xpath("//*[@id=\"totalp\"]")).getText();
        int actualTotal = Integer.parseInt(strPrice);
        System.out.println(actualTotal);
        if (actualTotal == cost){
            res = true;
            return res;
        }
        else {
            return res;
        }
    }
}
