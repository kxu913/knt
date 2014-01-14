package com.ny6design.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ny6design.model.Product;
import com.ny6design.model.ProductPic;
import com.ny6design.model.ProductPrice;
/**
 * 
 * @author kevin
 *
 */
public interface ProductMapper {
	
	public Product getProduct(long productId);
	
	public void insertProduct(Product product);

	public void insertProductPrice(ProductPrice price);

	public void insertProductPicture(ProductPic picture);

	public List<Product> getProductPageList(@Param("categoryId") long categoryId, @Param("start") int start, @Param("end") int end);

	public List<Product> getRecommendProductList();

	public int getProductCount(long categoryId);
	
}
