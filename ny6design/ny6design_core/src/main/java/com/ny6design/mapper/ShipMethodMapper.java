package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.ShipMethod;

public interface ShipMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShipMethod record);

    int insertSelective(ShipMethod record);

    ShipMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShipMethod record);

    int updateByPrimaryKey(ShipMethod record);

	List<ShipMethod> selectAll();

	ShipMethod getDefaultShipMethod();
}