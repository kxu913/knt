package com.ny6design.service;


import java.util.List;






import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ny6design.mapper.ProductMapper;
import com.ny6design.model.Product;
import com.ny6design.model.ProductPic;
import com.ny6design.model.ProductPrice;

@Service
public class ProductService {
    
	Logger logger = Logger.getLogger(ProductService.class);
	
    @Autowired
    ProductMapper productMapper;
    
    public Product getProduct(long productId){
        return productMapper.getProduct(productId);
    }
    
    @Transactional
    public void insertProduct(Product product){
    	
    	productMapper.insertProduct(product);
    	
    	long productId = product.getProductId();
    	for(ProductPrice price : product.getPrices()){
    		price.setProductId(productId);
    		productMapper.insertProductPrice(price);
    	}
    	
    	for(ProductPic picture : product.getPictureSources()){
    		logger.debug("insert into product picture:" + picture);
    		picture.setProductId(productId);
    		productMapper.insertProductPicture(picture);
    	}
    }
    
    public List<Product> getProductPageList(long categoryId, int start, int end){
    	return productMapper.getProductPageList(categoryId, start, end);
    }

	public List<Product> getRecommendProductList() {
		return productMapper.getRecommendProductList();
	}

	public int getProductCount(long categoryId) {
		
		return productMapper.getProductCount(categoryId);
	}

}
