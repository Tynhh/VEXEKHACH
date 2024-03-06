package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Schedule;
import model.Seat;
import model.Trip;
import utils.MyUtils;
import utils.Router;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.ScheduleDAO;
import DAO.SeatDAO;
import DAO.TripDAO;

/**
 * Servlet implementation class SearchTripServlet
 */

@WebServlet(urlPatterns = { "/seachTrip" })
public class SearchTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String departure = request.getParameter("departure");
		String destination = request.getParameter("destination");
		String date = request.getParameter("departure_time");
		
		HttpSession session=request.getSession();
		session.setAttribute("departure", departure);
		session.setAttribute("destination", destination);
		session.setAttribute("departure_time", date);
		
		ArrayList<Trip> list_trip = new ArrayList<Trip>();
		Connection conn = MyUtils.getStoredConnection(request);
		
		list_trip = TripDAO.getListTrip(conn, departure, destination, date);
		System.out.println(list_trip.get(0).garage.getAddress());
		
		for (int i = 0; i < list_trip.size(); i++)
		{
			int trip_id = list_trip.get(i).getId();
			int garage_id = list_trip.get(i).garage.getId();
			ArrayList<Seat> list_seat = new ArrayList<Seat>();
			ArrayList<Schedule> list_musty = new ArrayList<Schedule>();
			
			list_seat = SeatDAO.getListSeat(conn, trip_id);
			list_trip.get(i).setList_seat(list_seat);
			
			list_musty = ScheduleDAO.getListSchedule(conn, garage_id);
			list_trip.get(i).setList_musty(list_musty);
		}
		
		request.setAttribute("list_trip", list_trip);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.PAGE_BUY_TICKET);
		dispatcher.forward(request, response);
		
	}

}
