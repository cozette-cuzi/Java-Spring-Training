package com.restful.webservices.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restful.webservices.restful.entity.User;
import com.restful.webservices.restful.service.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Coco", "User");
		repository.save(user);
		java.util.Optional<User> userWithIDOne = repository.findById(1L);
		logger.info("New User has been Retrieved " + userWithIDOne);
	}
	
	
	
}
