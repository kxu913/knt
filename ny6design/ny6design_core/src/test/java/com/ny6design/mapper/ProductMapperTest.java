package com.ny6design.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.core.MappForMybatis;
import com.ny6design.model.Product;
import com.ny6design.model.ProductPrice;

public class ProductMapperTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	ProductMapper productMapper;

	@Before
	public void init() {
		MappForMybatis mapperForMybatis = Env.getBean("mapperForMybatis");
		productMapper = mapperForMybatis.getMapper(ProductMapper.class);
	}
	
	@Test
	public void testInsert() {
		Product product = new Product();
		product.setModel("test");
		product.setSku("only one");
		product.setLocation("shenzhen");
		product.setQuantity(28);
		product.setStockStatusId(3);
		product.setImage("data/ipad1.jpg");
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
		
		productMapper.insertProduct(product);
		assertThat(product.getProductId()).isNotNull();
	}
	
	@Test
	public void testGetProductByCategory(){
		List<Product> productList = productMapper.getProductsByCategory(184);
		assertThat(productList).isNotEmpty();	  
	}
	
	@Test
	public void testGetProductDetail(){
		Product pdetail = productMapper.getProductDetail(49);
		assertThat(pdetail.getImage()).isNotEmpty();
	}
	
	@Test
	public void testGetPrice4Product(){
		List<ProductPrice> priceList = productMapper.getPrice4Product(51);
		assertThat(priceList.size()).isGreaterThan(0);
	}
	
	@Test
	public void testGetProductsByCategory(){
		List<Product> prodList = productMapper.getProductsByCategory(184);
		
		assertThat(prodList.size()).isGreaterThan(0);
	}
	
	@Test
	public void testGetProducts4Admin(){
//		String columnName = "tpd.name";
		String columnName = "quantity";
		String orderby = "asc";
		List<Product> prodList = productMapper.getProducts4Admin(columnName, orderby);
		assertThat(prodList.size()).isGreaterThan(0);
	}
	
	@Test
	public void testInsertProductPrice(){
		ProductPrice pp = new ProductPrice();
		pp.setCustomerGroupId(1);
		pp.setPrice(new BigDecimal(0.33));
		pp.setDateEnd(new Date());
		pp.setDateEnd(new Date());
		pp.setQuantity(1);
		pp.setPriority(1);
		pp.setProductId(59);
		productMapper.insertProductPrice(pp);
		assertThat(pp.getProductDiscountId());
	}
	
	@Test
	public void testGetFilterProducts4Admin(){
		Map<String,Object> paras = new HashMap<String, Object>();
//		paras.put("name", "M4 30x28mm Lampwork");
//		paras.put("model", "test");
//		paras.put("price", new BigDecimal(21));
//		paras.put("quantity", 25);
		paras.put("status", 1);
		List<Product> pList = productMapper.getFilterProducts4Admin(paras);
		assertThat(pList.size()).isGreaterThan(0);
    }
	
	@Test
	public void testUpdateProductById(){
		Product pp = new Product();
		pp.setProductId(74);
		pp.setQuantity(30);
		productMapper.updateProductById(pp);
		assertThat(productMapper.getProductDetail(74).getQuantity()).isEqualTo(30);
	}
}
