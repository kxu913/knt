package com.knt.core;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knt.service.DefinedBeanService;

public class EnvTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");

	@Test
	public void testGetApplicationContext() {
		assertNotNull(Env.getApplicationContext());
	}

	@Test
	public void testGetBeanString() {
		assertNotNull(Env.getBean("dataSource"));
	}

	@Test
	public void testGetBeanClassOfT() {
		assertNotNull(Env.getBean(SqlSessionFactoryBean.class));
	}

	@Test
	public void testGetUserDefinedBean() {
		DefinedBeanService service = Env.getUserDefinedBean("com.knt.service",
				"DefinedBeanService");
		assertNotNull(service);
		service.syso();
	}

}
