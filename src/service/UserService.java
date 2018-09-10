package service;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.User;
import dao.DatabaseDao;
import dao.UserDao;
import tools.FileTool;
import tools.PageInformation;

public class UserService {
	// 将用户基本信息存入数据库中
	public int register1(User user) {
		int result = -1; // 数据库操作失败
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();

			if (userDao.hasUser(user, databaseDao) == 0) {// 没有同名用户，可以注册
				userDao.register1(user, databaseDao);
				return 1;
			} else {
				return 0; // 注册失败，用户已存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 将用户个人信息存入数据库中
	public Integer register2(User user) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();

			userDao.register2(user, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	// 将用户信息包装到一个类中，并将头像图片上传到服务器
	public User getUserById(HttpServletRequest request, String userId) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user = new User();
		UserDao userDao = new UserDao();

		try {
			DatabaseDao databaseDao = new DatabaseDao();
			user.setUserId(userId);
			databaseDao.query("select * from user where userId='" + userId + "'");
			while (databaseDao.next()) {
				user.setImageUrl(databaseDao.getString("imageUrl"));
				user.setNickName(databaseDao.getString("nickName"));
				user.setIntroduction(databaseDao.getString("introduction"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					if ("nickName".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							user.setNickName(item.getString("UTF-8"));
					} else if ("introduction".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							user.setIntroduction(item.getString("UTF-8"));
					} else if ("sex".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							user.setSex(item.getString("UTF-8"));
					} else if ("address".equals(name)) {
						if (!item.getString("UTF-8").isEmpty())
							user.setAddress(item.getString("UTF-8"));
					}
				} else if (!item.getName().equals("")) {
					String randomFileName = FileTool.getRandomFileNameByCurrentTime(item.getName());
					String path = "/upload/images/Portrait/" + randomFileName;
					path = request.getServletContext().getRealPath(path);// 获取绝对路径
					File file = new File(path);
					item.write(file);
					item.delete();
					user.setImageUrl("/bookStore/upload/images/Portrait/" + randomFileName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// 用户登录功能
	public Integer login(User user) {
		int result = -1;// 数据库操作失败
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();
			return userDao.login(user, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 根据userId从数据库中取出用户信息
	public User findUser(String userId) {
		User user = null;
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();
			user = userDao.findUser(userId, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// 显示一页用户列表功能
	public List<User> getOnePage(PageInformation pageInformation) {
		List<User> users = new ArrayList<User>();
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();
			users = userDao.getOnePage(pageInformation, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	// 修改密码
	public Integer changePassword(User user, String newPassword) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			UserDao userDao = new UserDao();
			if (userDao.hasUser(user, databaseDao) == 1) {
				if (databaseDao.updateAStringFieldById("user", user.getUserId(), "password", newPassword) > 0)
					return 1;// 修改成功
				else
					return 0;// 用户存在，但修改失败，可能是密码问题
			} else
				return -1;// 用户不存在
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;// 数据库问题
		} catch (Exception e) {
			e.printStackTrace();
			return -3;// 其它异常
		}
	}
	
	//获取用户地址
		public String returnAddress(String userId){
			try{
				DatabaseDao databaseDao = new DatabaseDao();
				UserDao userDao = new UserDao();
				return userDao.returnAddress(userId, databaseDao);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
