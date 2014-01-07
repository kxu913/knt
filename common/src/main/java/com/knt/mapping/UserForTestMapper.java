package com.knt.mapping;

import java.util.List;

import com.knt.model.UserForTest;

public interface UserForTestMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserForTest record);

	int insertSelective(UserForTest record);

	UserForTest selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserForTest record);

	int updateByPrimaryKey(UserForTest record);

	UserForTest selectByUserName(String userName);
	
    List<UserForTest> getUserList();
    
    List<UserForTest> getAdminList();


}