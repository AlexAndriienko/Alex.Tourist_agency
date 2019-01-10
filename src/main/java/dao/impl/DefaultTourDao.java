package dao.impl;

import java.util.List;

import dao.TourDao;
import dto.TourData;

public class DefaultTourDao  implements TourDao {

	@Override
	public TourData getTourById(int tourID) {
		TourData tourData = new TourData();
		
		return tourData;
	}

	@Override
	public List<TourData> getTours() {
		return null;
	}



}
