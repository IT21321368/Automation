package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParellelTest {

    long startTime;

    @BeforeClass
    public void beforeClass(){
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public void afterClass(){
        long endTime = System.currentTimeMillis()- startTime;
        System.out.println("Execution Time : "+ endTime);
    }

    @Test
    public void method1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            System.out.println("Method 1 :"+i);
        }
    }

    @Test
    public void method2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Method 2 :"+i);
        }
    }

    @Test
    public void method3() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1500);
            System.out.println("Method 3 :"+i);
        }
    }

    @Test
    public void method4() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2500);
            System.out.println("Method 4 :"+i);
        }
    }

    @Test
    public void method5() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println("Method 5 :"+i);
        }
    }
}
