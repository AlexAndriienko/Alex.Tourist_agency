package filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserData;

public class AdminFilter implements javax.servlet.Filter {

    public AdminFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
		
		UserData loggedUser = (UserData) req.getSession().getAttribute("loggedUser");
		
		 if (loggedUser.getUser_Access() != 0) {			 
			 chain.doFilter(request, response);	            	 
	     } else 
	    	 res.sendRedirect("account");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
