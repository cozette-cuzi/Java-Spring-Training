package com.restful.webservices.restful.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restful.webservices.restful.post.Post;

@Component
public class PostDaoService {

	private static List<Post> posts = new ArrayList<>();
	
	static {
		posts.add(new Post(1, 1, "Post Title", "Post content"));
		posts.add(new Post(2, 1, "Post Title", "Post content"));
		posts.add(new Post(3, 2, "Post Title", "Post content"));
		posts.add(new Post(4, 3, "Post Title", "Post content"));
		posts.add(new Post(5, 3, "Post Title", "Post content"));
	}
	
	public List<Post> findForUser(int userId) {
		List<Post> userPosts = new ArrayList<>();
		for(Post post: posts) {
			if(post.getUserId() == userId) {
				userPosts.add(post);
			}
		}
		return userPosts;
	}
	
	
}
