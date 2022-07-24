package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import file.Payload;
import io.restassured.path.json.JsonPath;
import pojo.Todo;
import utils.BaseSpec;

public class CreateTodo {

	private int userId;

	@Test
	public void CreateTodoTest() {

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

		//3. Add a new Todo
		given().spec(BaseSpec.request())
		.body(Payload.AddTodoRequestPayload())
		.when()
		.post("public/v2/users/"+userId+"/todos")
		.then().assertThat().statusCode(201);

		//4. Get to verify that Todo has been added
		Todo todo =  given().spec(BaseSpec.request())
				.body(Payload.AddTodoRequestPayload())
				.when()
				.post("public/v2/users/" + userId + "/todos").as(Todo.class);

		Assert.assertEquals(todo.getTitle(), "This is Title for Test");
		Assert.assertEquals(todo.getDue_on(), "2022-07-26T00:00:00.000+05:30");
		Assert.assertEquals(todo.getStatus(), "completed");
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
