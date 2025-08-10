package testNG;

import org.testng.annotations.Test;

public class HomeTest {
    @Test
    public void makeFoundation(){
        System.out.println("Make Foundation : Foundation is created");
    }

    @Test(dependsOnMethods = "makeFoundation")
    public void makeWalls(){
        System.out.println("Make Walls : Walls are created");
    }

    @Test(dependsOnMethods = "makeWalls")
    public void makeRoof(){
        System.out.println("Make Roofs : Roofs are created");
    }

    @Test(dependsOnMethods = {"makeWalls","makeRoof"})
    public void fixDoorsAndWindows(){
        System.out.println("Fix Roofs And Windows");
    }

    @Test(dependsOnMethods = "makeWalls")
    public void supplyElectricityAndWater(){
        System.out.println("Supply Electricity And Water");
    }

}
