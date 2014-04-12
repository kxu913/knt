package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.PayMethodMapper;
import com.ny6design.model.PayMethod;

/**
 * 
 * @author kxu
 *
 */
@Service
public class PayMethodService {
	@Autowired
	PayMethodMapper payMethodMapper;
	
	public List<PayMethod> getAllPayMethods(){
		return payMethodMapper.selectAll();
	}
	
	public PayMethod getPayMethodById(String id){
		return payMethodMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

}
