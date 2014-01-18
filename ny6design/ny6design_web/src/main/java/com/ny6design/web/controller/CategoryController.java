package com.ny6design.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny6design.model.Category;
import com.ny6design.service.CategoryService;
import com.ny6design.utility.ReturnStatus;
/**
 * 
 * @author kevin
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@ResponseBody
    @RequestMapping("/categoryList")
    public List<Category> getCategoryList() {
        List<Category> list = service.getCategoryList();
        return list;
    }
	
	@ResponseBody
    @RequestMapping("/getAllCategoryList")
	public List<Category> getAllCategoryList() {
		
		List<Category> list = service.getCategoryList();
		list.addAll(service.getAllSubCategoryList());
        return list;
    }
	
	// ------------------------------------------------------------ SubCategory
	@ResponseBody
    @RequestMapping("/subCategoryList")
    public List<Category> getSubCategoryList(@RequestBody Category category) {
		
		List<Category> list = service.getSubCategoryList(category.getParentId());
        return list;
    }	
}
