package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<TourData> allTours = null;
		try {
			allTours = DefaultTourDao.getDefaultTourDao().getAllTours();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String search = request.getParameter("seach").trim().toLowerCase();
		List<TourData> search_tours = null;
		
		search_tours = allTours.stream()
				.filter(tour -> tour.getTourType().toLowerCase().contains(search) || 
						tour.getTourCountry().toLowerCase().contains(search) ||
						tour.getTourCity().toLowerCase().contains(search) ||
						tour.getTourHotel().toLowerCase().contains(search))				
				.collect(Collectors.toCollection(LinkedList<TourData>::new));
		
		request.setAttribute("tours", search_tours);		
		request.getRequestDispatcher("our_tours.jsp").forward(request, response);
		
	}

}
