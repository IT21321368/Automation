import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
//        Thread.sleep(2000);
        driver.get("https://www.ebay.com/");
//        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();

        System.out.println("current title = "+currentTitle);

        System.out.println("current url = "+currentUrl);

        driver.findElement(By.xpath("//input[@id='gh-ac']")).click();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Iphone");


        Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));
        selectCategory.selectByVisibleText("Cell Phones & Accessories");

        driver.findElement(By.cssSelector("#gh-search-btn")).click();

        driver.findElement(By.xpath("//span [text()='Apple iPhone 11']")).click();

        Thread.sleep(3000);
    }
}
