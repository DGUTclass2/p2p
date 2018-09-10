package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatabaseDao {
	public static String drv; // 数据库类型
	public static String url; // 数据库网址
	public static String usr; // 数据库用户名
	public static String pwd; // 数据库密码

	Connection connect = null;
	Statement stmt = null;
	ResultSet rs = null;

	// DatabaseDao构造方法
	public DatabaseDao() throws Exception {
		Class.forName(drv);
		connect = DriverManager.getConnection(url, usr, pwd);
		stmt = connect.createStatement();
	}

	// 查询语句
	public void query(String sql) throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	// 更新语句
	public int update(String sql) throws SQLException {
		return stmt.executeUpdate(sql);
	}

	// 获取下一个查询结果
	public boolean next() throws SQLException {
		return rs.next();
	}

	// 获取字符串类型数据
	public String getString(String field) throws SQLException {
		return rs.getString(field);
	}

	// 获取int类型数据
	public Integer getInt(String field) throws SQLException {
		return rs.getInt(field);
	}

	// 获取Timestamp类型数据
	public Timestamp getTimestamp(String field) throws SQLException {
		return rs.getTimestamp(field);
	}

	// 获取float类型数据
	public Float getFloat(String field) throws SQLException {
		return rs.getFloat(field);
	}

	// 获取double类型数据
	public Double getDouble(String field) throws SQLException {
		return rs.getDouble(field);
	}

	// 设置自动提交事务
	public void setAutoCommit(boolean f) throws SQLException {
		connect.setAutoCommit(f);
	}

	// 提交事物
	public void commit() throws SQLException {
		connect.commit();
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	// 根据表、字段，获取该字段上所有非重复值
	public ArrayList<String> getStringFieldValueByTableAndField(String tableName, String fieldName)
			throws SQLException {
		ArrayList<String> FieldValueList = new ArrayList<String>();
		query("select distinct" + fieldName + "from" + tableName);

		while (next()) {
			FieldValueList.add(getString(fieldName));
		}

		return FieldValueList;
	}

	// 获取符合条件的语句的数量
	public int getCount(String sql) throws SQLException {
		query(sql);
		while (next()) {// while考虑分组的情况
			return this.getRs().getInt("count1");
		}

		return 0;
	}

	// 获取表的字段名称，并保存到数组中
	public ArrayList<String> FieldList(String tableName) throws SQLException {
		ArrayList<String> fieldList = new ArrayList<String>();
		String sql = "select * from " + tableName + "limit 1";// limit
																// 1表示查询结果只包含一条记录
		query(sql);
		// ResultSetMetaData记录了表的元数据，如字段名称，字段类型等
		ResultSetMetaData fields = rs.getMetaData();

		for (int i = 1; i <= fields.getColumnCount(); i++) {
			fieldList.add(fields.getColumnName(i));
		}

		return fieldList;
	}

	public void getById(String tableName, Integer id) throws SQLException {
		tableName = tableName.toLowerCase();
		String sql = "select * from " + tableName + " where " + tableName + "Id=" + id.toString();
		query(sql);
	}

	public boolean hasId(String tableName, Integer id) throws SQLException {
		tableName = tableName.toLowerCase();
		String sql = "select * from " + tableName + " where " + tableName + "Id=" + id.toString();
		query(sql);
		while (next()) {
			return true;
		}
		return false;
	}

	public LocalDateTime getLocalDateTime(String field) throws SQLException {// 获取日期时间类型字段的值
		return rs.getTimestamp(field).toLocalDateTime();
	}

	// 删除多个用户
	public Integer deletes(String tableName, String ids, DatabaseDao databaseDao) throws SQLException {// 查询失败返回-1
		if (ids != null && ids.length() > 0) {
			String sql = "delete from " + tableName + " where " + tableName.toLowerCase() + "Id in (" + ids + ")";
			return databaseDao.update(sql);
		} else
			return -1;
	}
	
	//修改某个表，某条记录（id）的某个字符型字段的值
	public Integer updateAStringFieldById(String tableName,String id,String fieldName,String fieldValue)throws SQLException{
		String sql="update "+tableName+" set "+fieldName+"='"+fieldValue+"' where "+
				tableName.toLowerCase()+"Id='"+id+"'";
		return update(sql);
	}
}
