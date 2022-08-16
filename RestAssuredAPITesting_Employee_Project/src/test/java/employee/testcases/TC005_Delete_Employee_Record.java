package employee.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employee.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC005_Delete_Employee_Record extends TestBase
{
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		logger.info("*****started TC001_Get_All_Employees*****" );
		 RestAssured.baseURI=/*"https://dummy.restapiexample.com/api/v1/employees";*/"http://localhost:8080/app/videogames";
		 httpRequest=RestAssured.given();
		 response=httpRequest.request/*(Method.GET,"/employees");*/(Method.DELETE,"/11");
		 
		 //first get the Jsonpath object instance from the response innterface
		//JsonPath jpevaulator=response.jsonPath();
		 
		 //capture id
		// String empID=jpevaulator.get("[0].id");
		 //response=httpRequest.request(Method.DELETE,"/delete/"+empID);
		 
		 Thread.sleep(3);
		
	}
	
  @Test
  void checkResponseBody()
  {
	  String responseBody=response.getBody().asString();
	  Assert.assertEquals(responseBody.contains("Record Deleted Successfully"), true);
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
	void checkcontentlength()
	{
		String contentenc=response.header("Content-length");
		Assert.assertEquals(contentenc, "41");
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("****finished TC002_Get_Single_Employees_Record****");
	}
	

}
