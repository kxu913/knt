package com.ny6design.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.CartDetail;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.Product;
import com.ny6design.model.ShoppingCart;
import com.ny6design.service.ProductService;
import com.ny6design.service.ShoppingCartService;
import com.ny6design.web.constant.CONSTANT;

/**
 * order process controller
 * 
 * @author kevin
 * 
 */
@Controller
@RequestMapping("shoppingcart")
@SessionAttributes("cart")
public class OrderProcessController {
	private static final String[] ORDERVIEWS = new String[] { "cartDetail", "checkout", "address", "discount", "ship",
			"submit" };
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	ProductService productService;

	@RequestMapping("add/{productId}/{amount}")
	public ModelAndView addCart(@PathVariable("productId") int productId, @PathVariable("amount") int amount,
			HttpServletRequest request, final ModelMap model) {

		CartDetail cart = (CartDetail) model.get("cart");
		if (cart == null) {
			cart = new CartDetail();
			model.put("cart", cart);
			ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(getUserId(request));
			cart.setCart(shoppingCart);
			List<OrderDetail> orders = new ArrayList<OrderDetail>();
			cart.setOrders(orders);
		}
		// if user not login, can't get order from DB, so need add into list
		if (getUserId(request) <= 0) {
			cart.getOrders().add(shoppingCartService.addProductToCart(cart.getCart(), productId, amount));
		}
		cart.getOrders().addAll(shoppingCartService.getAllOrders(getUserId(request)));
		cart.setSubtotal(getSubTotal(cart.getOrders()));
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
	}
	
	private List<Product> getIndexProducts(){
		return productService.getIndexProductList4Front(CONSTANT.NumInLines).get(0);
	}

	@RequestMapping("open")
	public ModelAndView openShoppingCart(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		if (cart == null) {
			cart = new CartDetail();
			model.put("cart", cart);
			ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(getUserId(request));
			cart.setCart(shoppingCart);
			List<OrderDetail> orders = new ArrayList<OrderDetail>();
			cart.setOrders(orders);
		}
		cart.getOrders().addAll(shoppingCartService.getAllOrders(getUserId(request)));
		cart.setSubtotal(getSubTotal(cart.getOrders()));
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
	}

	@RequestMapping("orderCount")
	@ResponseBody
	public int getOrderCount(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		if (cart != null) {
			return cart.getOrders().size();
		}
		return shoppingCartService.getAllOrders(getUserId(request)).size();
	}

	private BigDecimal getSubTotal(List<OrderDetail> orders) {
		BigDecimal subtotal = BigDecimal.ZERO;
		subtotal.setScale(2);
		if (!orders.isEmpty()) {
			for (OrderDetail order : orders) {
				subtotal = subtotal.add(order.getOrder().getCost());
			}
		}
		return subtotal;
	}

	@RequestMapping("remove/{orderId}")
	public ModelAndView removeFromCart(@PathVariable("orderId") int orderId, HttpServletRequest request,
			final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		OrderDetail detail = null;
		for (OrderDetail _detail : cart.getOrders()) {
			if (orderId == _detail.getOrder().getId()) {
				detail = _detail;
			}
		}
		cart.getOrders().remove(detail);
		shoppingCartService.removeOrderFromCart(orderId);
		cart.getOrders().addAll(shoppingCartService.getAllOrders(getUserId(request)));
		cart.setSubtotal(getSubTotal(cart.getOrders()));
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
	}

	private int getUserId(HttpServletRequest request) {
		Object _userId = request.getSession().getAttribute("userid");
		int userId = 0;
		if (_userId != null) {
			userId = (Integer) _userId;
		}
		return userId;
	}
}
