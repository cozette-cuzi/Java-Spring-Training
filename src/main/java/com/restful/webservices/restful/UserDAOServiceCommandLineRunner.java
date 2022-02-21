package com.restful.webservices.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restful.webservices.restful.entity.User;
import com.restful.webservices.restful.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	UserDAOService service = new UserDAOService();
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Cozette", "Admin");
		long id = service.insert(user);
		logger.info("New User has been Created " + user);
		
	}

}
