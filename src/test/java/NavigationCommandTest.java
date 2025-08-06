import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationCommandTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();

        String url = "https://www.ebay.com/";
        driver.get(url);

        System.out.println("1 - " +driver.getTitle());

        driver.findElement(By.xpath("//li/a[text()='Sports']")).click();
        Thread.sleep(2000);
        System.out.println("2 - " +driver.getTitle());

        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("3 - " +driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println("4 - " +driver.getTitle());

        driver.navigate().refresh();
        driver.quit();
    }
}
