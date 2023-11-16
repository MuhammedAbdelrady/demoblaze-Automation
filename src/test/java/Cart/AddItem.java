package Cart;
import SignIn.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import root.Home;

import java.time.Duration;

public class AddItem extends Home {
    @Test
    public void items() throws InterruptedException {
        //Here we click on item from main page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By productLocator = By.xpath("//a[contains(text(),'Samsung galaxy s6')]");
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        product.click();
        //Here we click on add to cart button from product page
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By addToCartLocator = By.cssSelector("a[onclick='addToCart(1)']");
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCart.click();
        //Here we check whether prodct added or not
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String actualResult = alert.getText();
        String expectedResult = "Product added";

        Boolean result = actualResult.contains(expectedResult);
        alert.accept();
        Assert.assertTrue(result, "Product added");
        Cart.ChkItem.checkAddedItem("Samsung galaxy s6");

    }


}
