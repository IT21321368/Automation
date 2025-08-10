package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertTest {
    @Test
    public void hardAssertion(){
        String name = "Kamal";
        System.out.println("A");
        System.out.println("B");
//        Assert.assertTrue(false);
        Assert.assertEquals(name,"Aamal");
        System.out.println("C");
        System.out.println("D");
    }
}
