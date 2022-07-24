package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import file.Payload;
import io.restassured.path.json.JsonPath;
import utils.BaseSpec;
import pojo.*;

public class CreatePost {

	private int userId; 
	@Test
	public void CreatePostTest() {

		//1. Add a new user
		String response = given().spec(BaseSpec.request())
				.body(Payload.AddUserRequestPayload())
				.when()
				.post("public/v2/users")
				.then().assertThat().statusCode(201)
				.extract().response().asPrettyString();

		//2. Fetch user Id to store in variable
		JsonPath json = new JsonPath(response);
		userId = json.get("id");

		//3. Add a new Post
		given().spec(BaseSpec.request())
		.body(Payload.AddPostRequestPayload())
		.when()
		.post("public/v2/users/" + userId + "/posts")
		.then().assertThat().statusCode(201);

		//4. Get call to verify that new post has been created
		Post post =  given().spec(BaseSpec.request())
				.body(Payload.AddPostRequestPayload())
				.when()
				.post("public/v2/users/" + userId + "/posts").as(Post.class);

		Assert.assertEquals(post.getTitle(),"This is Title for Test");	
		Assert.assertEquals(post.getBody(),"This is Sample body for Test");	
	}

	@AfterMethod
	public void DeleteUser()
	{
		if(userId!=0)
		{
			given().spec(BaseSpec.request())
			.when()
			.delete("public/v2/users/"+ userId)
			.then().statusCode(204);
			}
	}
}
