package com.ny6design.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.constant.OrderStatus;
import com.ny6design.mapper.CartOrderMappingMapper;
import com.ny6design.mapper.ShoppingCartMapper;
import com.ny6design.model.CartDetail;
import com.ny6design.model.CartOrderMapping;
import com.ny6design.model.Order;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.Product;
import com.ny6design.model.ShoppingCart;

/**
 * Shopping cart service
 * 
 * @author kevin
 * 
 */
@Service
public class ShoppingCartService {
	@Autowired
	ShoppingCartMapper shoppingCartMapper;

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@Autowired
	CartOrderMappingMapper cartOrderMappingMapper;

	public ShoppingCart getShoppingCart(int userId) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUserId(userId <= 0 ? 0 : userId);
		shoppingCart.setLastupdatetime(new Date());
		shoppingCartMapper.insert(shoppingCart);
		return shoppingCart;

	}

	/**
	 * add a product into shopping cart
	 * 
	 * @param cart
	 * @param productId
	 * @param _amount
	 * @return order
	 */
	public OrderDetail addProductToCart(CartDetail cart, int productId, int amount) {
		if (productId > 0 && amount > 0) {
			OrderDetail detail = checkProductIsExistInCart(cart, productId);
			// if not exist, create one
			if (detail == null) {
				Order order = createOrder(productId, amount);
				this.insertMapping(cart.getCart().getId(), order.getId());
				return createDetail(order);
			}// if exist, add amount in order
			else {
				Order order = detail.getOrder();
				int _amount = order.getAmount() + amount;
				order.setAmount(_amount);
				order.setCost(productService.getTotalCost(productId, _amount));
				orderService.updateOrder(order);
				detail.setOrder(order);
				detail.setInCart(true);
				return detail;
			}
		}
		return null;
	}

	/**
	 * check product is exist in shopping cart
	 * 
	 * @param cart
	 * @param prodcutId
	 * @return
	 */
	private OrderDetail checkProductIsExistInCart(CartDetail cart, int prodcutId) {
		List<OrderDetail> orders = cart.getOrders();
		if (orders != null && !orders.isEmpty()) {
			for (OrderDetail order : orders) {
				if (order.getProduct().getProductId() == prodcutId) {
					return order;
				}
			}
		}
		return null;
	}

	/**
	 * get all orders in shopping cart by userId
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderDetail> getAllOrders(int userId) {
		if (userId <= 0) {
			return Collections.emptyList();
		}
		List<Order> list = orderService.getAllOrdersByUserId(userId);
		List<OrderDetail> rtn = new ArrayList<OrderDetail>();
		for (Order order : list) {
			rtn.add(createDetail(order));
		}
		return rtn;
	}

	/**
	 * add product information for display
	 * 
	 * @param order
	 * @return
	 */
	private OrderDetail createDetail(Order order) {
		Product product = productService.getProductInfo(order.getProductid());
		OrderDetail detail = new OrderDetail();
		detail.setOrder(order);
		detail.setProduct(product);
		return detail;
	}

	/**
	 * insert an order
	 * 
	 * @param pId
	 * @param amount
	 * @return
	 */
	private Order createOrder(int pId, int amount) {
		Order order = new Order();
		order.setProductid(pId);
		order.setAmount(amount);
		order.setCost(productService.getTotalCost(pId, amount));
		order.setStatus(OrderStatus.Added.actualValue);
		Date currentDate = new Date();
		order.setCreatetime(currentDate);
		order.setLastupdatetime(currentDate);
		order = orderService.insertOrder(order);
		return order;
	}

	/**
	 * insert mapping
	 * 
	 * @param cartId
	 * @param oriderId
	 */
	private void insertMapping(int cartId, int oriderId) {
		CartOrderMapping mapping = new CartOrderMapping();
		mapping.setCartId(cartId);
		mapping.setOrderid(oriderId);
		cartOrderMappingMapper.insert(mapping);
	}

	public void removeOrderFromCart(int orderId) {
		orderService.deleteOrder(orderId);
		cartOrderMappingMapper.deleteByOrderId(orderId);
	}
}
