import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
//        alertWithOk();
//        alertWithOkAndCancel();
        alertWithTextBox();
    }


    public static void alertWithOk() throws InterruptedException {
            WebDriver driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.get("https://demo.automationtesting.in/Alerts.html");

            driver.findElement(By.xpath("//li[@class='active']/a[contains(text(),'Alert with OK ')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("[class='btn btn-danger']")).click();
            Thread.sleep(2000);

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            driver.quit();


    }

    public static void alertWithOkAndCancel() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(2000);

        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        System.out.println(driver.findElement(By.id("demo")).getText());
        driver.quit();
    }

    public static void alertWithTextBox() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[class='btn btn-info']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("My First Automation");
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();

        System.out.println(driver.findElement(By.id("demo1")).getText());
        driver.quit();
    }
}
