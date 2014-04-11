/**
 * 
 */
package com.ny6design.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	public void testSetPorductAsIndex(){
		productService.setPorductWithIndex("50", 1);
		assertThat(1).isNotEqualTo(productService.getProductInfo(50).getIndex());
	}

	@Test
	public void testDeleteProduct(){
		productService.deleteProduct("61");
	}
	
	
	@Test
	public void testGetIndexProducts4FE(){
		assertThat(productService.getIndexProductList4Front(3)).isNotEmpty();
	}
	
	@Test
	public void testGetProductList4Front(){
		int numInLine = 3;
		List<List<Product>> list = productService.getProductList4Front(184, numInLine);
		if(list!=null && list.size()>0){
			assertThat(list.get(0).size()).isLessThanOrEqualTo(3);
		}
	}
	
	
	@Test
	public void testGetTotalCost(){
		BigDecimal total = productService.getTotalCost(49, 1);
		assertThat(total.compareTo(BigDecimal.valueOf(3.99))).isEqualTo(0);
		
		total = productService.getTotalCost(49, 6);
		assertThat(total.compareTo(BigDecimal.valueOf(3.39*6))).isEqualTo(0);
		
		total = productService.getTotalCost(49, 21);
		assertThat(total.compareTo(BigDecimal.valueOf(2.80*21))).isEqualTo(0);
		
	}
}
