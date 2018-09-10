package tools;

import java.io.File;
import java.net.HttpRetryException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Book;
import bean.Order;
import bean.Orderlist;
import dao.DatabaseDao;
import dao.BookDao;

public class ServletTool {
	// 从表单中获取数据返回一个Book对象
	public static Book getBookById(HttpServletRequest request, String bookId) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Book book = new Book();
		BookDao bookDao = new BookDao();
		
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			if (bookId != null) {
				book.setBookId(Integer.parseInt(bookId));
				databaseDao.query("select * from book where bookId='" + bookId + "'");
				while (databaseDao.next()) {
					book.setBookId(databaseDao.getInt("bookId"));
					book.setAuthor(databaseDao.getString("author"));
					book.setPrice(databaseDao.getDouble("price"));
					book.setInventory(databaseDao.getInt("inventory"));
					book.setSales(databaseDao.getInt("sales"));
					book.setIntroduction(databaseDao.getString("introduction"));
					book.setBookType(databaseDao.getString("bookType"));
					book.setImageUrl(databaseDao.getString("imageUrl"));
					book.setBookTime(databaseDao.getLocalDateTime("bookTime"));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					if ("author".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setAuthor(item.getString("UTF-8"));
					} else if ("bookType".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setBookType(item.getString("UTF-8"));
					}else if ("bookId".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setBookId(Integer.parseInt(item.getString("UTF-8")));
					}  else if ("bookName".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setBookName(item.getString("UTF-8"));
					} else if ("price".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setPrice(Double.parseDouble(item.getString("UTF-8")));
					} else if ("inventory".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setInventory(Integer.parseInt(item.getString("UTF-8")));
					} else if ("editorValue".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							book.setIntroduction(item.getString("UTF-8"));
					} else if ("bookTime".equals(name)) {
						if (!item.getString("UTF-8").isEmpty()) {
							String time = item.getString("UTF-8");
							// DateTimeFormatter用于将字符串解析成LocalDateTime类型的对象，或者反之
							LocalDateTime localDateTime = LocalDateTime.parse(time,
									DateTimeFormatter.ISO_LOCAL_DATE_TIME);
							book.setBookTime(localDateTime);
						}
					}
				} else if (!item.getName().equals("")) {
					String randomFileName = FileTool.getRandomFileNameByCurrentTime(item.getName());
					String path = "/upload/images/book/" + randomFileName;
					path = request.getServletContext().getRealPath(path);// 获取绝对路径
					File file = new File(path);
					item.write(file);
					item.delete();
					book.setImageUrl("/bookStore/upload/images/book/" + randomFileName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//初始化并返回一个Orderlist对象
	public static Orderlist OrderlistInit(HttpServletRequest request){
		Orderlist orderlist=new Orderlist();
		String orderlistId=Tool.getRandomString(14);//获取随机Id号
		orderlist.setOrderlistId(orderlistId);
		orderlist.setUserId((String)request.getSession().getAttribute("userId"));
		orderlist.setIsPay("否");
		orderlist.setTotalPrice(0);
		return orderlist;
	}
	
	//从表单中获取数据并返回一个Order对象
	public static Order OrderInit(HttpServletRequest request,String orderlistId,double price){
		Order order=new Order();
		String number=request.getParameter("number");//获取购买数量
		if(number!=null)
			order.setNumber(Integer.parseInt(number));
		else
			order.setNumber(1);
		order.setOrderlistId(orderlistId);
		order.setBookId(Integer.parseInt(request.getParameter("bookId")));
		order.setPrice(price);
		return order;
	}
	
	//计算订单总价
	public static double sumPrice (List<Order> orders){
		double total=0;
		for (Order item : orders){
			total+=item.getPrice();
		}
		return total;
	}
	
	
}
