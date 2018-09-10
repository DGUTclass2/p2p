package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Order;
import bean.Orderlist;
import service.BookService;
import service.OrderService;
import service.UserService;
import tools.Cart;
import tools.Message;

public class orderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		OrderService orderService=new OrderService();
		Message message=new Message();
		
		if(type.equals("addCart")){//加入购物车
			Orderlist orderlist=null;
			Order order=null;
			int result1=1;int result2=1;
			String userId=(String) request.getSession().getAttribute("userId");
			Double price=Double.parseDouble(request.getParameter("price"));
			Integer bookId=Integer.parseInt(request.getParameter("bookId"));
			BookService bookService=new BookService();
			String number=request.getParameter("number");//获取购买数量
				if(number==null) number="1";
			
			if(userId==null){//用户未登录
				message.setResult(0);
				message.setMessage("请先登录用户！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			//检查购买数量是否大于库存
			Integer result=bookService.updateInventory(bookId, Integer.parseInt(number));
			if(result==0 || result==-1){
				message.setResult(0);
				message.setMessage("购买数量大于库存，无法购买！！");
				message.setRedirectUrl("/bookStore/servlet/bookServlet?type=showAllGoods");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}else if(result==-2){
				message.setResult(0);
				message.setMessage("加入购物车失败，请联系管理员！");
				message.setRedirectUrl("/bookStore/servlet/bookServlet?type=showAllGoods");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			
			if(orderService.hasNoPayOrderlist(userId)==0){//购物车不存在
				orderlist=tools.ServletTool.OrderlistInit(request);//创建一个新的购物车
				result1=orderService.addOrderlist(orderlist);//将订单组信息存入数据库中
			}else{
				orderlist=orderService.findOrderlistByUserId(userId);
			}
			if(orderService.hasSameOrder(orderlist.getOrderlistId(), bookId.toString())==1){//创建一个订单元素
				
				orderService.updateOrderNumber(orderlist.getOrderlistId(), bookId.toString(), number);
			}else{
				order=tools.ServletTool.OrderInit(request, orderlist.getOrderlistId(), price);
				result2=orderService.addOrder(order);//将信息存入数据库中
			}
			
			if(result1==1 && result2==1){
				message.setResult(1);
				message.setMessage("加入购物车成功，请继续购物！");
			}else{
				message.setResult(0);
				message.setMessage("加入购物车失败，请联系管理员！");
			}
			message.setRedirectUrl("/bookStore/servlet/bookServlet?type=showAllGoods");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("pay")){//支付订单
			String userId=(String) request.getSession().getAttribute("userId");
			
			if(userId==null){//用户未登录
				message.setResult(0);
				message.setMessage("请先登录用户！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			if(orderService.hasNoPayOrderlist(userId)==0){//购物车不存在
				message.setResult(0);
				message.setMessage("你的购物车为空！请先添加商品！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			
			Orderlist orderlist=orderService.findOrderlistByUserId(userId);
			//获取总价
			Double totalPrice=(Double) request.getSession().getAttribute("totalPrice");
			//更新数据库中的总价和是否支付信息
			int result=orderService.updateOrderlist(orderlist.getOrderlistId(), totalPrice);
			if(result==1){
				request.setAttribute("result", "成功");
			}else{
				request.setAttribute("result", "失败");
			}
			getServletContext().getRequestDispatcher("/shop/payResult.jsp").forward(request,response);
		}else if(type.equals("showCart")){
			Orderlist orderlist=null;
			Order order=null;
			Integer result1=1;
			List<Cart> carts=new ArrayList<Cart>();
			String userId=(String) request.getSession().getAttribute("userId");
			BookService bookService=new BookService();//用于获取书籍信息
			
			if(userId==null){//用户未登录
				message.setResult(0);
				message.setMessage("请先登录用户！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			
			if(orderService.hasNoPayOrderlist(userId)==0){//购物车不存在
				response.sendRedirect("/bookStore/shop/cartIsEmpty.html");
			}else{
				//得到一个未支付的订单组
				orderlist=orderService.findOrderlistByUserId(userId);
				//得到订单组中的所有订单元素
				List<Order> orders=orderService.findOrdersByOrderlistId(orderlist.getOrderlistId());
				//将订单元素的信息加入购物车中
				for (Order item : orders){
					Cart cart=new Cart();
					Book book=bookService.getBookById(item.getBookId().toString());
					cart.setBookId(book.getBookId());
					cart.setBookName(book.getBookName());
					cart.setImageUrl(book.getImageUrl());
					cart.setNumber(item.getNumber());
					cart.setOrderId(item.getOrderId());
					cart.setPrice(item.getPrice());
					carts.add(cart);
				}
				//将订单组和订单元素数组信息存入session中
				request.setAttribute("carts", carts);
				request.setAttribute("orderlistId", orderlist.getOrderlistId());
				getServletContext().getRequestDispatcher("/shop/showCart.jsp").forward(request,response);
			}
		}else if(type.equals("showPay")){
			String userId=(String) request.getSession().getAttribute("userId");
			
			if(userId==null){//用户未登录
				message.setResult(0);
				message.setMessage("请先登录用户！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}
			
			//得到一个未支付的订单组
			Orderlist orderlist = orderService.findOrderlistByUserId(userId);
			//得到订单组中的所有订单元素
			List<Order> orders=orderService.findOrdersByOrderlistId(orderlist.getOrderlistId());
			//计算总价
			Double totalPrice=tools.ServletTool.sumPrice(orders);
			//获取用户地址
			UserService userService=new UserService();
			String address=userService.returnAddress(userId);
			
			request.getSession().setAttribute("totalPrice", totalPrice);
			request.setAttribute("address", address);
			getServletContext().getRequestDispatcher("/shop/showPay.jsp").forward(request,response);
		}
	}

}
