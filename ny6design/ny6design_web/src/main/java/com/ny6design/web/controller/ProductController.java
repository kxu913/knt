package com.ny6design.web.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny6design.model.Product;
import com.ny6design.model.ProductWeb;
import com.ny6design.service.ProductService;
import com.ny6design.utility.ResultFilter;
import com.ny6design.utility.ReturnStatus;
import com.ny6design.web.utill.ImageUploadUtil;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@ResponseBody
	@RequestMapping("/getProduct")
	public Product getProduct(long productId) {
		Product product = service.getProduct(productId);
		return product;
	}

	@RequestMapping("/goToProductList")
	public String goToProductList() {
		return "productList";
	}

	@ResponseBody
	@RequestMapping("/productPageList")
	public ResultFilter<Product> getProductPageList(long categoryId, int page) {

		List<Product> productList = service.getProductPageList(categoryId,
				(page - 1) * ResultFilter.PAGE_SIZE, page
						* ResultFilter.PAGE_SIZE);
		ResultFilter<Product> rf = new ResultFilter<Product>();
		rf.setItems(productList);
		rf.setTotalCount(service.getProductCount(categoryId));
		rf.setCurrentPage(page);
		return rf;
	}

	@ResponseBody
	@RequestMapping("/recommendProductList")
	public List<Product> getRecommendProductList() {
		List<Product> productList = service.getRecommendProductList();
		return productList;
	}

	@RequestMapping("/goToAddProduct")
	public String goToAddProduct() {
		return "addProduct";
	}

	@RequestMapping("/goToFileUpload")
	public String goToFileUpload() {
		return "productPictures";
	}

	@RequestMapping("/addProduct")
	public @ResponseBody
	Object addProduct(HttpServletRequest request,
			@RequestBody ProductWeb productWeb, ModelMap model) {

		productWeb.setProductId(0);

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			productWeb.constructSaleFlag();
			productWeb.constructPriceList();
			productWeb.constructProductPictures();

			// Save description file
			String newFileName = ImageUploadUtil
					.generateFileName("description.html");
			String ctxPath = request.getSession().getServletContext()
					.getRealPath("/");
			File uploadFolder = ImageUploadUtil.getParentPath(ctxPath, "html");
			File uploadFileLocation = new File(uploadFolder, newFileName);
			String description = productWeb.getDescription();
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(
					description.getBytes());
			if (ImageUploadUtil.htmlUpload(byteInputStream, uploadFileLocation)) {
				// save filename path into the description filed
				int index = uploadFileLocation.getAbsolutePath().indexOf(
						ctxPath);
				String path = uploadFileLocation.getAbsolutePath().substring(
						index + ctxPath.length());
				productWeb.setDescription(path);
			}

			Product product = (Product) productWeb;
			Timestamp current = new Timestamp(System.currentTimeMillis());
			product.setUpdatedTime(current);
			product.setCreateTime(current);

			service.insertProduct(product);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, productWeb);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;
	}

}
