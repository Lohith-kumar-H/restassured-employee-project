package employee.utlities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.reporter.ExtentReporter;

public class Listeners extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporetr;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext textcontext)
	{
		htmlReporetr=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");

		htmlReporetr.config().setDocumentTitle("employee automation report");
		htmlReporetr.config().setReportName("rest api testing");
		//htmlReporetr.config().setTestViewChartLocation(chartLocation.TOP);
		htmlReporetr.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(htmlReporetr);
		extent.setSystemInfo("project name", "restAPI");
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "lohith");

	}
	public void onTestSuccess(ITestResult result)
	{
		//text=extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		test=extent.createTest(result.getName());

		test.log(Status.PASS,"test case is passesd is"+result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());

		test.log(Status.FAIL,"test case is passesd is"+result.getName());
		test.log(Status.FAIL,"test case is passesd is"+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());

		test.log(Status.SKIP,"test case is passesd is"+result.getName());

	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
