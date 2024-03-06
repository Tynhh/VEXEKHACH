package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Garage;

public class GarageDAO {

	public GarageDAO() {
		// TODO Auto-generated constructor stub
	}

	public Garage getGarage(Connection con, String idGarage) {

		String sql1 = "SELECT fullname,description FROM Garage WHERE id = " + idGarage;
		Garage xe = new Garage();
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			res = pre.executeQuery();
			while (res.next()) {
				String fullname = res.getString("fullname");
				String description = res.getString("description");
				xe.setFullname(fullname);
				xe.setDescription(description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return xe;
	}

	public Garage getInfoGarage(Connection con, String idGarage) {

		String sql1 = "SELECT id,fullname,address,description FROM Garage WHERE id = " + idGarage;
		Garage xe = new Garage();
		PreparedStatement pre = null;
		ResultSet res;
		try {
			pre = con.prepareStatement(sql1);
			res = pre.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String fullname = res.getString("fullname");
				String address = res.getString("address");
				String description = res.getString("description");
				xe.setId(id);
				xe.setFullname(fullname);
				xe.setAddress(address);
				xe.setDescription(description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return xe;
	}

	public List<Garage> listGaragesActivate(Connection conn) throws SQLException {
		String sql = "select * from Garage where deleted = 0";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Garage> list = new ArrayList<Garage>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fullname = rs.getString("fullname");
			String address = rs.getString("address");
			String description = rs.getString("description");
			int deleted = rs.getInt("deleted");
			Garage garage = new Garage();
			garage.setId(id);
			garage.setFullname(fullname);
			garage.setAddress(address);
			garage.setDescription(description);
			garage.setDeleted(deleted);
			list.add(garage);
		}

		return list;
	}

	public static void insertGarage(Connection conn, String fullname, String address, String description)
			throws SQLException {
		String sql = "Insert into Garage(fullname,address,description,deleted) values (?, ?, ?, ?)";
		//
		PreparedStatement pstm = conn.prepareStatement(sql);
		int deleted = 0;
		pstm.setString(1, fullname);
		pstm.setString(2, address);
		pstm.setString(3, description);
		pstm.setInt(4, deleted);
		pstm.executeUpdate();
	}

	public static List<Garage> findListGarages(Connection conn, String require, int deleted) throws SQLException {
		String sql = "Select * from Garage a where (a.fullname like N'%" + require + "%' or a.address like '%" + require
				+ "%') and a.deleted = " + deleted;
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Garage> list = new ArrayList<Garage>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fullname = rs.getString("fullname");
			String address = rs.getString("address");
			String description = rs.getString("description");
			Garage garage = new Garage();
			garage.setId(id);
			garage.setFullname(fullname);
			garage.setAddress(address);
			garage.setDescription(description);
			garage.setDeleted(deleted);
			list.add(garage);
		}

		return list;
	}

	public List<Garage> listGaragesDesist(Connection conn) throws SQLException {
		String sql = "select * from Garage where deleted = 1";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Garage> list = new ArrayList<Garage>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fullname = rs.getString("fullname");
			String address = rs.getString("address");
			String description = rs.getString("description");
			int deleted = rs.getInt("deleted");
			Garage garage = new Garage();
			garage.setId(id);
			garage.setFullname(fullname);
			garage.setAddress(address);
			garage.setDescription(description);
			garage.setDeleted(deleted);
			list.add(garage);
		}

		return list;
	}

	public static void updateGarage(Connection conn, int id, String fullname, String address, String description)
			throws SQLException {
		String sql = "UPDATE Garage SET fullname = ?, address = ?, description = ? WHERE id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, fullname);
		pstm.setString(2, address);
		pstm.setString(3, description);
		pstm.setInt(4, id);
		pstm.executeUpdate();
	}

	public static void setGarageDesist(Connection conn, int id) throws SQLException {
		String sql = "update Garage set deleted = '1' where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}

	public static void setGarageAcctive(Connection conn, int id) throws SQLException {
		String sql = "update Garage set deleted = '0' where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}

//	public Garage findGArageId(Connection conn,String userManager) throws SQLException{
//		String garage_id = "select garage_id from Manager where phone_number = "
//				+ userManager;
//		PreparedStatement pre = null;
//		
//		try {
//			pre = conn.prepareStatement(sql);
//			pre.set
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
