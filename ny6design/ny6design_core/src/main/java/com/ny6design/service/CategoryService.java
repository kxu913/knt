package com.ny6design.service;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ny6design.constant.Messages;
import com.ny6design.exception.DeleteForbiddenException;
import com.ny6design.mapper.CategoryMapper;
import com.ny6design.model.Category;
/**
 * 
 * @author kevin
 *
 */
@Service
public class CategoryService {
	
	@Autowired
	CategoryMapper mapper;
	
	public List<Category> getCategoryList(){
		return mapper.getCategoryList(-1);
	}
	
	public List<Category> getSubCategoryList(long parentId){
		
		return mapper.getCategoryList(parentId);
	}
	
	public List<Category> getAllSubCategoryList(){
		
		return mapper.getAllSubCategoryList();
	}

	public void updateCategory(Category category) {
		
		category.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		mapper.updateCategory(category);

	}
	
	public void insertCategory(Category category){
		category.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		category.setValidated(1);
		mapper.insertCategory(category);
	}
	
	public void deleteCategory(long categoryId){
		
		checkDelete(categoryId);
		
		mapper.deleteCategory(categoryId);
	}
	
	@Transactional
	public void orderCategories(Category[] categories){
		
		for(int i=0;i<categories.length;i++){
			
			categories[i].setUpdateTime(new Timestamp(System.currentTimeMillis()));
			categories[i].setOrder(i+1);
			mapper.updateOrder(categories[i]);
		}
	}
	
	public void setValidation(long categoryId, int validated){
		
		if(validated ==0){
			checkDelete(categoryId);
		}
		
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());
		mapper.updateValidation(categoryId, validated, updateTime);
		
	}
	
	private void checkDelete(long categoryId){
		
		List<Category> categoryList = mapper.getCategoryList(categoryId);
		if(categoryList.size() > 0 ){
			throw new DeleteForbiddenException(Messages.ERROR_CATEGORY_DELETE);
		}
		
	}

}
