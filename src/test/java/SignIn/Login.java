package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import root.Home;


import java.time.Duration;

public class Login extends Home {
    @Test
    public static void Login(){
        //Show pop up of login form
        driver.findElement(By.linkText("Log in")).click();
        //Fill form with valid data
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("hamashamas");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("123123");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        String actualResult = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();
        String expectedResult = "Welcome";

        boolean result = actualResult.contains(expectedResult);

        Assert.assertTrue(result,"Login is fail");
    }
}
