package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.impl.DefaultUserDao;
import dto.UserData;
import utils.DefaultUserValidator;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter printWriter = response.getWriter();
		
		if (action.equals("checkLogin")) {
			String login = request.getParameter("login");
			List<String> validationList = DefaultUserValidator.getDefaultUserValidator().checkLogin(login.trim().toLowerCase());
			String jsonValidationList = new Gson().toJson(validationList);
			printWriter.println(jsonValidationList.toString());
		} else if (action.equals("checkEmail")) {
			String email = request.getParameter("email");
			List<String> validationList = DefaultUserValidator.getDefaultUserValidator().checkEmail(email.trim().toLowerCase());
			String jsonValidationList = new Gson().toJson(validationList);
			printWriter.println(jsonValidationList.toString());		
		} else if (action.equals("checkPass")) {
			String pass = request.getParameter("pass");
			List<String> validationList = DefaultUserValidator.getDefaultUserValidator().checkPass(pass);
			String jsonValidationList = new Gson().toJson(validationList);
			printWriter.println(jsonValidationList.toString());
		} else if (action.equals("submitRegForm")) {			
			UserData user = new UserData();
			String login = request.getParameter("login");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String passRpt = request.getParameter("passRpt");
			
			user.setUserLogin(login.trim().toLowerCase());
			user.setUserEmail(email.trim().toLowerCase());
			user.setUserPass(pass);
			user.setUserPassRpt(passRpt);;
						
			List<String> resultValidationList = DefaultUserValidator.getDefaultUserValidator().getLog(user);
	
			if (resultValidationList.isEmpty()) {
				DefaultUserDao.getDefaultUserDao().setNewUser(user);
				response.sendRedirect(request.getContextPath() + "/index");
			} else {
				request.setAttribute("checkLog", resultValidationList);
				request.getRequestDispatcher("register.jsp").forward(request, response);			
			}
			
		}
		


	}

}
