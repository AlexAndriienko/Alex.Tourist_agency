package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.UserDao;
import dbUtils.DbConnectionUtils;
import dto.TourData;
import dto.UserData;
import utils.ReadPropertiesFile;

public class DefaultUserDao implements UserDao {

	private static final String PATH_SQL_QUERIES = "properties/queries.properties";
	private static DefaultUserDao instance;

	private DefaultUserDao() {
	}

	public static synchronized DefaultUserDao getDefaultUserDao() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	@Override
	public List<UserData> getAllUsers() {
		List<UserData> allUsersList = new LinkedList<UserData>();
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getAllUsersSQL");

		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			ResultSet rs = prSt.executeQuery();

			while (rs.next()) {
				UserData userData = new UserData();
				userData.setUserID(rs.getInt("user_ID"));
				userData.setUserLogin(rs.getString("user_Login"));
				userData.setUserPass(rs.getString("user_Pass"));
				userData.setUserEmail(rs.getString("user_Email"));
				userData.setUser_Access(rs.getInt("user_Access"));

				allUsersList.add(userData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allUsersList;
	}

	@Override
	public UserData getUserByUQData(String data, String SQLkey) {
		UserData userData = new UserData();
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, SQLkey);

		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			prSt.setString(1, data);
			ResultSet rs = prSt.executeQuery();
			while (rs.next()) {
				userData.setUserID(rs.getInt("user_ID"));
				userData.setUserLogin(rs.getString("user_Login"));
				userData.setUserPass(rs.getString("user_Pass"));
				userData.setUserEmail(rs.getString("user_Email"));
				userData.setUser_Access(rs.getInt("user_Access"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}

	@Override
	public void setNewUser(UserData userData) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setNewUserSQL");

		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			prSt.setString(1, userData.getUserLogin());
			prSt.setString(2, userData.getUserPass());
			prSt.setString(3, userData.getUserEmail());
			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeUser(UserData user) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "removeUserSQL");
		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			prSt.setInt(1, user.getUserID());
			prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getUserTours(UserData user) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserTourSQL");
		List<TourData> userTours = new LinkedList<TourData>();

		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			prSt.setInt(1, user.getUserID());
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

				userTours.add(tourData);
			}
			user.setUserTours(userTours);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUserTours(UserData userNewTours) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setUserTourSQL");
		removeAllUserToursSQL(userNewTours);
		List<TourData> newTours = userNewTours.getUserTours();
		Iterator<TourData> iter = newTours.iterator();
		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {

			while (iter.hasNext()) {
				prSt.setInt(1, userNewTours.getUserID());
				prSt.setInt(2, iter.next().getTourID());
				prSt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeAllUserToursSQL(UserData user) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "removeUserTourSQL");
		try (PreparedStatement prSt = DbConnectionUtils.getConnectionPool().prepareStatement(SQLquery)) {
			prSt.setInt(1, user.getUserID());
			prSt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
