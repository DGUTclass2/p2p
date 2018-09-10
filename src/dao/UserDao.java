package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import tools.PageInformation;
import tools.Tool;

public class UserDao {
	// 将用户基本信息存入数据库中
	public void register1(User user, DatabaseDao databaseDao) throws SQLException {
		String sql = "insert into user(userId,password,e_mail) values('" + user.getUserId() + "','" + user.getPassword()
				+ "','" + user.getE_mail() + "')";

		databaseDao.update(sql);
	}

	// 将用户个人信息存入数据库中
	public void register2(User user, DatabaseDao databaseDao) throws SQLException {
		String sql = "update user set nickName='" + user.getNickName() + "',sex='" + user.getSex() + "',imageUrl='"
				+ user.getImageUrl() + "',introduction='" + user.getIntroduction() + "',address='" + user.getAddress()
				+ "' where userId='" + user.getUserId() + "'";

		databaseDao.update(sql);
	}

	// 查询用户是否存在,1为存在，0为不存在
	public int hasUser(User user, DatabaseDao databaseDao) throws SQLException {
		String sql = "select * from user where userId='" + user.getUserId() + "'";
		databaseDao.query(sql);
		if (databaseDao.next()) {
			return 1;
		}
		return 0;
	}

	// 判断用户是否可以登录
	public int login(User user, DatabaseDao databaseDao) throws SQLException {
		String sql = "select * from user where userId='" + user.getUserId() + "' and passWord='" + user.getPassword()
				+ "'";
		databaseDao.query(sql);
		if (databaseDao.next()) {
			return 1;
		}
		return 0;
	}

	// 返回某个用户信息
	public User findUser(String userId, DatabaseDao databaseDao) throws SQLException {
		User user = new User();
		String sql = "select * from user where userId='" + userId + "'";
		databaseDao.query(sql);
		if (databaseDao.next()) {
			user.setUserId(databaseDao.getString("userId"));
			user.setE_mail(databaseDao.getString("e_mail"));
			user.setNickName(databaseDao.getString("nickName"));
			user.setSex(databaseDao.getString("sex"));
			user.setImageUrl(databaseDao.getString("imageUrl"));
			user.setIntroduction(databaseDao.getString("introduction"));
			user.setAddress(databaseDao.getString("address"));
			return user;
		} else {
			return null;
		}
	}

	// 输出一页用户列表
	public List<User> getOnePage(PageInformation pageinformation, DatabaseDao databaseDao) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sqlCount = Tool.getSql(pageinformation, "count");
		Integer allRecordCount = databaseDao.getCount(sqlCount);
		Tool.setPageInformation(allRecordCount, pageinformation);

		String sqlSelect = Tool.getSql(pageinformation, "select");
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			User user = new User();
			user.setUserId(databaseDao.getString("userId"));
			user.setE_mail(databaseDao.getString("e_mail"));
			user.setNickName(databaseDao.getString("nickName"));
			user.setSex(databaseDao.getString("sex"));
			user.setImageUrl(databaseDao.getString("imageUrl"));
			user.setIntroduction(databaseDao.getString("introduction"));
			user.setAddress(databaseDao.getString("address"));
			users.add(user);
		}
		return users;
	}
	
	//获取用户地址
	public String returnAddress(String userId, DatabaseDao databaseDao) throws SQLException {
		String sql="select address from user where userId='"+userId+"'";
		databaseDao.query(sql);
		if(databaseDao.next())
			return databaseDao.getString("address");
		else return null;
	}
}
