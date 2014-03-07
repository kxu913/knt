package com.ny6design.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ny6design.mapper.ProductMapper;
import com.ny6design.model.Product;
import com.ny6design.model.ProductImage;
import com.ny6design.model.ProductPrice;
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

	@RequestMapping("/insertProduct")
	public String insertProduct() {
		return "admin/product/insertproduct";
	}
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	public String saveProduct(Product product, BindingResult result, 
//								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}
		if(product.getProductId()==null){
			productMapper.insertProduct(product);
			
			if(product.getProductDesc()!=null){
				productMapper.insertProductDesc(product.getProductDesc());
			}
			
			List<ProductImage> imageList = product.getProductImageList();
			if(imageList!=null && imageList.size()>0){
				for(ProductImage image: imageList){
					productMapper.insertProductImage(image);
				}
			}
			
			List<ProductPrice> priceList = product.getProductPriceList();
			if(priceList!=null && priceList.size()>0){
				for(ProductPrice price:priceList){
					productMapper.insertProductPrice(price);
				}
			}
		}
		else{
			productMapper.updateProductById(product);
			
			if(product.getProductDesc()!=null){
				productMapper.updateProductDescByProductId(product.getProductDesc());
			}
			
			List<ProductImage> imageList = product.getProductImageList();
			if(imageList!=null && imageList.size()>0){
				for(ProductImage image: imageList){
					productMapper.updateProductImpageByProductId(image);
				}
			}
			
			List<ProductPrice> priceList = product.getProductPriceList();
			if(priceList!=null && priceList.size()>0){
				for(ProductPrice price:priceList){
					productMapper.updateProductPriceByProductId(price);
				}
			}
		}
		
		return "redirect:/getProductList4Admin";
	}
	
	@RequestMapping("/getProductList")
	public ModelAndView  getProductList(ModelMap model) {
		List<Product> productList = productMapper.getProductsByCategory(184);
		
		model.put("productList", productList);
		return new ModelAndView ("pictable",model);
	}
	
/*	@RequestMapping("/orderProduct")
	public ModelAndView orderProduct(ModelMap model, @ModelAttribute("productColumnName") String productColumnName, 
			@ModelAttribute("orderBy") String orderBy) {
		List<Product> productList = productMapper.getOrderedProducts4Admin();
		model.put("productList", productList);
		return new ModelAndView ("admin/product/productlist",model);
	}*/
	
	@RequestMapping("/getProductList4Admin")
	public ModelAndView  getProductList4Admin(ModelMap model, 
			@RequestParam(value="orderColumnName", required = false) String orderColumnName, 
			@RequestParam(value="orderBy", required = false) String orderBy) {
		if(StringUtils.isEmpty(orderColumnName)){
			orderColumnName = "date_added";
		}else if("name".equalsIgnoreCase(orderColumnName)){
				orderColumnName = "tpd.name";
		}
		
		if(StringUtils.isEmpty(orderBy)){
			orderBy = "ASC";
		}
		
		List<Product> productList = productMapper.getProducts4Admin(orderColumnName, orderBy);
		model.put("productList", productList);
		return new ModelAndView ("admin/product/productlist",model);
	}
	
	/**
	 * TODO not done
	 * @param model
	 * @param name
	 * @param pmodel
	 * @param price
	 * @param quantity
	 * @param status
	 * @return
	 */
	
	@RequestMapping("/productfilter")
	public ModelAndView  productfilter(ModelMap model, 
			@RequestParam(value="name", required = false) String name, 
			@RequestParam(value="model", required = false) String pmodel, 
			@RequestParam(value="price", required = false) BigDecimal price, 
			@RequestParam(value="quantity", required = false) Integer quantity, 
			@RequestParam(value="status", required = false) Integer status) {
		
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("name", name);
		paras.put("model", pmodel);
		paras.put("price", price);
		paras.put("quantity", quantity);
		paras.put("status", status);
		
		List<Product> productList = productMapper.getFilterProducts4Admin(paras);
		model.put("productList", productList);
		return new ModelAndView ("admin/product/productlist",model);
	}
	
	
	/**
	 * TODO 这个链接要改名为viewdetail
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping("/pdetail/{productId}")
	public ModelAndView  getProductInfo(@PathVariable int productId, ModelMap model) {
		Product product = productMapper.getProductDetail(productId);

		model.put("product", product);
		model.put("catergory", categoryService.getCategoryInfo(product.getCategoryId()));
		return new ModelAndView ("pdetail",model);
	}
	
	@RequestMapping("/editproduct/{productId}")
	public String  editproduct(@PathVariable int productId, ModelMap model) {
		Product product = productMapper.getProductDetail(productId);
		model.put("product", product);
		model.put("catergory", categoryService.getCategoryInfo(product.getCategoryId()));
		return "admin/product/editproduct";
	}
	
	@RequestMapping("/copyproduct/{productIds}")
	public String  copyproduct(@PathVariable String productIds, ModelMap model) {
		service.copyPorduct(productIds);
		return "redirect:/getProductList4Admin";
	}
	
	@RequestMapping("/delproduct/{productIds}")
	public String  delproduct(@PathVariable String productIds, ModelMap model) {
		service.deleteProduct(productIds);
		return "redirect:/getProductList4Admin";
	}

	
}
