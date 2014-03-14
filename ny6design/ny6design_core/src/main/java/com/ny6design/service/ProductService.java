package com.ny6design.service;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ny6design.mapper.Product2CategoryMapper;
import com.ny6design.mapper.ProductDescriptionMapper;
import com.ny6design.mapper.ProductImageMapper;
import com.ny6design.mapper.ProductMapper;
import com.ny6design.mapper.ProductPriceMapper;
import com.ny6design.model.Product;
import com.ny6design.model.Product2CategoryKey;
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
        	List<Product2CategoryKey> pcList = existProduct.getProductCategoryList();
        	
			
			
    		//insert product info
    		existProduct.setProductId(null);
    		existProduct.setStatus(1);//set Disabled
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
    		
    		if(pcList!=null && pcList.size()>0){
    			for(Product2CategoryKey pc : pcList){
    				if(pc==null) continue;
    				pc.setProductId(newpId);
    				productMapper.insertProductCategory(pc);
    			}
    		}
    		
    		//TODO add productImage
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
    
    public List<List<Product>> getProductList4Front(int categoryId, int numInLine){
    	List<Product> productList = productMapper.getProductsByCategory(categoryId);
    	List<List<Product>> resultList = Lists.newArrayList();
		if(productList!=null && productList.size()>0){
			int size = productList.size();
			List<Product> temp = null;
			for(int i=0; i<size; i++){
				if(i==0){
					temp = Lists.newArrayList();
				}
				temp.add(productList.get(i));
				if(  (i+1)%numInLine == 0 ){
					resultList.add(temp);
					temp = Lists.newArrayList();
				}
				if((i+1)==size){
					if(temp.size()<numInLine){
						while(temp.size()<numInLine){
							temp.add(null);
						}
					}
					resultList.add(temp);
				}
			}
		}
		return resultList;
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
