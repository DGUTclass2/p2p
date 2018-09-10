package service;

import java.sql.SQLException;
import java.util.List;

import bean.BookType;
import dao.BookTypeDao;
import dao.DatabaseDao;

public class BookTypeService {
	//获取所有的书籍类型
		public List<BookType> getAllBookType()
		{
			List<BookType> bookTypes=null;
			try{
				DatabaseDao databaseDao = new DatabaseDao();
				BookTypeDao bookTypeDao = new BookTypeDao();
				
				bookTypes=bookTypeDao.getAllBookType(databaseDao);
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bookTypes;
		}
}
