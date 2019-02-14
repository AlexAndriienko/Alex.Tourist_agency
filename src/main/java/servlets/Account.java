package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.DefaultTourDao;
import dao.impl.DefaultUserDao;
import dto.TourData;
import dto.UserData;
import utils.DefaultUserValidator;

public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			UserData loggedUser = (UserData) session.getAttribute("loggedUser");
			DefaultUserDao.getDefaultUserDao().getUserTours(loggedUser);
			List<TourData> tourCart = new LinkedList<TourData>();
			
			Cookie	cookie = null;
			Cookie[] cookies = request.getCookies();
			
				for (int i = 0; i < cookies.length; i++) {				
					cookie = cookies[i];
					String name = cookie.getName();
					
					if (Integer.toString(loggedUser.getUserID()).equals(name)) {										
						tourCart.add(DefaultTourDao.getDefaultTourDao().getTourById(cookie.getValue()));
					}
				}
				
				session.setAttribute("cart", tourCart);
				
			request.getRequestDispatcher("account.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserData loggedUser = (UserData) request.getSession().getAttribute("loggedUser");
		int formParam = Integer.parseInt(request.getParameter("formParam"));
		PrintWriter printWriter = response.getWriter();
		/* formParam = 1: change password
		 * 2: change email
		 * 3: remove user
		 * 4: add tour to cart
		*/	
		switch (formParam) {

		case 1:

			String password = request.getParameter("password");
			String password_repeat = request.getParameter("password-repeat");

			List<String> passValidationList = DefaultUserValidator.getDefaultUserValidator().checkPass(password, password_repeat);

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

			List<String> emailValidationList = DefaultUserValidator.getDefaultUserValidator().checkEmail(email);

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
			
		case 4:
			String tourId = request.getParameter("tourId");
			Cookie userCookie = new Cookie(Integer.toString(loggedUser.getUserID()), tourId);
			userCookie.setMaxAge(60*60*24*365); //Store cookie for 1 year
			response.addCookie(userCookie);
			printWriter.println("Tour successfully added to your cart!");
			
			break;
		}

	}

}
