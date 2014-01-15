package com.ny6design.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.Category;

public class CategoryServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	CategoryService categoryService;

	@Before
	public void init() {
		categoryService = Env.getBean("categoryService");
	}

	@Test
	public void testInsertCategory() {
		Category category = new Category();
		category.setName("testCategory");
		category.setOrder(1);
		category.setParentId(-1);
		category.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		category.setValidated(0);
		categoryService.insertCategory(category);
		List<Category> list = categoryService.getCategoryList();
		assertNotNull(list);
		boolean contain = false;
		long id = 0;
		for (Category _category : list) {
			if (category.getName().equals(_category.getName())) {
				contain = true;
				id = _category.getCategoryId();
				break;
			}
		}
		assertTrue(contain);
		categoryService.deleteCategory(id);
	}

}
