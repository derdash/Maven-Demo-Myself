package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Search {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

     //   WebDriverManager.firefoxdriver().setup();
    //   driver = new FirefoxDriver();

       WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void googleSearch(){

        driver.findElement(By.name("q")).sendKeys("Chicken" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Chicken"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }






}
