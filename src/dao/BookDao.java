package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bean.Book;
import tools.PageInformation;
import tools.Tool;;

public class BookDao {
	//将书籍信息添加到数据库中
	public void add(Book book,DatabaseDao databaseDao) throws SQLException{
		String sql="insert into book(bookName,author,price,inventory,introduction,bookType,imageUrl,bookTime) values('"+
				book.getBookName()+"','"+
				book.getAuthor()+"','"+
				book.getPrice()+"','"+
				book.getInventory()+"','"+
				book.getIntroduction()+"','"+
				book.getBookType()+"','"+
				book.getImageUrl()+"','"+
				book.getBookTime()+"')";
	
		databaseDao.update(sql);
	}
	
	//根据书名获取某本书的主键ID
	public Integer getBookId(String BookName,DatabaseDao databaseDao) throws SQLException{
		String sql="select bookId from book where bookName='"+BookName+"'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			return databaseDao.getInt("bookId");
		}else{
			return -1;//找不到该书名
		}
	}
	
	//根据主键ID获取某本书的信息
	public Book getBookById(String bookId,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from book where bookId='"+bookId+"'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			Book book=new Book();
			book.setBookId(databaseDao.getInt("bookId"));
			book.setBookName(databaseDao.getString("bookName"));
			book.setAuthor(databaseDao.getString("author"));
			book.setPrice(databaseDao.getDouble("price"));
			book.setInventory(databaseDao.getInt("inventory"));
			book.setSales(databaseDao.getInt("sales"));
			book.setIntroduction(databaseDao.getString("introduction"));
			book.setBookType(databaseDao.getString("bookType"));
			book.setImageUrl(databaseDao.getString("imageUrl"));
			book.setBookTime(databaseDao.getLocalDateTime("bookTime"));
			book.setPublishTime(databaseDao.getTimestamp("publishTime"));
			return book;
		}else{
			return null;//找不到该书信息
		}
	}
	
	//判断书名是否已存在
	public Integer hasBookName(String BookName,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from book where bookName='"+BookName+"'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			return 1;
		}else{
			return 0;//找不到该书名
		}
	}
	
	//修改数据库中的书籍信息
	public Integer update(Book book,DatabaseDao databaseDao) throws SQLException{
		String sql="update book set bookName='"+book.getBookName()+
				"',author='"+book.getAuthor()+
				"',price='"+book.getPrice()+
				"',inventory='"+book.getInventory()+
				"',sales='"+book.getSales()+
				"',introduction='"+book.getIntroduction()+
				"',bookType='"+book.getBookType()+
				"',imageUrl='"+book.getImageUrl()+
				"',bookTime='"+book.getBookTime()+"' where bookId='"+book.getBookId()+"'";
	
		return databaseDao.update(sql);
	}
	
	//从数据库中获取销量信息
	public Integer getSalesById(String bookId,DatabaseDao databaseDao) throws SQLException{
		String sql="select sales from book where bookId='"+bookId+"'";
		databaseDao.query(sql);
		return databaseDao.getInt("sales");
	}
	
	// 删除多个书本信息,ids为需要删除的书本主键集合，用逗号隔开
	public Integer deletes(String ids, DatabaseDao databaseDao) throws SQLException, Exception {
		return databaseDao.deletes("book", ids, databaseDao);
	}

	// 获取一页书籍信息
	public List<Book> getOnePage(PageInformation pageInformation, DatabaseDao databaseDao) throws SQLException {
		List<Book> bookes = new ArrayList<Book>();
		String sqlCount = Tool.getSql(pageInformation, "count");//获取查询语句
		Integer allRecordCount = databaseDao.getCount(sqlCount);// 符合条件的总记录数
		Tool.setPageInformation(allRecordCount, pageInformation);// 更新pageInformation的总页数等

		String sqlSelect = Tool.getSql(pageInformation, "select");
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			Book book = new Book();
			book.setBookId(databaseDao.getInt("bookId"));
			book.setBookName(databaseDao.getString("bookName"));
			book.setAuthor(databaseDao.getString("author"));
			book.setPrice(databaseDao.getDouble("price"));
			book.setInventory(databaseDao.getInt("inventory"));
			book.setSales(databaseDao.getInt("sales"));
			book.setIntroduction(databaseDao.getString("introduction"));
			book.setBookType(databaseDao.getString("bookType"));
			book.setImageUrl(databaseDao.getString("imageUrl"));
			book.setBookTime(databaseDao.getLocalDateTime("bookTime"));
			book.setPublishTime(databaseDao.getTimestamp("publishTime"));
			bookes.add(book);
		}
		return bookes;
	}
	
	public List<Book> getTypeBook(String bookType,PageInformation pageInformation, DatabaseDao databaseDao) throws SQLException{
		List<Book> bookes = new ArrayList<Book>();
		pageInformation.setSearSql("bookType='"+bookType+"'");//设置查询条件，筛选出某种类型的书籍
		String sqlCount = Tool.getSql(pageInformation, "count");//获取查询语句
		Integer allRecordCount = databaseDao.getCount(sqlCount);// 符合条件的总记录数
		Tool.setPageInformation(allRecordCount, pageInformation);// 更新pageInformation的总页数等
		
		String sqlSelect = Tool.getSql(pageInformation, "select");
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			Book book = new Book();
			book.setBookId(databaseDao.getInt("bookId"));
			book.setBookName(databaseDao.getString("bookName"));
			book.setAuthor(databaseDao.getString("author"));
			book.setPrice(databaseDao.getDouble("price"));
			book.setInventory(databaseDao.getInt("inventory"));
			book.setSales(databaseDao.getInt("sales"));
			book.setIntroduction(databaseDao.getString("introduction"));
			book.setBookType(databaseDao.getString("bookType"));
			book.setImageUrl(databaseDao.getString("imageUrl"));
			book.setBookTime(databaseDao.getLocalDateTime("bookTime"));
			book.setPublishTime(databaseDao.getTimestamp("publishTime"));
			bookes.add(book);
		}
		return bookes;
	}
	
	//判断购买数量是否大于库存
	public Integer canBuy(Integer bookId,Integer number,DatabaseDao databaseDao) throws SQLException{
		String sql="select inventory from book where bookId='"+bookId+"'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			Integer inventory=databaseDao.getInt("inventory");
			if(inventory>=number)	return 1;//库存大于购买数量
			else	return 0;//库存小于购买数量
		}else return -1;//查无此书
	}
	
	//更新书籍的销量和库存信息
	public Integer updateSalesInventory(Integer bookId,Integer number,DatabaseDao databaseDao) throws SQLException{
		String sql="update book set sales=sales+"+number+" and inventory=inventory-"+number+"where bookId='"+bookId+"'";
		return databaseDao.update(sql);
	}
	
	//返回查询书籍的结果
	public List<Book> getSearch(String search,PageInformation pageInformation,DatabaseDao databaseDao,HttpServletRequest request) throws SQLException{
		List<Book> bookes = new ArrayList<Book>();
		String searchSql=tools.SearchTool.bookName(request);
		pageInformation.setSearSql(searchSql);
		String sqlCount = Tool.getSql(pageInformation, "count");//获取查询语句
		Integer allRecordCount = databaseDao.getCount(sqlCount);// 符合条件的总记录数
		Tool.setPageInformation(allRecordCount, pageInformation);// 更新pageInformation的总页数等
		
		String sqlSelect = Tool.getSql(pageInformation, "select");
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			Book book = new Book();
			book.setBookId(databaseDao.getInt("bookId"));
			book.setBookName(databaseDao.getString("bookName"));
			book.setAuthor(databaseDao.getString("author"));
			book.setPrice(databaseDao.getDouble("price"));
			book.setInventory(databaseDao.getInt("inventory"));
			book.setSales(databaseDao.getInt("sales"));
			book.setIntroduction(databaseDao.getString("introduction"));
			book.setBookType(databaseDao.getString("bookType"));
			book.setImageUrl(databaseDao.getString("imageUrl"));
			book.setBookTime(databaseDao.getLocalDateTime("bookTime"));
			book.setPublishTime(databaseDao.getTimestamp("publishTime"));
			bookes.add(book);
		}
		return bookes;
	}
}
