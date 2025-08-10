package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSimpleDataProvider {
    @DataProvider(name = "simpleDataProvider")
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"Amal",36},
                new Object[]{"Kmal",26},
                new Object[]{"Sunimal",16},
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void testSimpleDataProvider(String name,int age){
        System.out.printf("My name is %s And I'm %d years old.\n",name, age);

    }
}
