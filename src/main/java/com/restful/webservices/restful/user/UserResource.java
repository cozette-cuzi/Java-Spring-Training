package com.restful.webservices.restful.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service = new UserDaoService();

	@GetMapping(path = "/users")
	public List<User> retreiveAllUsers() {
		return service.findAll();
	}

	@GetMapping(path="/users/{id}")
	public EntityModel<User> retreiveUser(@PathVariable int id) {
		User user = service.findOne(id); 
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retreiveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		if(user == null) 
			throw new UserNotFoundException("id-" + id);
		return resource;	
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		boolean user = service.deleteUser(id);

		if (!user)
			throw new UserNotFoundException("id-" + id);

	}
}
