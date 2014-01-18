package com.ny6design.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.Product;
import com.ny6design.model.ProductPic;
import com.ny6design.model.ProductPrice;
import com.ny6design.service.ProductService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@RequestMapping("/getProductList")
	public ModelAndView  getProductList(ModelMap model) {
		List<Product> productList = new ArrayList<Product>();

		Product p1 = new Product();
		p1.setDescription("#344 NEW! 17&quot; Cherry Quartz Rose Pendant silver necklace");

		List<ProductPic> picList1 = new ArrayList<ProductPic>();
		ProductPic pic1 = new ProductPic();
		pic1.setSource("static/img/p1.jpg");
		picList1.add(pic1);
		p1.setPictureSources(picList1);

		List<ProductPrice> priceList1 = new ArrayList<ProductPrice>();
		ProductPrice price1 = new ProductPrice();
		price1.setCondition1("1 - 4");
		price1.setSalePrice1(new BigDecimal(27.00));

		price1.setCondition2("5-19");
		price1.setSalePrice2(new BigDecimal(22));

		price1.setCondition3("20+");
		price1.setSalePrice3(new BigDecimal(18));

		priceList1.add(price1);
		p1.setPrices(priceList1);
		
		Product p2 = new Product();
		p2.setDescription("#3443 ONE 90x60mm Large Sea Opalite Cross Pendant Beads");

		List<ProductPic> picList2 = new ArrayList<ProductPic>();
		ProductPic pic2 = new ProductPic();
		pic2.setSource("static/img/p2.jpg");
		picList2.add(pic2);
		p2.setPictureSources(picList2);

		List<ProductPrice> priceList2 = new ArrayList<ProductPrice>();
		ProductPrice price2 = new ProductPrice();
		price2.setCondition1("1 - 4");
		price2.setSalePrice1(new BigDecimal(27.00));

		price2.setCondition2("5-19");
		price2.setSalePrice2(new BigDecimal(22));

		price2.setCondition3("20+");
		price2.setSalePrice3(new BigDecimal(18));

		priceList2.add(price2);
		p2.setPrices(priceList2);
		
		Product p3 = new Product();
		p3.setDescription("#3442 20x16x9mm Natural Lemon Jasper Oval Beads 15\" (Y0803)");

		List<ProductPic> picList3 = new ArrayList<ProductPic>();
		ProductPic pic3 = new ProductPic();
		pic3.setSource("static/img/p3.jpg");
		picList3.add(pic3);
		p3.setPictureSources(picList3);

		List<ProductPrice> priceList3 = new ArrayList<ProductPrice>();
		ProductPrice price3 = new ProductPrice();
		price3.setCondition1("1 - 4");
		price3.setSalePrice1(new BigDecimal(27.00));

		price3.setCondition2("5-19");
		price3.setSalePrice2(new BigDecimal(22));

		price3.setCondition3("20+");
		price3.setSalePrice3(new BigDecimal(18));

		priceList3.add(price2);
		p3.setPrices(priceList2);
		
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		model.put("productList", productList);
		return new ModelAndView ("pictable",model);
	}

}
