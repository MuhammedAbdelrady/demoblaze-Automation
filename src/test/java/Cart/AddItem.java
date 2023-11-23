package Cart;
import SignIn.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import root.Home;

import java.time.Duration;

public class AddItem extends Home {
    //Variable
    WebDriverWait wait;
    public static int totalCost = 0;

    @Test(priority = 1)
    public void buyItems(){
        //Buying Methods Call
        buyMobile();
        goHome();
        buyLaptop();
        goHome();
        buyMonitor();
    }
    @Test(priority = 2)
    public void items() throws InterruptedException {
        Boolean res = Cart.ChkItem.checkAddedItem(3);
        Assert.assertTrue(res, "Matched list");
    }
    @Test(priority = 3)
    public void checkPrice() throws InterruptedException {
        Boolean res2 = Cart.ChkItem.chkTotal(totalCost);
        Assert.assertTrue(res2, "Total cost is incorrect");

        Cart.PlaceOrder.purchaseDataForm();

    }


    //Helper methods
    public Boolean alertCheck(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualRes = alert.getText();
        String expectedRes = "Product added";
        Boolean res = actualRes.contains(expectedRes);
        alert.accept();
        return res;
    }
    public void buyMobile(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By productLocator = By.xpath("//a[contains(text(),'Samsung galaxy s6')]");
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productLocator));

        By priceLocator = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h5");
        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        String price = productPrice.getText();
        String newPrice = price.replace("$","");
        int mobilePrice = Integer.parseInt(newPrice);
        totalCost += mobilePrice;

        product.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By addToCartLocator = By.cssSelector("a[onclick='addToCart(1)']");
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCart.click();

        boolean resMob = alertCheck();
        Assert.assertTrue(resMob, "Product added");
    }
    public void buyLaptop(){
        By sectionLocator = By.linkText("Laptops");
        WebElement section = wait.until(ExpectedConditions.elementToBeClickable(sectionLocator));
        section.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By productLocator = By.xpath("//a[contains(text(),'MacBook air')]");
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        By priceLocator = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h5");
        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        String price = productPrice.getText();
        String newPrice = price.replace("$","");
        int laptopPrice = Integer.parseInt(newPrice);
        totalCost += laptopPrice;

        product.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By addToCartLocator = By.linkText("Add to cart");
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));

        addToCart.click();

        boolean resLaptop = alertCheck();
        Assert.assertTrue(resLaptop, "Product added");
    }
    public void buyMonitor() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By sectionLocator = By.linkText("Monitors");
        WebElement section = wait.until(ExpectedConditions.elementToBeClickable(sectionLocator));
        section.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By productLocator = By.xpath("//a[contains(text(),'Apple monitor 24')]");
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productLocator));

        By priceLocator = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h5");
        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        String price = productPrice.getText();
        String newPrice = price.replace("$","");
        int monitorsPrice = Integer.parseInt(newPrice);
        totalCost += monitorsPrice;
        product.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By addToCartLocator = By.linkText("Add to cart");
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCart.click();

        boolean resMonitor = alertCheck();
        Assert.assertTrue(resMonitor, "Product added");
    }

}
