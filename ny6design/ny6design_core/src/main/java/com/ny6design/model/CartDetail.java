package com.ny6design.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ny6design.service.calc.Calculator;
import com.ny6design.service.calc.DiscountCalculator;
import com.ny6design.service.calc.ExtraCalculator;
import com.ny6design.service.calc.OrderCalculator;
import com.ny6design.service.calc.ShipCalculator;

/**
 * display whole information of cart
 * 
 * @author kevin
 * 
 */
public class CartDetail {
	private ShoppingCart cart;
	private List<OrderDetail> orders;
	private ShipMethod shipMethod;
	private PayMethod payMethod;
	private Discount discount;
	private BigDecimal subtotal;
	private BigDecimal total;
	private String notice;
	// whether initialize the orders
	private boolean hasInited = false;

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public List<OrderDetail> getOrders() {
		return orders == null ? new ArrayList<OrderDetail>() : orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public ShipMethod getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(ShipMethod shipMethod) {
		this.shipMethod = shipMethod;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal calcSubTotal() {
		Calculator orderCalculator = new OrderCalculator(this.getOrders());
		return orderCalculator.calc();
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public PayMethod getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public boolean isHasInited() {
		return hasInited;
	}

	public void setHasInited(boolean hasInited) {
		this.hasInited = hasInited;
	}

	public BigDecimal calcTotal() {
		Calculator orderCalculator = new OrderCalculator(this.getOrders());
		// for test
		discount = new Discount();
		discount.setDiscount(BigDecimal.ONE);
		// end
		ExtraCalculator discoutCalculator = new DiscountCalculator(orderCalculator, discount);
		ExtraCalculator shipExtraCalculator = new ShipCalculator(discoutCalculator, shipMethod);
		return shipExtraCalculator.calc();
	}

}
