package employee.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;	
import io.restassured.specification.RequestSpecification;

public class TestBase
{
	public static RequestSpecification  httpRequest;
	public static Response response;
	public String empID="16"; //hard coded - Input for get details of single Employee and update employee
	
	public Logger logger;
	
	@BeforeClass 
	public void setup()
	{
		logger=Logger.getLogger("EmployeeRestAPI");//adder Logger
		PropertyConfigurator.configure("log4j.properties");//adder Logger
		logger.setLevel(Level.DEBUG);
	}

}
