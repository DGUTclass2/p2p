package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.DatabaseDao;
import dao.UserDao;
import service.UserService;
import tools.Message;

public class userServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService=new UserService();
		Message message=new Message();
		String type=request.getParameter("type");
		
		if(type.equals("regi1")){//用户基本信息注册
			User user=new User();
			user.setUserId(request.getParameter("userId"));
			user.setPassword(request.getParameter("password"));
			user.setE_mail(request.getParameter("E_mail"));
			int result=userService.register1(user);//写入数据库
			
			message.setResult(result);
			if(result==1){
				message.setMessage("信息录入完成！");
				message.setRedirectUrl("/bookStore/user/regi2.jsp");
			}else if(result==0){
				message.setMessage("同名用户已存在，请修改用户名重新注册！");
				message.setRedirectUrl("/bookStore/user/regi1.jsp");
			}else{
				message.setMessage("注册失败！请联系管理员！");
				message.setRedirectUrl("/bookStore/user/regi1.jsp");
			}
			request.getSession().setAttribute("userId", user.getUserId());
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("regi2")){//用户个人信息处理
			String userId=(String) request.getSession().getAttribute("userId");
			User user=userService.getUserById(request, userId);
			Integer result=userService.register2(user);
			
			if(result==1){
				message.setResult(1);
				message.setMessage("信息录入完成！");
				message.setRedirectUrl("/bookStore/index.jsp");
			}else{
				message.setResult(0);
				message.setMessage("注册失败！");
				message.setRedirectUrl("/bookStore/user/regi1.jsp");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("login")){
			User user=new User();
			user.setUserId(request.getParameter("userId"));
			user.setPassword(request.getParameter("password"));
			int result=userService.login(user);
			message.setResult(result);
			
			if(result==1){//登录成功
				user.setPassword(null);//防止密码泄露
				request.getSession().setAttribute("userId", request.getParameter("userId"));
				message.setMessage("登录成功！");
				message.setRedirectUrl("/bookStore/index.jsp");
			}else{
				message.setMessage("出现错误，请重新登录！");
				message.setRedirectUrl("/bookStore/index.jsp");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);		
		}else if(type.equals("show")){
			String userId=(String) request.getSession().getAttribute("userId");
			if(userId!=null && !userId.isEmpty()){
				User user=userService.findUser(userId);
				if(user!=null){
					request.getSession().setAttribute("user", user);
					getServletContext().getRequestDispatcher("/user/userShow.jsp").forward(request,response);		
				}
			}
				message.setResult(0);
				message.setMessage("用户信息不存在，请先注册登录！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);	
			}else if(type.equals("showUpdate")){
				String userId=(String) request.getSession().getAttribute("userId");
				if(userId!=null && !userId.isEmpty()){
					User user=userService.findUser(userId);
					if(user!=null){
						request.getSession().setAttribute("User", user);
						getServletContext().getRequestDispatcher("/user/userUpdate.jsp").forward(request,response);		
					}
				}
					message.setResult(0);
					message.setMessage("用户信息不存在，请先注册登录！");
					message.setRedirectUrl("/bookStore/index.jsp");
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);	
			}else if(type.equals("update")){
				String userId=(String) request.getSession().getAttribute("userId");
				User user=userService.getUserById(request, userId);
				Integer result=userService.register2(user);
				
				if(result==1){
					message.setResult(1);
					message.setMessage("信息修改完成！");
					message.setRedirectUrl("/bookStore/index.jsp");
				}else{
					message.setResult(0);
					message.setMessage("修改失败！");
					message.setRedirectUrl("/bookStore/user/uersShow.jsp");
				}
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}else if(type.equals("cancellation")){//注销
				request.getSession().setAttribute("userId", null);
				request.getSession().setAttribute("user", null);
				
				message.setResult(1);
				message.setMessage("注销成功！");
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
			}else if(type.equals("changePassword")){
				String newPassword=request.getParameter("newPassword");
				String userId=(String) request.getSession().getAttribute("userId");
				User user=userService.findUser(userId);
				user.setPassword(request.getParameter("oldPassword"));
				Integer result=userService.changePassword(user,newPassword);
				message.setResult(result);
				if(result==1){
					message.setMessage("修改密码成功！");					
				}else if(result==0){
					message.setMessage("新旧密码重复，请重新输入！");				
				}else{
					message.setMessage("修改失败，请联系管理员！");				
				}
				message.setRedirectUrl("/bookStore/index.jsp");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);			
			}
		}

}
