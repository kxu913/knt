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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.CartDetail;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.Product;
import com.ny6design.model.ShoppingCart;
import com.ny6design.model.User;
import com.ny6design.model.UserDetail;
import com.ny6design.service.PayMethodService;
import com.ny6design.service.ProductService;
import com.ny6design.service.ShipMethodService;
import com.ny6design.service.ShoppingCartService;
import com.ny6design.service.ShoppingRuleService;
import com.ny6design.service.UserService;
import com.ny6design.service.OrderSummayService;
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
			"shoppingcart/address", "shoppingcart/discount", "shoppingcart/shipmethod", "shoppingcart/paymethod",
			"shoppingcart/submit" };
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	ProductService productService;
	@Autowired
	ShoppingRuleService shoppingRuleService;
	@Autowired
	ShipMethodService shipMethodService;
	@Autowired
	PayMethodService payMethodService;
	@Autowired
	UserService userService;
	@Autowired
	OrderSummayService orderSummayService;

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
		addOrdersFromDBIntoCart(cart, getUserId(request));
		addProductIntoCart(cart, productId, amount);
		if (getUserId(request) > 0) {
			UserDetail user = userService.getUserById(request.getSession().getAttribute("userid").toString());
			model.put("user", user);
		}
		cart.setSubtotal(cart.calcSubTotal());
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
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
		this.addOrdersFromDBIntoCart(cart, getUserId(request));
		cart.setSubtotal(cart.calcSubTotal());
		cart.setSubtotal(cart.calcSubTotal());
		model.put("indexProducts", getIndexProducts());
		return new ModelAndView(ORDERVIEWS[0], model);
	}

	@RequestMapping("checkout")
	public ModelAndView addCart(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		if (cart == null || cart.getOrders() == null || cart.getOrders().isEmpty()) {
			return new ModelAndView("shoppingcart/selectProduct", model);
		}
		cart.setSubtotal(cart.calcSubTotal());
		cart.setSubtotal(cart.calcSubTotal());
		model.put("rules", shoppingRuleService.getRulesByPage(ORDERVIEWS[1]));
		return new ModelAndView(ORDERVIEWS[1], model);
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
		cart.setSubtotal(cart.calcSubTotal());
		cart.setSubtotal(cart.calcSubTotal());
		if (ORDERVIEWS[0].equalsIgnoreCase(url)) {
			model.put("indexProducts", getIndexProducts());
		}
		return new ModelAndView(url, model);
	}

	@RequestMapping("ship")
	public ModelAndView ship(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		int userId = getUserId(request);
		if (userId > 0) {
			UserDetail user = userService.getUserById(request.getSession().getAttribute("userid").toString());
			model.put("user", user);
			shoppingCartService.updateOrders(cart, userId);
		} else {
			return new ModelAndView("login/loginAndRegister", model);
		}
		return new ModelAndView(ORDERVIEWS[2], model);
	}

	@RequestMapping("discount")
	public ModelAndView discount(HttpServletRequest request, final ModelMap model) {
		model.put("rules", shoppingRuleService.getRulesByPage(ORDERVIEWS[3]));
		return new ModelAndView(ORDERVIEWS[3], model);
	}

	@RequestMapping("shipmethod")
	public ModelAndView shipmethod(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		cart.setShipMethod(shipMethodService.getDefaultShipMethod());
		cart.setTotal(cart.calcTotal());
		model.put("shipmethods", shipMethodService.getAllShipMethods());
		model.put("rules", shoppingRuleService.getRulesByPage(ORDERVIEWS[1]));
		return new ModelAndView(ORDERVIEWS[4], model);
	}

	@RequestMapping("recalc")
	@ResponseBody
	public BigDecimal reCalc(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		String shipMethodId = request.getParameter("shipMethodId");
		cart.setShipMethod(shipMethodService.getShipById(shipMethodId));
		return cart.calcTotal();
	}

	@RequestMapping("paymethod")
	public ModelAndView PayMethod(HttpServletRequest request, final ModelMap model) {
		model.put("paymethods", payMethodService.getAllPayMethods());
		return new ModelAndView(ORDERVIEWS[5], model);
	}

	@RequestMapping("goTosubmit")
	public ModelAndView goTosubmit(HttpServletRequest request, final ModelMap model) {
		String payMethodId = request.getParameter("paymethodId");
		String notice = request.getParameter("notice");
		CartDetail cart = (CartDetail) model.get("cart");
		cart.setPayMethod(payMethodService.getPayMethodById(payMethodId));
		cart.setNotice(notice);
		return new ModelAndView(ORDERVIEWS[6], model);
	}

	@RequestMapping("submit")
	@ResponseBody
	public String submit(HttpServletRequest request, final ModelMap model, final SessionStatus status) {
		CartDetail cart = (CartDetail) model.get("cart");
		UserDetail user = (UserDetail) model.get("user");
		orderSummayService.insertOrder(cart);
		shoppingCartService.emptyCart(cart);
		model.remove(cart);
		model.remove(user);
		status.setComplete();
		return "0";
	}

	@RequestMapping("productNumber")
	public ModelAndView getProductNumber(HttpServletRequest request, final ModelMap model) {
		CartDetail cart = (CartDetail) model.get("cart");
		if (cart == null || cart.getOrders() == null || cart.getOrders().isEmpty()) {
			return new ModelAndView("shoppingcart/selectProduct", model);
		}
		return new ModelAndView(ORDERVIEWS[1], model);
	}

	private int getUserId(HttpServletRequest request) {
		Object _userId = request.getSession().getAttribute("userid");
		int userId = 0;
		if (_userId != null) {
			userId = (Integer) _userId;
		}
		return userId;
	}

	private void addOrdersFromDBIntoCart(CartDetail cart, int userId) {
		if (userId > 0 && !cart.isHasInited()) {
			cart.getOrders().addAll(shoppingCartService.getAllOrders(userId));
			cart.setHasInited(true);
		}
	}

	private void addProductIntoCart(CartDetail cart, int productId, int amount) {
		OrderDetail detail = shoppingCartService.addProductToCart(cart, productId, amount);
		if (!detail.isInCart()) {
			cart.getOrders().add(detail);
		}
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
