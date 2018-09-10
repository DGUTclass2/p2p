package tools;

public class Cart {
	private Integer bookId;
	private String bookName;
	private Double price;//价格
	private String imageUrl;//图片链接
	private Integer number;
	private Integer orderId;
	private String orderlistId;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
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
	
}
