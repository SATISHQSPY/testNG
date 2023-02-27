package uTILITY;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImp implements ITestListener{
	ExtentTest extentTest;
	ExtentReports extentReport;
	public void onTestStart(ITestResult result) {
		 extentTest =extentReport.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getMethod().getMethodName()+"got passed message");
	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		path = BaseC.Screenshot(result.getMethod().getMethodName()+"got failed message");
		extentTest.log(Status.FAIL,result.getMethod().getMethodName());
		extentTest.log(Status.FAIL,result.getThrowable());
		extentTest.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getMethod().getMethodName()+"got skipped message");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		JavaUtility J = new JavaUtility();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./ExtentReport/Harish"+J.generateRANDOM());
		extentSparkReporter.config().setDocumentTitle("Harish BUG/ERROR Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		extentReport.setSystemInfo("build", "1.2.3");
		extentReport.setSystemInfo("env","dev");
		extentReport.setSystemInfo("reporter Name", "harish");
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
