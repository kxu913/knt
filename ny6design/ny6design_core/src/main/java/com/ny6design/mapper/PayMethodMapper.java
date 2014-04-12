package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);

	List<PayMethod> selectAll();
}