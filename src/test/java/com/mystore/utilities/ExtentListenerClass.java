package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExtentListenerClass implements ITestListener {
ExtentSparkReporter htmlReporter;
ExtentReports reports;
ExtentTest test;

public void configureReport(){
    String timestamp = new SimpleDateFormat("yyyy-dd-mm hh-mm-ss").format(new Date());
    String reportName= "CodestudioFrameworkReport"+timestamp+".html";
    htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+reportName);
    reports = new ExtentReports();
    reports.attachReporter(htmlReporter);

    reports.setSystemInfo("machine","windows10");
    reports.setSystemInfo("username","Rajat sharma");
    reports.setSystemInfo("browser","chrome");

    htmlReporter.config().setDocumentTitle("Extent report title this is");
    htmlReporter.config().setReportName("Extent Report Name");
    htmlReporter.config().setTheme(Theme.DARK);

}

    @Override
    public void onTestStart(ITestResult result) {
        configureReport();
        System.out.println("on start method invoked");

    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("on finish method invoked");
        reports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("name of the test method PASSED is"+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("name of the Passed test case is"+result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("name of the test method failed is"+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("name of the failed test case is"+result.getName(), ExtentColor.RED));
        String screenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+ result.getName()+".png";

        File screeshotfile = new File(screenshotpath);
        if(screeshotfile.exists()){
            test.fail("Captures screenshot is"+test.addScreenCaptureFromPath(screenshotpath));
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("name of the test method SKIPPED is"+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("name of the SKIPEPD test case is"+result.getName(), ExtentColor.YELLOW));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

}
