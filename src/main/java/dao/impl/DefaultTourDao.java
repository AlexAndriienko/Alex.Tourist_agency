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
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getAllToursSQL");
		List<TourData> allToursList = new LinkedList<TourData>();

		try(Connection conn = DbConnectionUtils.getConnectionPool();
			PreparedStatement prSt = conn.prepareStatement(SQLquery)) {
			
			ResultSet rs = prSt.executeQuery();

			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourID(rs.getInt("tour_ID"));
				tourData.setTourType(rs.getString("tour_Type"));
				tourData.setTourLocation(rs.getString("tour_Location"));
				tourData.setTourCity(rs.getString("tour_City"));
				tourData.setTourCountry(rs.getString("tour_Country"));
				tourData.setTourHotel(rs.getString("tour_Hotel"));
				tourData.setTourDuration(rs.getInt("tour_Duration"));
				tourData.setTourPrice(rs.getDouble("tour_Price"));

				allToursList.add(tourData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allToursList;
	}

	@Override
	public void setNewTour(TourData tourData) {
		
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setNewTourSQL");
		try(Connection conn = DbConnectionUtils.getConnectionPool();
			PreparedStatement prSt = conn.prepareStatement(SQLquery)) {

			prSt.setString(1, tourData.getTourType());
			prSt.setString(2, tourData.getTourLocation());
			prSt.setString(3, tourData.getTourCity());
			prSt.setString(4, tourData.getTourCountry());
			prSt.setString(5, tourData.getTourHotel());
			prSt.setInt(6, tourData.getTourDuration());
			prSt.setDouble(7, tourData.getTourPrice());
			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeTour(int tourID) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "removeTourSQL");
		try(Connection conn = DbConnectionUtils.getConnectionPool();
			PreparedStatement prSt = conn.prepareStatement(SQLquery)) {
			prSt.setInt(1, tourID);
			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
