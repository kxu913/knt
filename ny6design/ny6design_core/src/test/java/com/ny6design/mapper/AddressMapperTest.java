package com.ny6design.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.core.MappForMybatis;
import com.ny6design.model.Address;
import com.ny6design.service.CategoryService;

public class AddressMapperTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	AddressMapper addressMapper;

	@Before
	public void init() {
		MappForMybatis mapperForMybatis = Env.getBean("mapperForMybatis");
		addressMapper = mapperForMybatis.getMapper(AddressMapper.class);
	}
	@Test
	public void testInsert() {
		Address address = new Address();
		address.setAddress("test");
		address.setCountrycode("US");
		address.setStatecode("TAX");
		address.setTown("town");
		address.setZipcode("ts");
		addressMapper.insert(address);
		System.out.println(address.getAddressid());
	}

}
