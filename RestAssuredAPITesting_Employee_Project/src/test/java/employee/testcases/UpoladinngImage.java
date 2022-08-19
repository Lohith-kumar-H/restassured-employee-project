package employee.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UpoladinngImage 
{
	//@Test
	public void uploadImageFile()
	{
		RestAssured.baseURI="https://petstore.swagger.io";
		Response re=given().header("Content-Type","multipart/form-data")
		  .formParam("additionalMetadata","Test")
		.multiPart("file",new File("C:\\IMG20220626072046.jpg"),"image/jpeg")
		   .when()
		.post("/v2/pet/9223372036854100000/uploadImage");
	System.out.println(re.statusCode());
	System.out.println(re.asPrettyString());
	}
	
	//@Test
public void download() throws IOException{
			
		Response response=	RestAssured.given().when().get("https://reqres.in/api/users").andReturn();
			
			byte[] bytes=response.getBody().asByteArray();
			File file= new File( "/users/promode.json");
		     Files.write(file.toPath(), bytes);
		}
		
	}


