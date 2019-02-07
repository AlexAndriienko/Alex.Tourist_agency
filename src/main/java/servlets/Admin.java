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

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Admin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		
			List<TourData> allTours = null;
			try {
				allTours = DefaultTourDao.getDefaultTourDao().getAllTours();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("tours", allTours);
			request.getRequestDispatcher("admin_tour.jsp").forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int formParam = Integer.parseInt(request.getParameter("formParam"));
		
		switch (formParam) {

		case 1:
			
			TourData newTour = new TourData();
			newTour.setTourType(request.getParameter("tour_Type"));
			newTour.setTourLocation(request.getParameter("tour_Location"));
			newTour.setTourCountry(request.getParameter("tour_Type"));
			newTour.setTourCity(request.getParameter("tour_City"));
			newTour.setTourHotel(request.getParameter("tour_Hotel"));
			newTour.setTourDuration(Integer.parseInt(request.getParameter("tour_Duration")));
			newTour.setTourPrice(Double.parseDouble(request.getParameter("tour_Price")));
		break;
		
		case 2:

		}
	}

}
