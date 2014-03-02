package com.ny6design.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ny6design.model.Product;
import com.ny6design.model.ProductDescription;
import com.ny6design.model.ProductImage;
import com.ny6design.model.ProductPrice;

public interface ProductMapper {

    int insertProduct(Product record);
    int insertProductDesc(ProductDescription desc);
    int insertProductPrice(ProductPrice price);
    int insertProductImage(ProductImage image);
    
    int deleteProductById(Integer productId);
    int deleteProductDescByProductId(Integer productId);
    int deleteProductImpageByProductId(Integer productId);
    int deleteProductPriceByProductId(Integer productId);

    Product selectByPrimaryKey(Integer productId);

    Product getProductDetail(Integer productId);
    
    List<ProductDescription> getDesc4Product(Integer productId);
    
    List<ProductPrice> getPrice4Product(Integer productId);
    
    List<Product> getProductsByCategory(Integer categoryId);
    
    List<Product> getProducts4Admin(@Param("orderColumnName") String orderColumnName, @Param("orderBy") String orderBy);
    
    List<Product> getFilterProducts4Admin(Map<String, Object> params);
}