package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.UserData;

public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserData loggedUser = (UserData) request.getSession().getAttribute("loggedUser");
		if (loggedUser == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			int loggedUserID = loggedUser.getUserID();
			String loggedUserLogin = loggedUser.getUserLogin();
			String loggedUserEmail = loggedUser.getUserEmail();
			request.setAttribute("loggedUserID", loggedUserID);
			request.setAttribute("loggedUserLogin", loggedUserLogin);
			request.setAttribute("loggedUserEmail", loggedUserEmail);
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
