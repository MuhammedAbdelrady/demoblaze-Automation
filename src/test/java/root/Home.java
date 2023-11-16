package root;
import Signup.Register;
import SignIn.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;


public class Home {
    //Define driver
    public static WebDriver driver ;


    @BeforeSuite
    public void setupAll(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("Testing session is started");
    }
    public static void closeWindow(){
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")).click();
    }

    public static void goHome(){
        driver.get("https://www.demoblaze.com/index.html");
    }


    @AfterSuite
    public void closeAll(){
        System.out.println("Testing session is end");
        //driver.quit();
    }
}
