package employee.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employee.base.TestBase;
import employee.utlities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Put_Employee_Record extends TestBase
{
	RequestSpecification httpRequest;
	Response response;
	
	String ename=RestUtils.ename();
	String esal=RestUtils.esal();
	String eage=RestUtils.eage();
	
	@BeforeClass
	void putEmployee() throws InterruptedException
	{
		logger.info("*****started TC004_Put_Employees_Record*****" );
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		//json object is a class that represnt a simple json.we can add key-value pairs using the put method
		JSONObject requestpara= new JSONObject();
		  
		   requestpara.put("name", "ename");
		   requestpara.put("salary", "esal");
		   requestpara.put("age", "eage");
		   
		   //add a header stating  the request body is a  json
		   httpRequest.header("Content-Type","application/json");
		   
		  
		   httpRequest.body(requestpara.toJSONString());
		
		    response=httpRequest.request(Method.PUT,"/update/"+empID);
		    
		    Thread.sleep(5000);
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empID),true);
		Assert.assertEquals(responseBody.contains(esal),true);
		Assert.assertEquals(responseBody.contains(eage),true);
	}
	
	@Test
	void checkStatusCode()
	{
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void checkStatusLine()
	{
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}
	
	@Test
	void checkContentType()
	{
		String contentType=response.header("content-Type");
		Assert.assertEquals(contentType, "application/json");
	}

	@Test
	void checkServerType()
	{
		String server=response.header("Server");
		Assert.assertEquals(server, "nginx");
	}

	
	@Test
	void checkcontentEncoding()
	{
		String contentenc=response.header("Content-Encoding");
		Assert.assertEquals(contentenc, "gzip");
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("****finished TC002_Get_Single_Employees_Record****");
	}
	

}
