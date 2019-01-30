package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DefaultTourDao;
import dto.TourData;


public class OurTours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OurTours() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TourData> allTours = null;
		try {
			allTours = DefaultTourDao.getDefaultTourDao().getAllTours();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("tours", allTours);
		
		request.getRequestDispatcher("our_tours.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
