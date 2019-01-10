package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.UserDao;
import dbUtils.DbConnectionUtils;
import dto.UserData;

public class DefaultUserDao implements UserDao {

	public UserData getUserById(int id) throws SQLException {

		PreparedStatement preparedStatementGetUserById = null;
		Connection con = null;
		String getUserByIdSQL = "SELECT * FROM users WHERE user_ID = ";
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

			if (preparedStatementGetUserById!= null) {
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

}
