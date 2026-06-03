package utilities;

import org.testng.ITestContext;
import java.io.File;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotUtil;
import CloseoutPro.NotConnect.GlobalData;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();

    ExtentTest test;
    
    
    
    @Override
    public void onStart(ITestContext context) {

        File folder = new File("Screenshots");

        File[] files = folder.listFiles();

        if (files != null) {

            for (File file : files) {

                file.delete();
            }
        }
    }
    
    
    
    
    
    
    
    

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

     
    
    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        GlobalData.driver,
                        result.getMethod().getMethodName());

        try {

        	test.addScreenCaptureFromPath(
        	        System.getProperty("user.dir") + "/" + screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}