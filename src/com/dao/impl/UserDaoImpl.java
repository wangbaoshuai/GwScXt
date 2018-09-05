package com.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionTemplate sst;
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		sst.insert("com.dao.UserDao.addUser", user);
		return 1;
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		sst.update("com.dao.UserDao.updateUser", user);
		return 1;
	}

	@Override
	public List<User> findAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		User u = sst.selectOne("com.dao.UserDao.findByLogin", user);
		return u;
	}

	public SqlSessionTemplate getSst() {
		return sst;
	}

	public void setSst(SqlSessionTemplate sst) {
		this.sst = sst;
	}

	@Override
	public User findUserByIdnumber(String idnumber) throws Exception {
		// TODO Auto-generated method stub
		User user = sst.selectOne("com.dao.UserDao.findByIdnumber", idnumber);
		return user;
	}

	@Override
	public List<User> findUsersBySex(String sex) throws Exception {
		// TODO Auto-generated method stub
		return sst.selectList("com.dao.UserDao.findUsersBySex", sex);
	}

}
