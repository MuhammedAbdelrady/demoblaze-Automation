package root;
import Signup.Register;
import SignIn.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class Home {
    //Define driver
    public static WebDriver driver ;


    @BeforeSuite
    public void setupAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("Testing session is started");
    }

    public static void goHome(){
        driver.get("https://www.demoblaze.com/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterSuite
    public void closeAll(){
        System.out.println("Testing session is end");
        //driver.quit();
    }
}
