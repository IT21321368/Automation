package testNG;

import org.testng.annotations.*;

public class TestngAnnotationTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I'm beforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I'm beforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I'm beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'm beforeMethod");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("I'm test1");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("I'm test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I'm afterMethod");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I'm afterClass");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I'm afterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I'm afterSuite");
    }
}
