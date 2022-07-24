package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseSpec {

	public static RequestSpecification request()
	{
		return new RequestSpecBuilder()
				.setBaseUri("https://gorest.co.in/")
				.addHeader("Authorization","Bearer a0e51518506fcf96b5120bf7128647cd470e9a52df93780a0998d207f9ef4610")
				.setContentType(ContentType.JSON)
				.build();	
	}

	public static ResponseSpecification response()
	{
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
}
