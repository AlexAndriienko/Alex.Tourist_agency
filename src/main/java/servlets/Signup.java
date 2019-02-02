package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DefaultUserDao;
import dto.UserData;
import utils.ValidateNewUser;

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
		List<String> resultValidationList = null;

		UserData user = new UserData();
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password_repeat = request.getParameter("password-repeat");
		
		user.setUserLogin(login.trim().toLowerCase());
		user.setUserEmail(email.trim().toLowerCase());
		user.setUserPass(password);
		
		resultValidationList = new ValidateNewUser().getValidationLog(user, password_repeat);

		if (resultValidationList.isEmpty()) {
			DefaultUserDao.getDefaultUserDao().setNewUser(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("resultValidationList", resultValidationList);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
