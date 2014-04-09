package com.ny6design.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ny6design.model.UserDetail;
import com.ny6design.service.ProductService;
import com.ny6design.service.ShoppingCartService;
import com.ny6design.service.ShoppingRuleService;
import com.ny6design.service.UserService;
import com.ny6design.web.constant.CONSTANT;

/**
 * order process controller
 * 
 * @author kevin
 * 
 */
@Controller
@RequestMapping("shoppingcart")
@SessionAttributes({ "cart", "user" })
public class OrderProcessController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String[] ORDERVIEWS = new String[] { "shoppingcart/cartDetail", "shoppingcart/checkout",
			"shoppingcart/address", "shoppingcart/discount", "shoppingcart/ship", "shoppingcart/submit" };
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	ProductService productService;
	@Autowired
	ShoppingRuleService shoppingRuleService;

	@Autowired
	UserService userService;

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
		} else {
			UserDetail user = userService.getUserById(request.getSession().getAttribute("userid").toString());
			model.put("user", user);
		}
		cart.getOrders().addAll(shoppingCartService.getAllOrders(getUserId(request)));
		cart.setSubtotal(getSubTotal(cart.getOrders()));
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
	}

	@RequestMapping("checkout")
	public ModelAndView addCart(HttpServletRequest request, final ModelMap model) {

		CartDetail cart = (CartDetail) model.get("cart");
		cart.getOrders().addAll(shoppingCartService.getAllOrders(getUserId(request)));
		cart.setSubtotal(getSubTotal(cart.getOrders()));
		model.put("rules", shoppingRuleService.getRulesByPage(ORDERVIEWS[1]));
		return new ModelAndView(ORDERVIEWS[1], model);
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

	@RequestMapping("remove/{orderId}")
	public ModelAndView removeFromCart(@PathVariable("orderId") int orderId, HttpServletRequest request,
			final ModelMap model) {
		String url = request.getParameter("url");
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
		return new ModelAndView(url, model);
	}

	@RequestMapping("ship")
	public ModelAndView ship(HttpServletRequest request, final ModelMap model) {
		if (getUserId(request) > 0) {
			UserDetail user = userService.getUserById(request.getSession().getAttribute("userid").toString());
			model.put("user", user);
		} else {
			return new ModelAndView("login/loginAndRegister", model);
		}
		return new ModelAndView(ORDERVIEWS[2], model);
	}

	private int getUserId(HttpServletRequest request) {
		Object _userId = request.getSession().getAttribute("userid");
		int userId = 0;
		if (_userId != null) {
			userId = (Integer) _userId;
		}
		return userId;
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

	private List<Product> getIndexProducts() {
		try {
			return productService.getIndexProductList4Front(CONSTANT.NumInLines).get(0);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

}
