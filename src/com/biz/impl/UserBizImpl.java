package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import com.biz.UserBiz;
import com.dao.UserDao;
import com.entity.User;

public class UserBizImpl implements UserBiz {
	@Resource
	private UserDao userdao;
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}

	@Override
	public List<User> findAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.findUserByLogin(user);
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public User findUserByIdnumber(String idnumber) throws Exception {
		// TODO Auto-generated method stub
		return userdao.findUserByIdnumber(idnumber);
	}

	@Override
	public List<User> findUsersBySex(String sex) throws Exception {
		// TODO Auto-generated method stub
		return userdao.findUsersBySex(sex);
	}

}
