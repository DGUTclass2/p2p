package bean;

import java.sql.Timestamp;

public class Comment {
	private Integer commentId;
	private Integer bookId;
	private String userId;
	private String content;
	private Timestamp commentTime;
	private Integer praise;//点赞数
	private Integer stair;//评论楼层号
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getbookId() {
		return bookId;
	}
	public void setbookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Integer getStair() {
		return stair;
	}
	public void setStair(Integer stair) {
		this.stair = stair;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
}
