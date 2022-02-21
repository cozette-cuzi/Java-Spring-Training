package com.restful.webservices.restful.post;

public class Post {
	private int id;
	private int userId;
	private String title;
	private String content;
	public Post(int id, int userId, String title, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
