package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import file.Payload;
import io.restassured.path.json.JsonPath;
import pojo.Comment;
import utils.BaseSpec;

public class CreateComment {

	private int userId;

	@Test
	public void CreateCommentTest(){
		//1. Add a new user
		String response = given().spec(BaseSpec.request())
				.body(Payload.AddUserRequestPayload())
				.when()
				.post("public/v2/users")
				.then().assertThat().statusCode(201)
				.extract().response().asPrettyString();

		//2. Fetch user Id to store in variable
		JsonPath json1 = new JsonPath(response);
		userId = json1.get("id");

		//3. Add a new Post
		String responsePost=given().spec(BaseSpec.request())
				.body(Payload.AddPostRequestPayload())
				.when()
				.post("public/v2/users/" + userId + "/posts")
				.then().assertThat().statusCode(201)
				.extract().response().asPrettyString();

		//4. Fetch post Id to store in variable
		JsonPath json2 = new JsonPath(responsePost);
		int postId = json2.get("id");

		//5. Add a new comment
		given().spec(BaseSpec.request())
		.body(Payload.AddCommentRequestPayload())
		.when()
		.post("/public/v2/posts/"+postId+"/comments")
		.then()
		.assertThat().statusCode(201);

		//6. Get call to verify that new comment is added
		Comment comment =  given().spec(BaseSpec.request())
				.body(Payload.AddCommentRequestPayload())
				.when()
				.post("/public/v2/posts/"+postId+"/comments").as(Comment.class);

		Assert.assertEquals(comment.getName(),"Nishit Gupta");
		Assert.assertEquals(comment.getEmail(),"nishit.gupta@gmail.com");
		Assert.assertEquals(comment.getBody(),"This is Sample body for Test");
	}

	@AfterMethod
	public void DeleteUser()
	{
		if(userId!=0) {
			given().spec(BaseSpec.request())
			.when()
			.delete("public/v2/users/"+ userId)
			.then().statusCode(204);}
	}

}
