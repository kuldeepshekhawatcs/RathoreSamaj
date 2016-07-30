package com.society.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.society.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
    private UserDao userDao;

	@Override
	public String validateUser(String username, String password) {
		return userDao.validateUser(username, password);
		
	}
	


	
}
