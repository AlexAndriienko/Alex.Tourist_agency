package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public UserData getUserById(int id) throws SQLException {
		PreparedStatement preparedStatementGetUserById = null;
		Connection con = null;
		String getUserByIdSQL = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserByIdSQL");
		UserData userData = new UserData();

		try {
			con = DbConnectionUtils.getConnection();
			preparedStatementGetUserById = con.prepareStatement(getUserByIdSQL + id);
			ResultSet rs = preparedStatementGetUserById.executeQuery();
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

			if (preparedStatementGetUserById != null) {
				preparedStatementGetUserById.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return userData;
	}

	@Override
	public List<UserData> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserData getUserByLogin(String userLogin) throws SQLException {
		PreparedStatement preparedStatementGetUserByLogin = null;
		Connection con = null;
		String getUserByLoginSQL = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserByLoginSQL");
		UserData userData = new UserData();

		try {
			con = DbConnectionUtils.getConnection();
			preparedStatementGetUserByLogin = con.prepareStatement(getUserByLoginSQL + "\"" + userLogin + "\"");
			ResultSet rs = preparedStatementGetUserByLogin.executeQuery();
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

			if (preparedStatementGetUserByLogin != null) {
				preparedStatementGetUserByLogin.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return userData;
	}

	@Override
	public UserData getUserByEmail(String userEmail) throws SQLException {
		PreparedStatement preparedStatementGetUserByEmail = null;
		Connection con = null;
		String getUserByEmailSQL = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserByEmailSQL");
		UserData userData = new UserData();

		try {
			con = DbConnectionUtils.getConnection();
			preparedStatementGetUserByEmail = con.prepareStatement(getUserByEmailSQL + "\"" + userEmail + "\"");
			ResultSet rs = preparedStatementGetUserByEmail.executeQuery();
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

			if (preparedStatementGetUserByEmail != null) {
				preparedStatementGetUserByEmail.close();
			}

			if (con != null) {
				con.close();
			}
		}
		return userData;
	}

	@Override
	public void setNewUser(String userLogin, String userEmail, String pass) throws SQLException {
		Connection con = null;
		String setNewUserSQL = ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "setNewUserSQL");
		con = DbConnectionUtils.getConnection();
		PreparedStatement preparedStatementSetNewUser = con.prepareStatement(setNewUserSQL);
		preparedStatementSetNewUser.setString(1, userLogin);
		preparedStatementSetNewUser.setString(2, pass);
		preparedStatementSetNewUser.setString(3, userEmail);		
		preparedStatementSetNewUser.execute();
		con.close();
	}
}
