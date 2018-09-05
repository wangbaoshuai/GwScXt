package com.biz;

import java.util.List;

import com.entity.User;

public interface UserBiz {
	public int addUser(User user)throws Exception;
	public int deleteUser(User user)throws Exception;
	public int updateUser(User user)throws Exception;
	public List<User> findAllUsers()throws Exception;
	public User findUserByLogin(User user)throws Exception;
	public User findUserByIdnumber(String idnumber)throws Exception;
	public List<User> findUsersBySex(String sex)throws Exception;
}
