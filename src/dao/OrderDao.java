package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import bean.Order;
import bean.Orderlist;

public class OrderDao {
	//将订单元素信息存入数据库中
	public Integer addOrder(Order order,DatabaseDao databaseDao) throws SQLException{
		String sql="insert into order_(orderlistId,price,number,bookId) values('"+
				order.getOrderlistId()+"','"+order.getPrice()+"','"+order.getNumber()+"','"+order.getBookId()+"')";
		return databaseDao.update(sql);
	}
	
	//将订单组存入数据库中
	public Integer addOrderlist(Orderlist orderlist,DatabaseDao databaseDao) throws SQLException{
		String sql="insert into orderlist(orderlistId,totalPrice,isPay,address,userId) values('"+
				orderlist.getOrderlistId()+"','"+orderlist.getTotalPrice()+"','"+orderlist.getIsPay()+"','"+orderlist.getAddress()+"','"+orderlist.getUserId()+"')";
		return databaseDao.update(sql);
	}
	
	//查询订单元素是否存在
	public Integer hasOrder(String orderlistId,Integer bookId,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from order_ where orderlistId='"+orderlistId+"' and bookId='"+bookId+"'";
		databaseDao.query(sql);
		if(databaseDao.next()) return 1;
		else	return 0;
	}
	
	//查询未支付的订单
	public Integer hasNoPayOrderlist(String userId,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from orderlist where userId='"+userId+"' and  isPay='否'";
		databaseDao.query(sql);
		if(databaseDao.next()) return 1;
		else	return 0;
	}
	
	//返回一个未支付订单
	public Orderlist findOrderlistByUserId(String userId,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from orderlist where userId='"+userId+"' and  isPay='否'";
		databaseDao.query(sql);
		if(databaseDao.next()){
			Orderlist orderlist=new Orderlist();
			orderlist.setOrderlistId(databaseDao.getString("orderlistId"));
			orderlist.setTotalPrice(databaseDao.getDouble("totalPrice"));
			orderlist.setIsPay(databaseDao.getString("isPay"));
			orderlist.setAddress(databaseDao.getString("address"));
			orderlist.setOrderTime(databaseDao.getTimestamp("orderTime"));
			orderlist.setUserId(databaseDao.getString("userId"));
			return orderlist;
		}else{
			return null;
		}
	}
	
	//查询是否有同类订单元素
	public Integer hasSameOrder(String orderlistId,String bookId,DatabaseDao databaseDao) throws SQLException{
		String sql="select * from order_ where bookId='"+bookId+"' and  orderlistId='"+orderlistId+"'";
		databaseDao.query(sql);
		if(databaseDao.next()) return 1;
		else	return 0;
	}
	
	//同类订单购买数更新
	public Integer updateOrderNumber(String orderlistId,String bookId,String number,DatabaseDao databaseDao) throws SQLException{
		String sql="update order_ set number=number+"+number+" where bookId='"+bookId+"' and  orderlistId='"+orderlistId+"'";
		return databaseDao.update(sql);
	}
	
	//同类订单购买数更新
	public Integer updateOrderlist(String orderlistId,Double price,DatabaseDao databaseDao) throws SQLException{
		String sql="update orderlist set totalPrice='"+price+"',isPay='是' where orderlistId='"+orderlistId+"'";
		return databaseDao.update(sql);
	}
		
	//返回一个订单组的所有订单
	public List<Order> findOrdersByOrderlistId(String orderlistId,DatabaseDao databaseDao) throws SQLException{
		List<Order> orders=new ArrayList<Order>();
		String sql="select * from order_ where orderlistId='"+orderlistId+"'";
		databaseDao.query(sql);
		while(databaseDao.next()){
			Order order=new Order();
			order.setOrderlistId(orderlistId);
			order.setBookId(databaseDao.getInt("bookId"));
			order.setNumber(databaseDao.getInt("number"));
			order.setOrderId(databaseDao.getInt("orderId"));
			order.setPrice(databaseDao.getDouble("price"));
			orders.add(order);
		}
		return orders;
	}
	
	
}
