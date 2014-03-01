/**
 * 
 */
package com.ny6design.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.Product;

/**
 * @author tait
 *
 */
public class ProductServiceTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	ProductService productService;

	@Before
	public void init() {
		productService = Env.getBean("productService");
	}
	/**
	 * Test method for {@link com.ny6design.service.ProductService#insertProduct(com.ny6design.model.Product)}.
	 */
	@Test
	public void testInsertProduct() {
		Product product = new Product();
		product.setModel("iphone");
		product.setSku("aaa");
		product.setLocation("shenzhen");
		product.setQuantity(432);
		product.setStockStatusId(3);
		product.setImage("data/iphone3.jpg");
		product.setManufacturerId(1);
		product.setShipping(1);
		product.setPrice(new BigDecimal(21));
		product.setTaxClassId(1);
		product.setDateAdded(new Date());
		product.setWeight(new BigDecimal(32));
		product.setWeightClassId(0);
		product.setLength(new BigDecimal(1));
		product.setWidth(new BigDecimal(1));
		product.setHeight(new BigDecimal(1));
		product.setLengthClassId(12);
		
		product.setStatus(0);
		product.setDateModified(new Date());
		product.setDateAvailable(new Date());
		product.setViewed(12);
		product.setSortOrder(1);
		product.setSubtract(1);
		product.setMinimum(1);
		product.setCost(new BigDecimal(0.000));
		
		productService.insertProduct(product);
	}

	@Test
	public void testDeleteProduct(){
		productService.deleteProduct("61");
	}
}
