package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bean.Book;
import dao.DatabaseDao;
import tools.PageInformation;
import dao.BookDao;

public class BookService {
	// 将书籍信息存入数据库中
	public int add(Book book) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao bookDao = new BookDao();

			if (bookDao.hasBookName(book.getBookName(), databaseDao) == 0) {
				bookDao.add(book, databaseDao);
				return 1;
			} else
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;// 数据库操作失败
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//根据bookId获取某本书籍的信息
	public Book getBookById(String bookId){
		Book book=new Book();
		try{
			DatabaseDao databaseDao=new DatabaseDao();
			BookDao bookDao=new BookDao();
			book=bookDao.getBookById(bookId, databaseDao);
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// 修改书籍信息
	public Integer update(Book book) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao bookDao = new BookDao();
			
			return bookDao.update(book, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

	// 获取一页的书籍信息
	public List<Book> getOnePage(PageInformation pageInformation) {
		List<Book> bookes = new ArrayList<Book>();
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao BookDao = new BookDao();
			
			bookes = BookDao.getOnePage(pageInformation, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookes;
	}

	// 删除多条记录，并返回已删除的新闻信息
	public List<Book> deletes(PageInformation pageInformation) {
		List<Book> bookes = null;
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao BookDao = new BookDao();
			
			BookDao.deletes(pageInformation.getIds(), databaseDao);
			pageInformation.setIds(null);
			bookes = BookDao.getOnePage(pageInformation, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookes;
	}
	
	// 获取一页的书籍信息
		public List<Book> getTypeBook(String bookType,PageInformation pageInformation) {
			List<Book> bookes = new ArrayList<Book>();
			try {
				DatabaseDao databaseDao = new DatabaseDao();
				BookDao bookDao = new BookDao();
				
				bookes = bookDao.getTypeBook(bookType,pageInformation, databaseDao);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bookes;
		}
		
	//购买书籍时更新库存
	public Integer updateInventory(Integer bookId,Integer number){
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao bookDao = new BookDao();
			
			if(bookDao.canBuy(bookId, number, databaseDao)==1){
				//更新书本的售量和库存
				bookDao.updateSalesInventory(bookId, number, databaseDao);
			}else if(bookDao.canBuy(bookId, number, databaseDao)==1){
				return 0;//库存不足
			}else{
				return -1;//查无此书
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;//数据库操作失败
	}
	
	//返回查询书籍的结果
	public List<Book> getSearch(String search,PageInformation pageInformation,HttpServletRequest request) {
		List<Book> bookes = new ArrayList<Book>();
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			BookDao bookDao = new BookDao();
			
			bookes = bookDao.getSearch(search, pageInformation, databaseDao, request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookes;
	}
}
