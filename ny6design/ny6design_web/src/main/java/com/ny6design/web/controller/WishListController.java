package com.ny6design.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.WishListKey;
import com.ny6design.model.WishProduct;
import com.ny6design.service.WishListService;


@Controller
@SessionAttributes("userid")
public class WishListController {
	
	@Autowired
	WishListService wishListService;
	
	@ResponseBody
	@RequestMapping("wishlist/gettotalnum")
	public Integer getTotalNum(HttpServletRequest request, ModelMap model){
		Object userId = request.getSession().getAttribute("userid");
		List<WishProduct> temp = null;
		if(userId!=null){
			model.addAttribute("userid", userId); //初始化 @SessionAttributes("userid")，方便后继使用
			temp = wishListService.getAllProductInWishList((Integer) userId);
		}
		
		if(temp!=null && temp.size()>0){
			return temp.size();
		}else{
			return 0;
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="wishlist/add/{productId}", method=RequestMethod.GET)
	public Integer add2WishList(@ModelAttribute("userid") Integer userId, 
			@PathVariable Integer productId){
		if(userId!=null){
			WishListKey wishListKey = new WishListKey();
			wishListKey.setProductId(productId);
			wishListKey.setUserId(userId);
			
			if(!wishListService.isWishProductExist(wishListKey)){
				wishListService.insertWishProduct(wishListKey);
			}
			List<WishProduct> temp = wishListService.getAllProductInWishList(userId);
			if(temp!=null && temp.size()>0){
				return temp.size();
			}else{
				return null;
			}
		}
		else{
			return -1;
		}
		
	}
	
	@RequestMapping("wishList")
	public ModelAndView getUserWishList(ModelMap model, HttpServletRequest request, @ModelAttribute("userid") Integer userId) {
		if(userId!=null){
			model.put("wishList", wishListService.getAllProductInWishList(userId));
		}
		return new ModelAndView("wishList", model);
	}
	
	@RequestMapping("wishList/removeproduct")
	public String removeProductFromWishList(ModelMap model, HttpServletRequest request) {
		Object userId = request.getSession().getAttribute("userid");
		String productId = request.getParameter("productId");
		
		if(userId!=null && productId!=null){
			WishListKey wishListKey = new WishListKey(Integer.parseInt(productId), (Integer)userId);
			wishListService.deleteWishProduct(wishListKey);
		}
		
		return "redirect:/wishList";
	}
}
