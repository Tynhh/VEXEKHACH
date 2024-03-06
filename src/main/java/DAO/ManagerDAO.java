package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Manager;

public class ManagerDAO {

	public static List<Manager> listManager(Connection conn) throws SQLException {
		String sql = "SELECT * FROM Manager";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Manager> list = new ArrayList<Manager>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String email = rs.getString("email");
			String pass = rs.getString("password");
			int idgara = rs.getInt("garage_id");
			Manager mh = new Manager();
			mh.setId(id);
			mh.setFullname(ten);
			mh.setPhone_number(phone);
			mh.setEmail(email);
			mh.setPassword(pass);
			mh.setGaraid(idgara);
			list.add(mh);
		}

		return list;
	}

	public static List<Manager> findManager(Connection conn, String require) throws SQLException {

		String sql = "Select a.id, a.fullname, a.phone_number, a.email, a.password, a.garage_id from Manager a where a.fullname like '%"
				+ require + "%' or a.phone_number like '%" + require + "%' or a.email like '%" + require
				+ "%' or a.password like '%" + require + "%' or a.garage_id like '%" + require + "%'";

		PreparedStatement pstm = conn.prepareStatement(sql);

		System.out.println(sql);

		ResultSet rs = pstm.executeQuery();
		List<Manager> list = new ArrayList<Manager>();
		while (rs.next()) {

			int id = rs.getInt("id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String email = rs.getString("email");
			String pass = rs.getString("password");
			int idgara = rs.getInt("garage_id");
			Manager mh = new Manager();
			mh.setId(id);
			mh.setFullname(ten);
			mh.setPhone_number(phone);
			mh.setEmail(email);
			mh.setPassword(pass);
			mh.setGaraid(idgara);
			list.add(mh);
		}
		return list;
	}

	public static Manager findManager(Connection connection, String phoneManager, String passManager)
			throws SQLException {
		String sql = "Select * from Manager " //
				+ " where phone_number = ? and password= ?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setString(1, phoneManager);
		pstm.setString(2, passManager);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Manager manager = new Manager();
			manager.setPhone_number(phoneManager);
			manager.setPassword(passManager);
			return manager;
		}
		return null;
	}

	public static Manager findManagerByPhone(Connection connection, String phoneManager) throws SQLException {
		String sql = "Select * from Manager " //
				+ " where phone_number = ?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setString(1, phoneManager);
		ResultSet rs = pstm.executeQuery();
		System.out.println("da vo ham tim");
		if (rs.next()) {
			Manager manager = new Manager();
			String fullName = rs.getString("fullname");
			String email = rs.getString("email");
			manager.setPhone_number(phoneManager);
			manager.setFullname(fullName);
			manager.setEmail(email);
			System.out.println(email);
			System.out.println(fullName);

			return manager;
		}
		return null;
	}

	public static void updatePassword(Connection conn, String password, String numberPhone) throws SQLException {
		String sql = "Update Manager set password =? where phone_number=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, password);
		pstm.setString(2, numberPhone);
		pstm.executeUpdate();
	}

	public static int checkDesist(Connection conn, String phoneManager, String passManager) throws SQLException {
		String sql = "Select gr.deleted From Garage gr, Manager mg Where mg.phone_number=? and mg.password =? and gr.id = mg.garage_id";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, phoneManager);
		pstm.setString(2, passManager);
		int delete = 2;
		System.out.println("11111111111" + delete);
		ResultSet rs = pstm.executeQuery();
		// delete = rs.getInt("delete");
		// System.out.println("3333333333" + delete);
		if (rs.next()) {
			delete = rs.getInt("deleted");
			System.out.println("11111111111" + delete);
		}
		return delete;
	}

	public int insertManager(Connection conn, String fullname, String phone_number, String email, String password,
			int garage_id) throws SQLException {
		String checkPhone = "select * from Manager where phone_number = ?";
		PreparedStatement pstm3 = conn.prepareStatement(checkPhone);
		pstm3.setString(1, phone_number);
		ResultSet rs3 = pstm3.executeQuery();
		int check1 = 0;
		if (rs3.next()) {
			check1 = rs3.getInt("id");
		}
		System.out.println(check1);
		String checkEmail = "select * from Manager where email = ?";
		PreparedStatement pstm4 = conn.prepareStatement(checkEmail);
		pstm4.setString(1, email);
		ResultSet rs4 = pstm4.executeQuery();
		int check2 = 0;
		if (rs4.next()) {
			check2 = rs4.getInt("id");
		}
		System.out.println(check2);
		int checkMana = 0;
		if (check1 == 0 & check2 == 0) {
			String sql = "Insert into Manager(fullname,phone_number,email,password,garage_id) values (?, ?, ?, ?, ?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, fullname);
			pstm.setString(2, phone_number);
			pstm.setString(3, email);
			pstm.setString(4, password);
			pstm.setInt(5, garage_id);
			pstm.executeUpdate();
		} else if (check1 == 0 & check2 != 0) {
			checkMana = 1;
		} else if (check1 != 0 & check2 == 0) {
			checkMana = 2;
		} else {
			checkMana = 3;
		}
		System.out.println(checkMana);
		return checkMana;
	}

	public static void deleteManager(Connection conn, int idIn) throws SQLException {
		String sql = "Delete from Manager where id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, idIn);

		pstm.executeUpdate();
	}

	public static Manager findManager(Connection conn, int idIn) throws SQLException {
		String sql = "Select a.id, a.fullname, a.phone_number, a.email, a.password, a.garage_id from Manager a where a.id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, idIn);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String email = rs.getString("email");
			String pass = rs.getString("password");
			int idgara = rs.getInt("garage_id");
			Manager mh = new Manager(id, ten, phone, email, pass, idgara);

			return mh;
		}
		return null;
	}

	public static void updateManager(Connection conn, Manager mh) throws SQLException {
		String sql = "Update Manager set fullname=?, phone_number=?, email=?, password=?, garage_id=? where id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, mh.getFullname());
		pstm.setString(2, mh.getPhone_number());
		pstm.setString(3, mh.getEmail());
		pstm.setString(4, mh.getPassword());
		pstm.setInt(5, mh.getGaraid());
		pstm.setInt(6, mh.getId());

		pstm.executeUpdate();
	}

	public static void insertManager(Connection conn, Manager mh) throws SQLException {
		String sql = "Insert into ManagerManager(fullname,phone_number,email,password,garage_id) values (?, ?, ?, ?, ?)";
		//
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, mh.getFullname());
		pstm.setString(2, mh.getPhone_number());
		pstm.setString(3, mh.getEmail());
		pstm.setString(4, mh.getPassword());
		pstm.setInt(5, mh.getGaraid());
		pstm.executeUpdate();
	}
}
