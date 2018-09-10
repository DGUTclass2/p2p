package tools;

public class Message {
	private int result;
	private String message;//提示信息
	private String redirectUrl;//跳转网址
	private double redirectTime;//调整间隔时间，单位秒
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public double getRedirectTime() {
		return redirectTime;
	}
	public void setRedirectTime(double redirectTime) {
		this.redirectTime = redirectTime;
	}
}
