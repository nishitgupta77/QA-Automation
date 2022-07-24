package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import file.Payload;
import io.restassured.path.json.JsonPath;
import pojo.User;
import utils.BaseSpec;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class CreateUser {

	private static int userId=0;

	@Test
	public void CreateUserTest() {

		//1. Add a new user
		String response = given().spec(BaseSpec.request())
				.body(Payload.AddUserRequestPayload())
				.when()
				.post("public/v2/users")
				.then()
				.assertThat().statusCode(201)
				.extract().response().asPrettyString();

		//2. Fetch user Id to store in variable
		JsonPath json = new JsonPath(response);
		userId = json.get("id");
        


		//3. Get call to verify that user is added
		User user = given().spec(BaseSpec.request())
				.when()
				.get("public/v2/users/" + userId)
				.as(User.class);

		Assert.assertEquals(user.getId(), userId);
		Assert.assertEquals(user.getGender(), "male");
		Assert.assertEquals(user.getStatus(), "inactive");
	}

	@Test
	public void CreateUserWithSameEmail() {

		//1. Add a new user
		String responseUser = given().spec(BaseSpec.request())
				.body(Payload.AddStaticUserRequestPayload("Nishit","nishit2323@gmail.com"))
				.when()
				.post("public/v2/users")
				.then()
				.assertThat().statusCode(201).extract().response().asPrettyString();

		//2. Fetch user Id to store in variable
		JsonPath json1 = new JsonPath(responseUser);
		userId = json1.get("id");
        
		//3. Add another user with same email Id
		String response = given().spec(BaseSpec.request())
				.body(Payload.AddStaticUserRequestPayload("Nishit","nishit2323@gmail.com"))
				.when()
				.post("public/v2/users")
				.then()
				.assertThat().statusCode(422)
				.extract().response().asPrettyString();

		JsonPath json2 = new JsonPath(response);

		ArrayList<String> message = json2.get("message");
		String result = message.get(0).toString();
		Assert.assertEquals("has already been taken",result);
	}

	@Test
	public void CreateUserWithInvalidEmail() {

		//1. Add a new user with Invalid user
		String responseUser = given().spec(BaseSpec.request())
				.body(Payload.AddStaticUserRequestPayload("Nishit","nishitcom"))
				.when()
				.post("public/v2/users")
				.then()
				.assertThat().statusCode(422).extract().response().asPrettyString();

		JsonPath json = new JsonPath(responseUser);

		ArrayList<String> message = json.get("message");
		String result = message.get(0).toString();
		Assert.assertEquals("is invalid",result);		
	}

	@AfterMethod
	public void DeleteUser()
	{

		if(userId!=0) {
			
			given().spec(BaseSpec.request())
			.when()
			.delete("public/v2/users/"+ userId)
			.then().statusCode(204);
			userId=0;
		}
	}
}
