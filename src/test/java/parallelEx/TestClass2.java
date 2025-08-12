package parallelEx;

import org.testng.annotations.Test;

public class TestClass2 {
    @Test
    public void test1(){
        System.out.println("TC 02 test1 : execute in "+Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("TC 02 test2 : execute in "+Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println("TC 02 test3 : execute in "+Thread.currentThread().getId());
    }
}
