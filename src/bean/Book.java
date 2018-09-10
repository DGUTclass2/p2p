package bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private String bookType;//书籍类型
	private String introduction;
	private Double price;//价格
	private String imageUrl;//图片链接
	private Integer inventory;//库存
	private Integer sales;//销量
	private LocalDateTime bookTime;//书本发行时间
	private Timestamp publishTime;//书籍信息上传时间
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public LocalDateTime getBookTime() {
		return bookTime;
	}
	public void setBookTime(LocalDateTime bookTime) {
		this.bookTime = bookTime;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
}
