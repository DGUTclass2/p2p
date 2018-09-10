package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;
import service.BookService;
import tools.Message;
import tools.PageInformation;
import tools.ServletTool;
import tools.Tool;

public class bookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		BookService bookService=new BookService();
		Message message=new Message();
		
		if(type.equals("add")){
			Book book=ServletTool.getBookById(request, null);
			int result=bookService.add(book);
			
			message.setResult(result);
			if(result==1){
				message.setMessage("书籍信息添加完成！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}else if(result==0){
				message.setMessage("书籍信息添加失败！请修改书名信息！");
				message.setRedirectUrl("/bookStore/book/addBook.jsp");
			}else{
				message.setMessage("书籍信息添加失败！请联系管理员！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("showAll")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			List<Book> bookes=bookService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("bookes", bookes);
			getServletContext().getRequestDispatcher("/book/bookListShow.jsp").forward(request,response);
		}else if(type.equals("show")){//查看单个书籍信息
			String bId=request.getParameter("bookId");
			Book book=new Book();
			book=bookService.getBookById(bId);//获取书籍信息
			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/book/bookShow.jsp").forward(request,response);
		}else if(type.equals("edit")){
			String bId=request.getParameter("bookId");
			Book book=new Book();
			book=bookService.getBookById(bId);//获取书籍信息
			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/book/bookEdit.jsp").forward(request,response);
		}else if(type.equals("update")){
			String bookId=request.getParameter("bookId");
			Book book=ServletTool.getBookById(request, bookId);
			int result=bookService.update(book);
			
			message.setResult(result);
			if(result==1){
				message.setMessage("书籍信息修改完成！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}else if(result==0){
				message.setMessage("书籍信息修改失败！请修改书名信息！");
				message.setRedirectUrl("/bookStore/book/bookEdit.jsp");
			}else{
				message.setMessage("书籍信息修改失败！请联系管理员！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("delete")){
			String bookId=request .getParameter("bookId");
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			pageInformation.setIds(bookId);
			bookService.deletes(pageInformation);
			message.setMessage("书籍信息删除成功！");
			message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("showAllGoods")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			pageInformation.setPageSize(5);//设置一页可以显示的书本数目
			List<Book> bookes=bookService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("bookes", bookes);
			getServletContext().getRequestDispatcher("/shop/goodsShow.jsp").forward(request,response);
		}else if(type.equals("showGoods")){//显示商品详情
			String bookId=request.getParameter("bookId");
			Book book=bookService.getBookById(bookId);//获取书籍信息
			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/shop/buyBook.jsp").forward(request,response);
		}else if(type.equals("homepageTypes")){//显示主页
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			pageInformation.setPageSize(5);//设置一页可以显示的书本数目
			List<Book> bookes=bookService.getOnePage(pageInformation);
			request.setAttribute("bookes", bookes);
			getServletContext().getRequestDispatcher("/index2.jsp").include(request, response);
		}else if(type.equals("getTypeBook")){//获取某类型的书籍
			String bookType=request.getParameter("bookType");
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			pageInformation.setPageSize(5);//设置一页可以显示的书本数目
			List<Book> bookes=bookService.getTypeBook(bookType, pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("bookes", bookes);
			getServletContext().getRequestDispatcher("/shop/goodsShow.jsp").forward(request,response);
		}else if(type.equals("search")){
			String bookName=request.getParameter("bookName");
			PageInformation pageInformation=new PageInformation();
			Tool.getPgaeInformation("book", request, pageInformation);//初始化PageInformation对象，并设置表名
			pageInformation.setPageSize(5);//设置一页可以显示的书本数目
			List<Book> bookes=bookService.getSearch(bookName, pageInformation, request);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("bookes", bookes);
			getServletContext().getRequestDispatcher("/shop/goodsShow.jsp").forward(request,response);
		}
		
	}

}
