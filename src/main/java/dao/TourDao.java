package dao;

import java.sql.SQLException;
import java.util.List;

import dto.TourData;

public interface TourDao {
	
	public List<TourData> getAllTours() throws SQLException;
	public void setNewTour(TourData tourData);
	public void removeTour(int tourID);

}
