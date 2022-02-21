package com.restful.webservices.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservices.restful.entity.User;

// we just define an interface and Spring will do the implementation for it


public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
