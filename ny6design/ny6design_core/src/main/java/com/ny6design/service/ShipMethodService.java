package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.ShipMethodMapper;
import com.ny6design.model.ShipMethod;

/**
 * 
 * @author kxu
 * 
 */
@Service
public class ShipMethodService {
	@Autowired
	ShipMethodMapper shipMethodMapper;

	public List<ShipMethod> getAllShipMethods() {
		return shipMethodMapper.selectAll();
	}
	
	public ShipMethod getDefaultShipMethod() {
		return shipMethodMapper.getDefaultShipMethod();
	}

	public ShipMethod getShipById(String shipMethodId) {
		Integer id = Integer.parseInt(shipMethodId);
		return shipMethodMapper.selectByPrimaryKey(id);
	}
}
