package com.example.servletdom.service;

import java.util.HashMap;

import com.example.servletdom.domain.User;

public class UserService {
	
	private HashMap<String, String> db = new HashMap<String, String>();
	
	public Boolean add(User user) {
		if (isNameInDB(user)) {
			return false;
		}
		db.putIfAbsent(user.getName(), user.getPass());
		return true;
	}
	
	public String getPass(String name) {
		return db.get(name);
	}
	
	public void setPass(User user) {
		db.replace(user.getName(), user.getPass());
	}
	
	public void setPass(String name, String pass) {
		db.replace(name, pass);
	}
	
	public Boolean isNameInDB(User user) {
		if (db.containsKey(user.getName())) {
			return true;
		}
		return false;
	}
	
	public Boolean isUserRegistered(User user) {
		if (db.containsKey(user.getName())) 
			if( db.get(user.getName()).equals(user.getPass())) {
			return true;
		}
		return false;				
	}
	
	public Boolean isUserRegisteredd(String name, String pass) {
		if (db.containsKey(name)) 
			if(pass.equals(db.get(name))) {
			return true;
		}
		return false;				
	}
	
	public HashMap<String, String> getAllUsers() {
		return db;
	}

}
