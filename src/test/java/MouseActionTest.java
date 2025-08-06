import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseActionTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://unixpapa.com/js/testmouse.html");
        WebElement clickHereToTest = driver.findElement(By.linkText("click here to test"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickHereToTest).build().perform();

        WebElement textarea = driver.findElement(By.tagName("textarea"));
        String value = textarea.getAttribute("value");
        System.out.println(value);
    }
}
