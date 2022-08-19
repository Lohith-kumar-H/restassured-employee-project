package employee.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import employee.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_Get_Single_Employees_Record extends TestBase

{
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void getSingleEmployees() throws InterruptedException
	{
		logger.info("*****started TC002_Get_Single_Employees_Record*****" );
		RestAssured.baseURI="http://localhost:8080/app";//"http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/videogames/"+empID);

		Thread.sleep(3000);

	}

	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains("Doom"),true);
	}

	@Test
	void checkStatusCode()
	{
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	void checkResponseTime()
	{ 
		long responseTime=response.getTime();
		Assert.assertTrue(responseTime<1000);
	}

	@Test
	void checkStatusLine()
	{
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ");

	}
	@Test
	void checkContentType()
	{
		String contentType=response.header("content-Type");
		Assert.assertEquals(contentType, "application/xml");
	}

	//@Test
	void checkServerType()
	{
		String server=response.header("Server");
		Assert.assertEquals(server, "nginx");
	}

	
	@Test
	void checkContentLength()
	{
		String contentlength=response.header("Content-Length");
		Assert.assertTrue(Integer.parseInt(contentlength)>70);
	}
	@AfterClass
	void tearDown()
	{
		logger.info("****finished TC002_Get_Single_Employees_Record****");
	}

}
