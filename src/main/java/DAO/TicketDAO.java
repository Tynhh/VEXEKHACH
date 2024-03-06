package DAO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import model.Ticket;

public class TicketDAO {

	public static List<Ticket> getlistTicket(Connection conn, String phonenumber) throws SQLException {
		String garage_id = "select garage_id from Manager where phone_number = " + phonenumber;
		PreparedStatement pstm1 = conn.prepareStatement(garage_id);
		ResultSet rs1 = pstm1.executeQuery();
		int _garageid = 0;

		if (rs1.next()) {
			_garageid = rs1.getInt("garage_id");
		}
		String sql = "Select tk.trip_id,c.fullname,c.phone_number,t.departure,sc.musty,s.number_chair,t.trip_board, t.departure_time,t.price,  tk.seat_id, tk.customer_id  From Ticket tk, Trip t, Seat s, Customer c, Schedule sc Where tk.trip_id=t.id and t.garage_id=? and tk.seat_id=s.id and tk.schedule_id=sc.id and tk.customer_id=c.id ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, _garageid);

		ResultSet rs = pstm.executeQuery();
		List<Ticket> list = new ArrayList<Ticket>();
		while (rs.next()) {
			int id = rs.getInt("trip_id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String starts = rs.getString("departure");
			String musty = rs.getString("musty");
			String numberchair = rs.getString("number_chair");
			String board = rs.getString("trip_board");
			String timestart = rs.getString("departure_time");
			int price = rs.getInt("price");
			
			int seatid  = rs.getInt("seat_id");
			int customid = rs.getInt("customer_id");
			Ticket mh = new Ticket();
			mh.setTripid(id);
			mh.setFullname(ten);
			mh.setPhonenumber(phone);
			mh.setStarts(starts);
			mh.setMusty(musty);
			mh.setNumberchair(numberchair);
			mh.setTripbroad(board);
			mh.setStartstime(timestart);
			mh.setPrice(price);
			mh.setSeatid(seatid);
			mh.setCustomerid(customid);
			list.add(mh);
		}

		return list;
	}

	public static List<Ticket> findTicket(Connection conn, String require, String phonenumber) throws SQLException {
		String garage_id = "select garage_id from Manager where phone_number = " + phonenumber;
		PreparedStatement pstm1 = conn.prepareStatement(garage_id);
		ResultSet rs1 = pstm1.executeQuery();
		int _garageid = 0;

		if (rs1.next()) {
			_garageid = rs1.getInt("garage_id");
		}
		String sql = "Select tk.trip_id,c.fullname,c.phone_number,t.departure ,sc.musty,s.number_chair,t.trip_board,t.departure_time ,t.price,  tk.seat_id, tk.customer_id From Ticket tk, Trip t, Seat s, Customer c, Schedule sc Where tk.trip_id=t.id and t.garage_id=? and tk.seat_id=s.id and tk.schedule_id=sc.id and tk.customer_id=c.id and c.phone_number like '%"
				+ require + "%'";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, _garageid);
		ResultSet rs = pstm.executeQuery();
		List<Ticket> list = new ArrayList<Ticket>();
		while (rs.next()) {

			int id = rs.getInt("trip_id");
			String ten = rs.getString("fullname");
			String phone = rs.getString("phone_number");
			String starts = rs.getString("departure");
			String musty = rs.getString("musty");
			String numberchair = rs.getString("number_chair");
			String board = rs.getString("trip_board");
			String timestart = rs.getString("departure_time");
			int price = rs.getInt("price");
			
			int seatid  = rs.getInt("seat_id");
			int customid = rs.getInt("customer_id");
			Ticket mh = new Ticket();
			mh.setTripid(id);
			mh.setFullname(ten);
			mh.setPhonenumber(phone);
			mh.setStarts(starts);
			mh.setMusty(musty);
			mh.setNumberchair(numberchair);
			mh.setTripbroad(board);
			mh.setStartstime(timestart);
			mh.setPrice(price);
			mh.setSeatid(seatid);
			mh.setCustomerid(customid);
			list.add(mh);
		}
		return list;
	}
	public static void getData(Connection conn, File ticket,String phone) throws SQLException,ServletException, IOException {
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(ticket), Charset.forName("UTF-8"));
	    PrintWriter out = new PrintWriter(outputStreamWriter);
		
		out.println("id\t Họ Tên\t Số điện thoại\t Điểm đón\t Điểm đến\t Số ghế\t Biển số xe\t Thời gian\t Giá");
		List<Ticket> list = getlistTicket(conn,phone);
		for (Ticket emp : list) {			
           out.println(emp.getTripid() + "\t " + emp.getFullname() + "\t " + emp.getPhonenumber() + "\t " + emp.getStarts() + "\t " + emp.getMusty() + "\t " + emp.getNumberchair() + "\t " + emp.getTripbroad() + "\t " + emp.getStartstime() + "\t " + emp.getPrice());            
        }
		out.close();
	}
	public static void deleteTicket(Connection conn, int idIn, int seatid, int customid) throws SQLException {
        String sql = "Delete from Ticket where trip_id=? and seat_id=? and customer_id=?";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        pstm.setInt(1, idIn);  
        pstm.setInt(2, seatid); 
        pstm.setInt(3, customid);  
        pstm.executeUpdate();
    }
}
