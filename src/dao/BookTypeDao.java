package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BookType;

public class BookTypeDao {
	//获取所有的书籍类型
		public List<BookType> getAllBookType(DatabaseDao databaseDao) throws SQLException{
			String sql="select * from booktype";
			List<BookType> bookTypes=new ArrayList<BookType>();
			databaseDao.query(sql);
			while(databaseDao.next()){
				BookType bookType=new BookType();
				bookType.setBookTypeId(databaseDao.getInt("bookTypeId"));
				bookType.setBookType(databaseDao.getString("bookType"));
				bookTypes.add(bookType);
			}
			return bookTypes;
		}
}
