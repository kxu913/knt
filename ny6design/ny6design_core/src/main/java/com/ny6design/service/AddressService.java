package com.ny6design.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.AddressMapper;
import com.ny6design.model.Address;
import com.ny6design.model.AddressDetail;

@Service
public class AddressService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AddressMapper addressMapper;

	public List<AddressDetail> selectAllAddressByUserId(String userId) {
		try {
			int _userId = Integer.parseInt(userId);
			return addressMapper.selectAllAddressByUserId(_userId);
		} catch (Exception e) {
			log.error("Can't parse userId, the userId is " + userId);
		}
		return Collections.emptyList();
	}

	public void insert(Address _address) {
		addressMapper.insert(_address);
	}

	public int updateToNonDefault(String userId) {
		if (StringUtils.isNotEmpty(userId)) {
			Object _addressId = addressMapper.selectDefaultAddress(userId);
			if (_addressId != null) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("addressId", _addressId.toString());
				params.put("isDefault", 0);
				return addressMapper.updateDefault(params);
			}
		}
		return 0;

	}

	public int updateToDefault(String addressId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("addressId", addressId);
		params.put("isDefault", 1);
		return addressMapper.updateDefault(params);
	}

}
