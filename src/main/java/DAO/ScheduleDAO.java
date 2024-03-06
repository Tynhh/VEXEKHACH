package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Schedule;

public class ScheduleDAO {
	
	public static ArrayList<Schedule> getListSchedule(Connection con, int garage_id)
	{
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		String sql = "SELECT * FROM Schedule WHERE garage_id =  " + garage_id;
		
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				Schedule schedule = new Schedule();
				schedule.setId(res.getInt("id"));
				schedule.setMusty(res.getString("musty"));
				schedule.setStatus(res.getInt("status"));
				list.add(schedule);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

		public String getDiemDon(Connection con, String diemDon)
	{
		String sql = "SELECT musty FROM Schedule WHERE id =  " + diemDon;
		
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			while (res.next()) {
				//Schedule schedule = new Schedule();
				String musty = res.getString("musty");
				System.out.println(musty);
				return musty;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
