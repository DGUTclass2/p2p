package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/SecurityFilter")
public class SecurityFilter implements Filter {
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		if(session.getAttribute("Username")!=null){
		chain.doFilter(request, response);
		}else{//没登录
			String orginalUrl=req.getRequestURI();
			req.getSession().setAttribute("orginalUrl", orginalUrl);
			String aa=(String)req.getSession().getAttribute("orginalUrl");
			res.sendRedirect("/project02/login.jsp");
		}
		System.out.println("after SecurityFilter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
