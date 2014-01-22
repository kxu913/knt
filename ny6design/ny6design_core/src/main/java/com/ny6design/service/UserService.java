package com.ny6design.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.security.util.PasswordUtil;
import com.ny6design.mapper.UserMapper;
import com.ny6design.model.User;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User findUserByEmail(String emailAddress) {
		if (!StringUtils.isEmpty(emailAddress)) {
			return userMapper.selectUserByEmail(emailAddress);
		}
		return null;
	}

	public void insert(User user) {
		// 加密
		byte[] salt = PasswordUtil.getSalt();
		user.setSalt(salt);
		user.setPassword(PasswordUtil.entryptPassword(salt, user.getPassword()));
		userMapper.insert(user);
	}

	public User selectByPrimaryKey(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public void updateByPrimaryKey(User user) {
		userMapper.updateByPrimaryKey(user);
	}
}
