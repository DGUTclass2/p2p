package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Manager;
import bean.User;
import tools.PageInformation;
import tools.Tool;

public class ManagerDao {
	// 管理员注册
	public void register(Manager manager, DatabaseDao databaseDao) throws SQLException {
		String sql = "insert into manager(managerId,password,e_mail) values('" + manager.getManagerId() + "','"
				+ manager.getPassword() + "','" + manager.getE_mail() + "')";

		databaseDao.update(sql);
	}

	// 管理员登录
	public int login(Manager manager, DatabaseDao databaseDao) throws SQLException {
		String sql = "select * from manager where managerId='" + manager.getManagerId() + "' and password='"
				+ manager.getPassword() + "'";
		databaseDao.query(sql);
		if (databaseDao.next()) {
			return 1;
		}
		return 0;
	}

	// 查询管理员是否存在,1为存在，0为不存在
	public int hasManager(Manager manager, DatabaseDao databaseDao) throws SQLException {
		String sql = "select * from manager where managerId='" + manager.getManagerId() + "'";
		databaseDao.query(sql);
		if (databaseDao.next()) {
			return 1;
		}
		return 0;
	}

	//返回某个管理员的信息
	public Manager findManager(String managerId,DatabaseDao databaseDao) throws SQLException{
		Manager manager=new Manager();
		String sql="select * from manager where managerId='"+managerId+"'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			manager.setManagerId(managerId);
			manager.setE_mail(databaseDao.getString("e_mail"));
			manager.setLimits(databaseDao.getString("limits"));
			return manager;
		}
		return null;
	}
	
	// 输出一管理员列表
	public List<Manager> getOnePage(PageInformation pageinformation, DatabaseDao databaseDao) throws SQLException {
		List<Manager> managers=new ArrayList<Manager>();
		String sqlCount = Tool.getSql(pageinformation, "count");
		Integer allRecordCount = databaseDao.getCount(sqlCount);//获取记录总数
		Tool.setPageInformation(allRecordCount, pageinformation);

		String sqlSelect = Tool.getSql(pageinformation, "select");
		System.out.println(sqlSelect);
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			Manager manager=new Manager();
			manager.setManagerId(databaseDao.getString("managerId"));
			manager.setE_mail(databaseDao.getString("e_mail"));
			manager.setLimits(databaseDao.getString("limits"));
			managers.add(manager);
		}
		return managers;
	}
}
