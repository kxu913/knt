package com.ny6design.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.security.util.PasswordUtil;
import com.ny6design.mapper.UserMapper;
import com.ny6design.model.User;
import com.ny6design.model.UserDetail;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class UserService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
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

	private void update(User user) {
		byte[] salt = PasswordUtil.getSalt();
		user.setSalt(salt);
		user.setPassword(PasswordUtil.entryptPassword(salt, user.getPassword()));
		userMapper.updateByPrimaryKeySelective(user);
	}

	public User selectByPrimaryKey(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public void updateByPrimaryKey(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	public List<UserDetail> getAllUsers() {
		return userMapper.getAllUsers();
	}

	public UserDetail getUserById(String userId) {
		if (StringUtils.isNotEmpty(userId)) {
			return userMapper.getUserById(Integer.parseInt(userId));
		} else {
			if (log.isWarnEnabled()) {
				log.warn("Empty UserId!");
			}
			return null;
		}
	}

	public void save(User user) {
		if (user.getUserid() != null) {
			this.update(user);
		} else {
			this.insert(user);
		}
	}

}
