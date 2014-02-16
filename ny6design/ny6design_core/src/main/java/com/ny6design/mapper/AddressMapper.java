package com.ny6design.mapper;

import java.util.List;
import java.util.Map;

import com.ny6design.model.Address;
import com.ny6design.model.AddressDetail;

public interface AddressMapper {
	int deleteByPrimaryKey(Integer addressid);

	int insert(Address record);

	int insertSelective(Address record);

	Address selectByPrimaryKey(Integer addressid);

	int updateByPrimaryKeySelective(Address record);

	int updateByPrimaryKey(Address record);

	List<AddressDetail> selectAllAddressByUserId(int userId);

	Object selectDefaultAddress(String userId);

	int updateDefault(Map<String, Object> params);
}