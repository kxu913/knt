package com.ny6design.mapper;


import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ny6design.model.Category;


/**
 * 
 * @author kevin
 *
 */
public interface CategoryMapper {
	
	public List<Category> getCategoryList(long parentId);
	
	public List<Category> getAllSubCategoryList();
	
	public void updateCategory(Category category);
	
	public void insertCategory(Category category);
	
	public void deleteCategory(long categoryId);
	
	public void updateOrder(Category category);
	
	
	public void updateValidation(@Param("categoryId") long categoryId, @Param("validated") int validated, @Param("updateTime") Timestamp updateTime);
	
	public Category getCategoryInfo(long categoryId);
}
