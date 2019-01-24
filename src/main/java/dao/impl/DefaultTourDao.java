package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.TourDao;
import dbUtils.DbConnectionUtils;
import dto.TourData;
import utils.ReadPropertiesFile;

public class DefaultTourDao implements TourDao {

	private static final String PATH_SQL_QUERIES = "properties/queries.properties";
	private static DefaultTourDao instance;

	private DefaultTourDao() {
	}

	public static synchronized DefaultTourDao getDefaultTourDao() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}

	@Override
	public List<TourData> getAllTours() throws SQLException {

		PreparedStatement prSt = null;
		Connection con = null;
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getAllToursSQL");
		List<TourData> allToursList = new LinkedList<TourData>();

		try {
			con = DbConnectionUtils.getConnection();
			prSt = con.prepareStatement(SQLquery);
			ResultSet rs = prSt.executeQuery();

			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setToursID(rs.getInt("tour_ID"));
				tourData.setToursType(rs.getString("tour_Type"));
				tourData.setToursLocation(rs.getString("tour_Location"));
				tourData.setToursCity(rs.getString("tour_City"));
				tourData.setToursCountry(rs.getString("tour_Country"));
				tourData.setToursHotel(rs.getString("tour_Hotel"));
				tourData.setToursDuration(rs.getInt("tour_Duration"));
				tourData.setTourPrice(rs.getDouble("tour_Price"));

				allToursList.add(tourData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (prSt != null) {
				prSt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return allToursList;
	}

	@Override
	public void setNewTour(String tourType, String tourLocation, String tourCity, String tourCountry, String tourHotel,
			int tourDuration, double tourPrice) {

		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setNewTourSQL");
		PreparedStatement prSt;
		Connection con = DbConnectionUtils.getConnection();
		try {
			prSt = con.prepareStatement(SQLquery);

			prSt.setString(1, tourType);
			prSt.setString(2, tourLocation);
			prSt.setString(3, tourCity);
			prSt.setString(4, tourCountry);
			prSt.setString(5, tourHotel);
			prSt.setInt(6, tourDuration);
			prSt.setDouble(7, tourPrice);

			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeTour(int tourID) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "removeTourSQL");
		PreparedStatement prSt;
		Connection con = DbConnectionUtils.getConnection();
		try {
			prSt = con.prepareStatement(SQLquery);
			prSt.setInt(1, tourID);
			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
