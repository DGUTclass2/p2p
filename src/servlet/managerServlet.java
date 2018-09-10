package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manager;
import bean.User;
import service.ManagerService;
import service.UserService;
import tools.Message;
import tools.PageInformation;
import tools.Tool;

public class managerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		ManagerService managerService=new ManagerService();
		Message message=new Message();
		
		if(type.equals("register")){
			Manager manager=new Manager();
			manager.setManagerId(request.getParameter("managerId"));
			manager.setPassword(request.getParameter("password"));
			manager.setE_mail(request.getParameter("e_mail"));
			int result=managerService.register(manager);
			
			message.setResult(result);
			if(result==1){
				message.setMessage("信息录入完成！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}else if(result==0){
				message.setMessage("同名管理员已存在，请修改管理员名重新注册！");
				message.setRedirectUrl("/bookStore/manager/regiManager.jsp");
			}else{
				message.setMessage("注册失败！请联系开发人员！");
				message.setRedirectUrl("/bookStore/manager/regiManager.jsp");
			}
			request.getSession().setAttribute("managerId", manager.getManagerId());
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("login")){
			Manager manager=new Manager();
			manager.setManagerId(request.getParameter("managerId"));
			manager.setPassword(request.getParameter("password"));
			int result=managerService.login(manager);
			

			message.setResult(result);
			if(result==1){//登录成功
				manager.setPassword(null);//防止密码泄露
				request.getSession().setAttribute("managerId",manager.getManagerId());
				message.setMessage("登录成功！");
				message.setRedirectUrl("/bookStore/manager/manageCenter.jsp");
			}else{
				message.setMessage("出现错误，请重新登录！");
				message.setRedirectUrl("/bookStore/manage.jsp");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);		
		}else if(type.equals("cancellation")){
			request.getSession().setAttribute("managerId",null);
			request.getSession().setAttribute("manager", null);
			
			message.setResult(1);
			message.setMessage("注销成功！");
			message.setRedirectUrl("/bookStore/manage.jsp");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("showAllUser")){//显示用户信息
			UserService userService=new UserService();
			PageInformation pageInformation=new PageInformation();
			
			Tool.getPgaeInformation("user", request, pageInformation);//初始化pageInformation对象
			List<User> users=userService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("users", users);
			request.getServletContext().getRequestDispatcher("/manager/showAllUser.jsp").forward(request, response);
		}else if(type.equals("showAllManager")){//显示用户信息
			PageInformation pageInformation=new PageInformation();
			
			Tool.getPgaeInformation("manager", request, pageInformation);//初始化pageInformation对象
			List<Manager> managers=managerService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("managers", managers);
			request.getServletContext().getRequestDispatcher("/manager/showAllManager.jsp").forward(request, response);
		}
	}

}
