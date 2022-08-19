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

public class TC003_Post_Employee extends TestBase 
{
	RequestSpecification httpRequest;
	Response response;
	
	String firstName=RestUtils.fname();
	String lastName=RestUtils.lname();
	String studentId=RestUtils.sid();
	
	@BeforeClass
	void postEmployee() throws InterruptedException
	{
		logger.info("*****started TC003_Post_Employees_Record*****" );
		RestAssured.baseURI="http://localhost:3000";//"http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		//json object is a class that represnt a simple json.we can add key-value pairs using the put method
		JSONObject requestpara= new JSONObject();
		  
		/*data.put("id","60");
		data.put("name", "pubg");
		data.put("releaseDate", "2020-08-20T08:45:55.520Z");
		data.put("reviewScore", "6");
		data.put("category", "Battle");
		data.put("rating", "universal");*/
		   requestpara.put("firstName", "fname");
		   requestpara.put("lastName", "lname");
		   requestpara.put("studentId", "sid");
		   
		   //add a header stating  the request body is a  json
		   httpRequest.header("Content-Type","application/json");
		   
		  
		   httpRequest.body(requestpara.toJSONString());
		
		    response=httpRequest.request(Method.POST,"/users");
		    
		    Thread.sleep(5000);
	}
	
	@Test
	void checkResponseBody()
	{
		
	String responseBody=response.getBody().asString();
		//System.out.println(response.getBody().asString());
		Assert.assertEquals(responseBody.contains("fname"),true);
		Assert.assertEquals(responseBody.contains("lname"),true);
		Assert.assertEquals(responseBody.contains("sid"),true);
		//System.out.println(responseBody);
	}
	
	@Test
	void checkStatusCode()
	{
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 201);
	}
	
	@Test
	void checkStatusLine()
	{
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");

	}
	
	@Test
	void checkContentType()
	{
		String contentType=response.header("content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}

	//@Test
	void checkServerType()
	{
		String server=response.header("Server");
		Assert.assertEquals(server, "nginx");
	}

	
	//@Test
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
