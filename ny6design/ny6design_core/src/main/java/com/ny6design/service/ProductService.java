package com.ny6design.service;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.ny6design.model.ProductDescription;
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
    
    private void copyAndInsertProduct(Product existProduct){
    	
    	if(existProduct!=null){
    		//get the exist product info
    		ProductDescription pd = existProduct.getProductDesc();
        	List<ProductPrice> ppList = existProduct.getProductPriceList();
        	List<ProductImage> piList = existProduct.getProductImageList();
        	
    		//insert product info
    		existProduct.setProductId(null);
    		existProduct.setStatus(null);//set Disabled
    		productMapper.insertProduct(existProduct);
    		
    		int newpId = existProduct.getProductId(); 
    		//copy description info
    		if(pd!=null){
    			pd.setProductId(newpId);
    			productMapper.insertProductDesc(pd);
    		}
    		
    		//copy price data
    		if(ppList!=null && ppList.size()>0){
    			for(ProductPrice pp : ppList){
    				pp.setProductId(newpId);
    				productMapper.insertProductPrice(pp);
    			}
    		}
    		
    		//TOBE add productImage
    		if(piList!=null && piList.size()>0){
    			
    		}
    	}
    } 
    
    public void copyPorduct(String productIds){
    	if(StringUtils.contains(productIds+",", ",")){
    		String[] productIdArray = productIds.split(",");
    		if(productIdArray.length>0){
    			for(String productId: productIdArray){
    				// get, then remove productid, save product, get pid, and save refer tables;
    				Product p= productMapper.getProductDetail(Integer.valueOf(productId));
    				copyAndInsertProduct(p);
    			}
    		}
    	}
    }
    
    public void deleteProduct(String productIds){
    	if(StringUtils.contains(productIds+",", ",")){
    		String[] productIdArray = productIds.split(",");
    		if(productIdArray.length>0){
    			for(String productId: productIdArray){
    				productMapper.deleteProductById(Integer.valueOf(productId));
    				productMapper.deleteProductDescByProductId(Integer.valueOf(productId));
    				productMapper.deleteProductImpageByProductId(Integer.valueOf(productId));
    				productMapper.deleteProductPriceByProductId(Integer.valueOf(productId));
    			}
    		}
    	}
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
