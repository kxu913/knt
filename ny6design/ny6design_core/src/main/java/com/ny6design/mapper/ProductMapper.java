package com.ny6design.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ny6design.model.Product;
import com.ny6design.model.Product2CategoryKey;
import com.ny6design.model.ProductDescription;
import com.ny6design.model.ProductImage;
import com.ny6design.model.ProductPrice;

public interface ProductMapper {

	int setPorductAsIndex(Product record);
	int updateProductById(Product record);
	int updateProductDescByProductId(ProductDescription desc);
    int updateProductImpageByProductId(ProductImage image);
    int updateProductPriceByProductId(ProductPrice price);
	
    int insertProduct(Product record);
    int insertProductDesc(ProductDescription desc);
    int insertProductPrice(ProductPrice price);
    int insertProductImage(ProductImage image);
    int insertProductCategory(Product2CategoryKey p2c);
    
    int deleteProductById(Integer productId);
    int deleteProductDescByProductId(Integer productId);
    int deleteProductImpageByProductId(Integer productId);
    int deleteProductPriceByProductId(Integer productId);
    int deletePCByProductId(Integer productId);

    Product selectByPrimaryKey(Integer productId);

    Product getProductDetail(Integer productId);
    
    List<ProductDescription> getDesc4Product(Integer productId);
    
    List<Product2CategoryKey> getProductCategoryList(Integer productId);
    
    List<ProductPrice> getPrice4Product(Integer productId);
    
    List<Product> getProductsByCategory(Integer categoryId);
    
    List<Product> getProducts4Admin(@Param("orderColumnName") String orderColumnName, @Param("orderBy") String orderBy);
    List<Product> getIndexList4Admin(@Param("orderColumnName") String orderColumnName, @Param("orderBy") String orderBy);
    
    List<Product> getFilterProducts4Admin(Map<String, Object> params);
    
    List<Product> getIndexProducts4FE();
}