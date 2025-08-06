import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
//        implicitlyWait();
//        explicitlyWait();
        fluentWait();
    }

    public static void implicitlyWait() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/elements");

        driver.findElement(By.xpath("//span[text()='Text Box']")).click();

    }

    public static void explicitlyWait() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement enableAfter = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableAfter.click();
        Thread.sleep(2000);

    }

    public static void fluentWait() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement visibleAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        System.out.println(visibleAfter.getText());
    }
}
