package com.ny6design.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ny6design.mapper.ProductMapper;
import com.ny6design.model.Product;
import com.ny6design.service.CategoryService;
import com.ny6design.service.ProductService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class ProductController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService service;
	@Autowired
	ProductMapper productMapper;

	@RequestMapping(value="/insertProduct", method=RequestMethod.POST)
	public String processSubmit(@Valid Product product, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}
		
		productMapper.insertProduct(product);
		// Typically you would save to a db and clear the "form" attribute from the session 
		// via SessionStatus.setCompleted(). For the demo we leave it in the session.
		String message = "Form submitted successfully.  Bound " + product;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return null;
		} else {
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/getProductList";			
		}
	}
	
	@RequestMapping("/getProductList")
	public ModelAndView  getProductList(ModelMap model) {
		List<Product> productList = productMapper.getProductsByCategory(184);
		
		model.put("productList", productList);
		return new ModelAndView ("pictable",model);
	}
	
	@RequestMapping("/getProductList4Admin")
	public ModelAndView  getProductList4Admin(ModelMap model) {
		List<Product> productList = productMapper.getProducts4Admin();
		model.put("productList", productList);
		return new ModelAndView ("admin/product/productlist",model);
	}
	
	@RequestMapping("/pdetail/{productId}")
	public ModelAndView  getProductInfo(@PathVariable int productId, ModelMap model) {
		Product product = productMapper.getProductDetail(productId);

		model.put("product", product);
		model.put("catergory", categoryService.getCategoryInfo(product.getCategoryId()));
		return new ModelAndView ("pdetail",model);
	}

}
