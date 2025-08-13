package listners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListner.class)
public class TestClass1 {
    @Test
    public void testMethod1(){
        System.out.println("TestClass1.TestMethod1");
    }
    @Test
    public void testMethod2(){
//        System.out.println("TestClass1.TestMethod2");
        int div = 10/0;
    }
    @Test
    public void testMethod3(){
        System.out.println("TestClass1.TestMethod1");
    }
}
