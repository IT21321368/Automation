package listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test Method Started :"+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Method Success :"+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Method Failed :"+result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test Method Skipped :"+result.getName());
    }
}
