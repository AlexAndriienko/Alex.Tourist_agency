package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.DefaultUserDao;
import dto.UserData;
import utils.ValidateNewPass;
import utils.ValidateNewUserEmail;

public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.getRequestDispatcher("account.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserData loggedUser = (UserData) request.getSession().getAttribute("loggedUser");
		int formParam = Integer.parseInt(request.getParameter("formParam"));

		switch (formParam) {

		case 1:

			String password = request.getParameter("password");
			String password_repeat = request.getParameter("password-repeat");

			List<String> passValidationList = new ValidateNewPass().getLog(password, password_repeat);

			if (passValidationList.isEmpty()) {
				loggedUser.setUserPass(password);
				DefaultUserDao.getDefaultUserDao().changeUserPass(loggedUser);
				request.getRequestDispatcher("account.jsp").forward(request, response);

			} else {
				request.setAttribute("resultValidationList", passValidationList);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}

			break;

		case 2:
			String email = request.getParameter("email");

			List<String> emailValidationList = new ValidateNewUserEmail().getLog(email);

			if (emailValidationList.isEmpty()) {
				loggedUser.setUserEmail(email);
				DefaultUserDao.getDefaultUserDao().changeUserEmail(loggedUser);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			} else {
				request.setAttribute("resultValidationList", emailValidationList);
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}

			break;

		case 3:
			HttpSession session = request.getSession();
			session.invalidate();
			DefaultUserDao.getDefaultUserDao().removeUser(loggedUser);			
			request.getRequestDispatcher("index.jsp").forward(request, response);

			break;
		}

	}

}
