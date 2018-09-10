package bean;

import java.sql.Timestamp;

public class Orderlist {
	private String orderlistId;
	private double totalPrice;
	private String isPay;
	private Timestamp orderTime;
	private String address;
	private String userId;
	
	public String getOrderlistId() {
		return orderlistId;
	}
	public void setOrderlistId(String orderlistId) {
		this.orderlistId = orderlistId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
