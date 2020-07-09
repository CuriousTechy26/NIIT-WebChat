package com.niit.webchat.dao;

import java.util.List;

import com.niit.webchat.model.UserData;

public interface UserDataDao {
	boolean addUser(UserData user);
	boolean updateUser(UserData user);
	boolean deleteUser(UserData userData);
	List<UserData> getAllUsers();
	UserData getUserByUserId(int userId);
	public boolean validate(int id, String password);
	UserData getUserByEmail(String email);

}
