package dao;

import java.sql.SQLException;
import java.util.List;

import dto.TourData;

public interface TourDao {
	
	public List<TourData> getAllTours() throws SQLException;
	public void setNewTour(String tourType,	String tourLocation, String tourCity, String tourCountry, String tourHotel, int tourDuration, double tourPrice);
	public void removeTour(int tourID);

}
