package bean;

public class Order {
	private Integer orderId;
	private String orderlistId;
	private Integer bookId;
	private double price;
	private Integer number;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderlistId() {
		return orderlistId;
	}
	public void setOrderlistId(String orderlistId) {
		this.orderlistId = orderlistId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
