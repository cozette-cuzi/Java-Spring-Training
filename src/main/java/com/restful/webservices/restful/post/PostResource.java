package com.restful.webservices.restful.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	@Autowired 
	PostDaoService service = new PostDaoService();
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		List<Post> posts = service.findForUser(id);
		return posts;
	}
	

}
