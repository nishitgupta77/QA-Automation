package pojo;

public class Comment {
	
	private int id;
	private int post_id;
	private String name;
	private String email;
	private String body;
	
	public int getId() {
		return id;
	}
	public int getPost_id() {
		return post_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
