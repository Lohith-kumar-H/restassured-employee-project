package employee.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import employee.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase
{
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("*****started TC001_Get_All_Employees*****" );
		 RestAssured.baseURI=/*"http://localhost:8080/app";*/"http://dummy.restapiexample.com/api/v1";
		 httpRequest=RestAssured.given();
		 response=httpRequest.request(Method.GET,"/employees");
		 
		 Thread.sleep(3);
		
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("******check response body****");
		
		String  responseBody=response.getBody().asString();
		logger.info("Response Body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	
	@Test
	void checkStatusCode()
	{
		int statuscode=response.getStatusCode();
		logger.info("statuscode is ==>"+statuscode);
		Assert.assertEquals(statuscode, 200);

	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("*****Check Response Time****");
		 
		long responseTime=response.getTime();
		logger.info("Response Time is ==>"+responseTime);
		
		if(responseTime>11100)
			logger.warn("Response time is grater than 2100");
		
		Assert.assertTrue(responseTime<11100);
	}

	@Test
	void checkStatusLine()
	{
		logger.info("***check Status Line***");
		
		String statusLine=response.getStatusLine();
		logger.info("status line is ==>"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		logger.info("***check content type****");
		
		String contentType=response.header("content-Type");
		logger.info("content-Type is ==>"+contentType);
		Assert.assertEquals(contentType, "application/json");
	}
	
	@Test
	void checkServerType()
	{
		logger.info("***check Server type**");
		
		String server=response.header("Server");
		logger.info("server type is ==>"+server);
		Assert.assertEquals(server, "nginx");
	}
	
	@Test
	void checkcontentEncoding()
	{
		logger.info("***check content encoding***");
		
		String contentenc=response.header("Content-Encoding");
		logger.info("content encoding is ==>"+contentenc);
		Assert.assertEquals(contentenc, "gzip");
	}
	
	@Test
	void checkContentLength()
	{
		logger.info("***check content length****");
		
		String contentlength=response.header("Content-Length");
		logger.info("content length is ==>"+contentlength);
		
		if(Integer.parseInt(contentlength)<100)
			logger.warn("content length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentlength)>100);
	}
	
	@Test
	void checkCookies()
	{
		logger.info("***check cookies***");
		
		String cookie=response.getCookie("PHPSESSID");
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("****finished TC001_Get_All_Employees****");
	}
}
