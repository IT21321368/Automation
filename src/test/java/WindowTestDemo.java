import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowTestDemo {
    public static void main(String[] args) throws InterruptedException {
//        newTabedWindowTest();
        newSeperateWindowTest();
    }


    public static void newTabedWindowTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
//        Set<Cookie> cookies = driver.manage().getCookies();
//        Cookie sessionid = driver.manage().getCookieNamed("SESSIONID");
//        driver.manage().deleteCookie(sessionid);
//        driver.manage().deleteCookieNamed("SESSIONID");
        driver.manage().deleteAllCookies();

        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a/button[contains(text(),'click')]")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        Set<String> childWindows = driver.getWindowHandles();

        for (String window : childWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;

            }
        }

        System.out.println(driver.getTitle());
        driver.switchTo().defaultContent();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
    }

    public static void newSeperateWindowTest() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
//        Set<Cookie> cookies = driver.manage().getCookies();
//        Cookie sessionid = driver.manage().getCookieNamed("SESSIONID");
//        driver.manage().deleteCookie(sessionid);
//        driver.manage().deleteCookieNamed("SESSIONID");
        driver.manage().deleteAllCookies();

        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]")).click();

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[text()='click']")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        Set<String> childWindows = driver.getWindowHandles();

        for (String window : childWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;

            }
        }

        System.out.println(driver.getTitle());
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
//        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
    }



}

