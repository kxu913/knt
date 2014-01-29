package com.ny6design.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.mapper.ProductMapper;
import com.ny6design.model.Product;
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
	@Autowired
	ProductMapper productMapper;

	@RequestMapping("/getProductList")
	public ModelAndView  getProductList(ModelMap model) {
		List<Product> productList = productMapper.getProductsByCategory(184);

		model.put("productList", productList);
		return new ModelAndView ("pictable",model);
	}
	
	@RequestMapping("/pdetail/{productId}")
	public ModelAndView  getProductInfo(@PathVariable int productId, ModelMap model) {
		Product product = productMapper.getProductDetail(productId);

		model.put("product", product);
		return new ModelAndView ("pdetail",model);
	}

}
