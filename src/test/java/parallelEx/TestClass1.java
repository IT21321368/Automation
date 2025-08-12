package parallelEx;

import org.testng.annotations.Test;

public class TestClass1 {
    @Test(groups = "smoke")
    public void test1(){
        System.out.println("TC 01 test1 : execute in "+Thread.currentThread().getId());
    }

    @Test(dependsOnGroups = "smoke")
    public void test2(){
        System.out.println("TC 01 test2 : execute in "+Thread.currentThread().getId());
    }

    @Test(groups = "smoke")
    public void test3(){
        System.out.println("TC 01 test3 : execute in "+Thread.currentThread().getId());
    }
}
