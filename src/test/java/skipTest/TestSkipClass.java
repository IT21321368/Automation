package skipTest;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestSkipClass {
    @Test(enabled = false)
    public void test1(){
        System.out.println("TC 01 test1 : execute in "+Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        boolean condition = false;
        if(!condition){
            throw new SkipException("Skipped test2");
        }
        System.out.println("TC 01 test2 : execute in "+Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println("TC 01 test3 : execute in "+Thread.currentThread().getId());
    }
}
