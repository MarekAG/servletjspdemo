package com.example.servletdom.service;

import java.util.HashMap;

import com.example.servletdom.domain.User;

public class UserService {
	
	private HashMap<String, String> db = new HashMap<String, String>();
	
	public Boolean add(User user) {
		if (isNameInDB(user)) {
			return false;
		}
		db.put(user.getName(), user.getPass());
		return true;
	}
	
	public String getPass(String name) {
		return db.get(name);
	}
	
	public Boolean isNameInDB(User user) {
		if (db.containsKey(user.getName())) {
			return true;
		}
		return false;
	}
	
	public Boolean isUserRegistered(User user) {
		if (db.containsKey(user.getName()) && (db.get(user.getPass()) != null)) {
			return true;
		}
		return false;				
	}
	
	public Boolean isUserRegistered(String name, String pass) {
		if (db.containsKey(name) && (db.get(pass) != null)) {
			return true;
		}
		return false;				
	}
	
	public HashMap<String, String> getAllUsers() {
		return db;
	}

}
