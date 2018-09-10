package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bean.BookType;
import dao.DatabaseDao;
import service.BookService;
import service.BookTypeService;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化数据库参数
		DatabaseDao.drv=this.getServletContext().getInitParameter("drv");
		DatabaseDao.url=this.getServletContext().getInitParameter("url");
		DatabaseDao.usr=this.getServletContext().getInitParameter("usr");
		DatabaseDao.pwd=this.getServletContext().getInitParameter("pwd");
		
		
		//读取数据库中的bookType数据
		BookTypeService bookTypeService=new BookTypeService();
		List<BookType> bookTypes=bookTypeService.getAllBookType();
		this.getServletContext().setAttribute("bookTypes", bookTypes);//设为全局变量
	}
	
	
	

}
