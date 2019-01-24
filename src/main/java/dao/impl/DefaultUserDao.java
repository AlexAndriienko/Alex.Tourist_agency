package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import dao.UserDao;
import dbUtils.DbConnectionUtils;
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
		PreparedStatement prSt = null;
		Connection con = null;

		try {
			con = DbConnectionUtils.getConnection();
			prSt = con.prepareStatement(SQLquery);
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
		} finally {

			if (prSt != null) {
				try {
					prSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return allUsersList;
	}

	@Override
	public UserData getUserByUQData(String data, String SQLkey) {
		UserData userData = new UserData();
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, SQLkey);
		PreparedStatement prSt = null;
		Connection con = null;

		try {
			con = DbConnectionUtils.getConnection();
			prSt = con.prepareStatement(SQLquery);
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
		} finally {

			if (prSt != null) {
				try {
					prSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userData;
	}

	@Override
	public void setNewUser(String userLogin, String userEmail, String pass) {
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setNewUserSQL");
		PreparedStatement prSt;
		Connection con = DbConnectionUtils.getConnection();
		try {
			prSt = con.prepareStatement(SQLquery);
			prSt.setString(1, userLogin);
			prSt.setString(2, pass);
			prSt.setString(3, userEmail);
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
	public void removeUser(int userID) {
		Connection con = DbConnectionUtils.getConnection();
		String SQLquery = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "removeUserSQL");
		PreparedStatement prSt;
		try {
			prSt = con.prepareStatement(SQLquery);
			prSt.setInt(1, userID);
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
