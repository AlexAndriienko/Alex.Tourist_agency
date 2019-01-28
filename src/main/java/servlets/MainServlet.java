package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.DefaultUserDao;
import dto.UserData;
import utils.ValidateUser;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserData loggedUser = null;
		String userLogin = request.getParameter("userLogin").trim().toLowerCase();
		String userPass = request.getParameter("userPass");	

		if (ValidateUser.checkUser(userLogin, userPass)) {

			loggedUser = DefaultUserDao.getDefaultUserDao().getUserByUQData(userLogin, "getUserByLoginSQL");

			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", loggedUser);
			response.sendRedirect(request.getContextPath() + "/account");

		} else {
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}

	}

}
