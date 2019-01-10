package dao;

import java.util.List;

import dto.TourData;

public interface TourDao {
	
	public TourData getTourById(int tourID);
	public List<TourData> getTours();

}
