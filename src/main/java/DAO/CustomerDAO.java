package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Ticket;

public class CustomerDAO {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	public static Customer findUser(Connection conn, String numberPhone, String password) throws SQLException {

		String sql = "Select * from Customer " //
				+ " where phone_number = ? and password= ?";
		System.out.println("CustomerDAO_findUser");
		System.out.println("sql"+sql);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, numberPhone);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String userName = rs.getString("fullname");
			String email = rs.getString("email");
			Customer user = new Customer();
			user.setEmail(email);
			user.setFullname(userName);
			user.setPassword(password);
			user.setPhone_number(numberPhone);
			return user;
		}
		return null;
	}

	public static Customer findUser(Connection conn, String phone_number) throws SQLException {

		String sql = "Select * from Customer a "//
				+ " where a.phone_number = ? ";
		System.out.println("CustomerDAO_findUser");
		System.out.println("sql"+sql);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, phone_number);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Customer user = new Customer();
			int id = rs.getInt("id");
			String userName = rs.getString("fullname");
			String email = rs.getString("email");
			user.setId(id);
			user.setEmail(email);
			user.setFullname(userName);

			return user;
		}
		return null;
	}

	public static void updatePassword(Connection conn, String password, String numberPhone) throws SQLException {
		String sql = "Update Customer set password =? where phone_number=? ";
		System.out.println("CustomerDAO_updatePassword");
		System.out.println("sql"+sql);
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, password);
		pstm.setString(2, numberPhone);
		pstm.executeUpdate();
	}
	public static List<Customer> getlistCustomer(Connection conn)
			throws SQLException {
			String sql = "SELECT * FROM Customer";
			System.out.println("CustomerDAO_getlistCustomer");
			System.out.println("sql"+sql);
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("fullname");
				String phone = rs.getString("phone_number");
				String email = rs.getString("email");
				String pass = rs.getString("password");
				Customer mh = new Customer();
				mh.setId(id);
				mh.setFullname(ten);
				mh.setPhone_number(phone);
				mh.setEmail(email);
				mh.setPassword(pass);
				list.add(mh);
			}
			
			return list;
		}
	public static void deleteCustomer(Connection conn, int idIn) throws SQLException {
        String sql = "Delete from Customer where id=?";
        System.out.println("CustomerDAO_deleteCustomer");
		System.out.println("sql"+sql);
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, idIn);  
 
        pstm.executeUpdate();
    }
	public static Customer findCustomer(Connection conn, int idIn) throws SQLException {
        String sql = "Select a.id, a.fullname, a.phone_number, a.email, a.password from Customer a where a.id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, idIn);
        
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	 int ID = rs.getInt("id");
        	String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String email = rs.getString("email");
			String pass = rs.getString("password");
             Customer mh = new Customer(ID,ten,phone,email,pass);
           
            return mh;
        }
        return null;
    }
	public static void updateCustomer(Connection conn, Customer mh) throws SQLException {
        String sql = "Update Customer set fullname=?, phone_number=?, email=?, password=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, mh.getFullname());
        pstm.setString(2, mh.getPhone_number());
        pstm.setString(3, mh.getEmail());
        pstm.setString(4, mh.getPassword());
        pstm.setInt(5, mh.getId());
        pstm.executeUpdate();
    }
	public static void insertCustomer(Connection conn, Customer mh) throws SQLException {
        String sql = "Insert into Customer(fullname,phone_number,email,password) values (?, ?, ?, ?)";
 //
        PreparedStatement pstm = conn.prepareStatement(sql);
      
        pstm.setString(1, mh.getFullname());
        pstm.setString(2, mh.getPhone_number());
        pstm.setString(3, mh.getEmail());
        pstm.setString(4, mh.getPassword());
        
        pstm.executeUpdate();
    }
	public static List<Customer> findCustomer(Connection conn, String require) throws SQLException {
		
        String sql = "Select a.id, a.fullname, a.phone_number, a.email, a.password from Customer a where a.fullname like '%"+require +"%' or a.phone_number like '%"
        		+ require +"%' or a.email like '%" + require + "%' or a.password like '%" + require + "%'";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        System.out.println(sql);
     
        ResultSet rs = pstm.executeQuery();
        List<Customer> list = new ArrayList<Customer>();
        while (rs.next()) {
        	
        	int id = rs.getInt("id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String email = rs.getString("email");
			String pass = rs.getString("password");
			Customer mh = new Customer();
			mh.setId(id);
			mh.setFullname(ten);
			mh.setPhone_number(phone);
			mh.setEmail(email);
			mh.setPassword(pass);
			list.add(mh);
        }
        return list;
    }
}
