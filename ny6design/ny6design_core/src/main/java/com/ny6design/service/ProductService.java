package com.ny6design.service;


import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ny6design.mapper.Product2CategoryMapper;
import com.ny6design.mapper.ProductDescriptionMapper;
import com.ny6design.mapper.ProductImageMapper;
import com.ny6design.mapper.ProductMapper;
import com.ny6design.mapper.ProductPriceMapper;
import com.ny6design.model.Product;
import com.ny6design.model.ProductImage;
import com.ny6design.model.ProductPrice;

@Service
public class ProductService {
    
	Logger logger = Logger.getLogger(ProductService.class);
	
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductPriceMapper productPriceMapper;
    @Autowired
    ProductImageMapper productImageMapper;
    @Autowired
    ProductDescriptionMapper productDescriptionMapper;
    @Autowired
    Product2CategoryMapper productCategoryMapper;
    
/*    public Product getProduct(long productId){
        return productMapper.getProduct(productId);
    }*/
    
    @Transactional
    public void insertProduct(Product product){
    	productMapper.insertProduct(product);
    }
    
    
    
/*    public List<Product> getProductPageList(long categoryId, int start, int end){
    	return productMapper.getProductPageList(categoryId, start, end);
    }

	public List<Product> getRecommendProductList() {
		return productMapper.getRecommendProductList();
	}

	public int getProductCount(long categoryId) {
		
		return productMapper.getProductCount(categoryId);
	}
*/
}
