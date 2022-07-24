package file;
import java.util.Random;
import pojo.User;
import pojo.Comment;
import pojo.Post;
import pojo.Todo;

public class Payload {

	public static User AddUserRequestPayload() {
		User user = new User();
		user.setName(Payload.Random());
		user.setEmail(Payload.Random()+ "@gmail.com");
		user.setGender("male");
		user.setStatus("Inactive");	
		return user;
	}
	
	public static User AddStaticUserRequestPayload(String name,String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setGender("male");
		user.setStatus("Inactive");	
		return user;
	}
	
	
	public static Post AddPostRequestPayload() {
		Post post = new Post();
		post.setTitle("This is Title for Test");
		post.setBody("This is Sample body for Test");	
		return post;
	}
	
	public static Comment AddCommentRequestPayload() {
		Comment comment = new Comment();
		comment.setName("Nishit Gupta");
		comment.setEmail("nishit.gupta@gmail.com");
		comment.setBody("This is Sample body for Test");	
		return comment;
	}
	
	public static Todo AddTodoRequestPayload() {
		Todo todo = new Todo();
		todo.setTitle("This is Title for Test");
		todo.setDue_on("2022-07-26T00:00:00.000+05:30");
		todo.setStatus("completed");
		return todo;
	}

	public static String Random()
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String randomString = salt.toString();       
		return randomString;		
	}

}
