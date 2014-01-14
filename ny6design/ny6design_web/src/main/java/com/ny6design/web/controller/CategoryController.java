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

	
	@RequestMapping("/updateCategory")
    public @ResponseBody Object updateCategory(@RequestBody Category category) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.updateCategory(category);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category); 
			
		}catch(Exception e){
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
			
		}

        return map;
        
    }
	
	@RequestMapping("/updateCategory1")
    public @ResponseBody Object updateCategory(HttpServletRequest request) {
		long categoryId = Long.valueOf(request.getParameter("categoryId"));
		String name = request.getParameter("name");
		int order = Integer.parseInt(request.getParameter("order"));
		long parentId = Long.parseLong(request.getParameter("parentId"));
		
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setName(name);
		category.setOrder(order);
		category.setParentId(parentId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.updateCategory(category);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
	        map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category); 
		} catch (Exception e) {
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
    }
	
	@RequestMapping("/insertCategory")
	public @ResponseBody Object insertCategory(@RequestBody Category category){
		
		category.setCategoryId(0);
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.insertCategory(category);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category); 
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping("/deleteCategory1/{categoryId}")
	public @ResponseBody Object deleteCategory1(@PathVariable long categoryId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.deleteCategory(categoryId);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, categoryId);
		} catch (Exception e) {
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
	}
	
	@RequestMapping(value="/smashCategory", method = RequestMethod.POST)
	public @ResponseBody Object smashCategory(@RequestBody Category category){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			service.deleteCategory(category.getCategoryId());
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
	}
	
	@RequestMapping(value="/orderCategories", method = RequestMethod.POST)
	public @ResponseBody Object orderCategories(@RequestBody Category[] categories){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.orderCategories(categories);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);	
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}
		return map;
	}
	
	@RequestMapping(value="/deleteCategory", method = RequestMethod.POST)
	public @ResponseBody Object deleteCategory(@RequestBody Category category){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			service.setValidation(category.getCategoryId(), 0);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
	}

	@RequestMapping(value="/revertCategory", method = RequestMethod.POST)
	public @ResponseBody Object revertCategory(@RequestBody Category category){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			service.setValidation(category.getCategoryId(), 1);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, category.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
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
