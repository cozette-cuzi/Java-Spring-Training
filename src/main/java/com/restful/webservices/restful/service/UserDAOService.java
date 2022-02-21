package com.restful.webservices.restful.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restful.webservices.restful.entity.User;

@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user ) {
		
		entityManager.persist(user);
		
		return user.getId();
		
	}

}
