package Signup;

import SignIn.Login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import SignIn.Login;
import root.*;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;

public class Register extends Home {
    @Test
    public static void signup() throws InterruptedException {
        //Show pop up for signup form
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
        //Fill form with valid data
        driver.findElement(By.id("sign-username")).sendKeys("hamashamas");
        driver.findElement(By.id("sign-password")).sendKeys("123123");
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
        //Alert Handler
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String ExpectedAlert = "Sign up successful.";
        String ActualAlert = alert.getText();
        alert.accept();
        //Check
        Boolean result = ActualAlert.contains(ExpectedAlert);
        Assert.assertTrue(result, "Register is fail");
    }
}

