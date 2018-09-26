package com.library.service;

import java.util.HashMap;
import java.util.Map;

import com.library.model.Users;

public class UserData {

	private static Map<String, String> userMaps = new HashMap();

	public boolean isValidUser(String name, String password) {

		if (userMaps.get(name).equals(password) && userMaps.get(name) != null) {
			return true;
		} else
			return false;
	}

	public static boolean addNewUser(Users newUser) {
		if (!userMaps.containsKey(newUser.getUserName())) {
			userMaps.put(newUser.getUserName(), newUser.getPassword());
			return true;
		} else
			return false;
	}
}
