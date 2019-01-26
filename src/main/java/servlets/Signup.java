package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out = response.getWriter();

		UserData user = new UserData();
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user.setUserLogin(login.trim());
		user.setUserEmail(email.trim());
		user.setUserPass(password.trim());

		List<String> resultValidationList = new ValidateNewUser().getValidationLog(user);

		if (resultValidationList.isEmpty()) {
			DefaultUserDao.getDefaultUserDao().setNewUser(user);
			out.println("Registration successful");
		} else {
			out.println(resultValidationList);
		}

	}

}
