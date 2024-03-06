package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.Customer;

public class AdminDAO {
	public static Admin findAdmin(Connection connection, String user, String pass) throws SQLException {
		String sql = "Select * from Admin " //
				+ " where user_name = ? and password= ?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setString(1, user);
		pstm.setString(2, pass);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Admin admin = new Admin();
			admin.setUser(user);
			admin.setPass(pass);
			return admin;
		}
		return null;
	}
}
