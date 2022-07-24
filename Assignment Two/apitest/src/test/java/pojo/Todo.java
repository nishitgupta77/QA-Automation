package pojo;

public class Todo {

	private String title;
	private String due_on;
	private String status;
	private int id;
	private int user_id;

	public int getId() {
		return id;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDue_on() {
		return due_on;
	}
	public void setDue_on(String due_on) {
		this.due_on = due_on;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
