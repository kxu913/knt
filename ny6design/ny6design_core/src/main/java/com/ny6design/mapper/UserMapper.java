package com.ny6design.mapper;

import java.util.Map;

import com.ny6design.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectUser(Map<String, Object> params);
	
	User selectUserByEmail(String emailAddress);
}