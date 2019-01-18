package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.ValidateUser;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		 PrintWriter out = response.getWriter();
//	        out.print("<h1>Hello Servlet</h1>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		String action = request.getParameter("action");
//		System.out.println(request.getParameter("action"));
//		
//		switch (action == null ? "info" : action) {
//        case "userID":
//            request.getRequestDispatcher("user.jsp").forward(request, response);
//            break;
//        case "info":
//        default:
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            break;
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("request = " + request.getParameter("userID"));
//		UserDao dud = new DefaultUserDao();
//		try {
//			UserData user = dud.getUserById(Integer.parseInt(request.getParameter("userID")));
//		} catch (NumberFormatException | SQLException e) {
//			e.printStackTrace();
//		}
//		response.setContentType("");

		PrintWriter out = response.getWriter();

		String userLogin = request.getParameter("userLogin");
		String userPass = request.getParameter("userPass");

		if (ValidateUser.checkUser(userLogin, userPass)) {
//			RequestDispatcher rs = request.getRequestDispatcher("Welcome");
//			rs.forward(request, response);
			out.println("Username correct");
		} else {
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}

	}

}
