package com.biz.impl;

import com.biz.TestBiz;
import com.entity.User;

public class TestBizImpl implements TestBiz{
	public void test(){
		System.out.println("����ҵ��ĵ�һ������");
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
	}
}
