package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DefaultUserDao;
import utils.ValidateUser;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Signup() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userLogin = request.getParameter("login");
		String userEmail = request.getParameter("email");
		String pass = request.getParameter("password");
		String passRpt = request.getParameter("password-repeat");
		PrintWriter out = response.getWriter();
		
		if (ValidateUser.checkLoginMatch(userLogin)) {
			out.println("User with this login already exists");		
		} else if (ValidateUser.checkEmailMatch(userEmail)) {
			out.println("User with this email already exists");
		} else if (!pass.equals(passRpt)) {
			out.println("Password mismatch");
		} else if (userLogin == null || userEmail == null || pass == null || passRpt == null) {
			out.println("Registration error! Please fill in all fields.");
		} else {
//			DefaultUserDao.getDefaultUserDao().setNewUser(userLogin, userEmail, pass);
			out.println("Registration successful");
		}
			
	}

}
