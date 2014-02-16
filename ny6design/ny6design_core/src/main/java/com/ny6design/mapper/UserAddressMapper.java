package com.ny6design.mapper;

import com.ny6design.model.UserAddress;

public interface UserAddressMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserAddress record);

	UserAddress selectByPrimaryKey(Integer id);

}