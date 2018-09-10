package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Manager;
import dao.DatabaseDao;
import dao.ManagerDao;
import tools.PageInformation;

public class ManagerService {
	//注册管理员账号
	public int register(Manager manager){
		int result=-1;// 数据库操作失败
		try{
			DatabaseDao databaseDao = new DatabaseDao();
			ManagerDao managerDao=new ManagerDao();
			
			if(managerDao.hasManager(manager, databaseDao)==0){
				managerDao.register(manager, databaseDao);
				return 1;
			}else{
				return 0; // 注册失败，用户已存在
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//管理员登录功能
	public Integer login(Manager manager){
		int result = -1;// 数据库操作失败
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			ManagerDao managerDao=new ManagerDao();
			
			return managerDao.login(manager, databaseDao);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//根据managerId从数据库中取出管理员信息
	public Manager findManager(String managerId){
		Manager manager=null;
		try{
			DatabaseDao databaseDao = new DatabaseDao();
			ManagerDao managerDao=new ManagerDao();
			manager=managerDao.findManager(managerId, databaseDao);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return manager;
	}
	
	//显示一页管理员列表功能
	public List<Manager> getOnePage(PageInformation pageinformation) {
		List<Manager> managers=new ArrayList<Manager>();
		try{
			DatabaseDao databaseDao = new DatabaseDao();
			ManagerDao managerDao=new ManagerDao();
			managers=managerDao.getOnePage(pageinformation, databaseDao);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return managers;
	}
}
