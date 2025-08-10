package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    @Test
    public void softAssertion(){
        SoftAssert softAssert = new SoftAssert();

        String name = "Kamal";
        System.out.println("A");
        System.out.println("B");
        softAssert.assertEquals(name,"Amal");
        System.out.println("C");
        System.out.println("D");
        softAssert.assertAll();
    }
}
