package com.practice.restful.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 3;

	static {

		users.add(new User(1, "Aswini", new Date()));
		users.add(new User(2, "Kumar", new Date()));
		users.add(new User(3, "Behera", new Date()));

	}

	public List<User> findAll(){
		return users;
	}


	public User save(User user) {

		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);

		return user;
	}
	
	public User findOne(int id) {

		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
}
