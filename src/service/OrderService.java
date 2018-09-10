package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import bean.Orderlist;
import dao.DatabaseDao;
import dao.OrderDao;

public class OrderService {
	// 将订单元素信息存入数据库中
	public Integer addOrder(Order order) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			OrderDao orderDao = new OrderDao();
			return orderDao.addOrder(order, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 数据库操作失败
	}

	// 将订单信息存入数据库中
	public Integer addOrderlist(Orderlist orderlist) {
		try {
			DatabaseDao databaseDao = new DatabaseDao();
			OrderDao orderDao = new OrderDao();
			return orderDao.addOrderlist(orderlist, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 数据库操作失败
	}

	// 查询订单元素是否存在
	public Integer hasOrder(String orderlistId, Integer bookId, String userId) {
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			return orderDao.hasOrder(orderlistId, bookId, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 查询未支付的订单
	public Integer hasNoPayOrderlist(String userId) {
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			return orderDao.hasNoPayOrderlist(userId, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 返回一个未支付订单
	public Orderlist findOrderlistByUserId(String userId) {
		Orderlist orderlist = null;
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			orderlist = orderDao.findOrderlistByUserId(userId, databaseDao);
			return orderlist;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询是否有同类订单元素
	public Integer hasSameOrder(String orderlistId, String bookId) {
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			return orderDao.hasSameOrder(orderlistId, bookId, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 数据库操作失败
	}

	// 同类订单购买数更新
	public Integer updateOrderNumber(String orderlistId, String bookId, String number) {
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			return orderDao.updateOrderNumber(orderlistId, bookId, number, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 数据库操作失败
	}

	// 返回一个订单组的所有订单
	public List<Order> findOrdersByOrderlistId(String orderlistId) {
		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			List<Order> orders = orderDao.findOrdersByOrderlistId(orderlistId, databaseDao);
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;// 数据库操作失败
	}

	// 同类订单购买数更新
	public Integer updateOrderlist(String orderlistId, Double price) {

		try {
			OrderDao orderDao = new OrderDao();
			DatabaseDao databaseDao = new DatabaseDao();
			return orderDao.updateOrderlist(orderlistId, price, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 数据库操作失败
	}
}
