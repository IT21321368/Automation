package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestNGAutomation {
    WebDriver driver;

    @BeforeSuite
    public void init(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
    }
    @Test
    public void googleSearch(){
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("[class='gLFyf']")).click();
        driver.findElement(By.cssSelector("[class='gLFyf']")).clear();
        driver.findElement(By.cssSelector("[class='gLFyf']")).sendKeys("selenium");
        driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]")).click();

    }
    @AfterSuite
    public void quit(){
        driver.quit();
    }
}
