package controller.MANAGER;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Trip;
import utils.MyUtils;
import utils.Router;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.TripDAO;

/**
 * Servlet implementation class EditTripServlet
 */
@WebServlet(urlPatterns = { "/editTrip" })
public class EditTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTripServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		TripDAO tripDAO = new TripDAO();
		String idTrip = request.getParameter("id");
		int id_Trip = Integer.parseInt(idTrip);
		Trip trip = null;
		String errorString = null;
		try {
			trip = tripDAO.getTripFromTripID(conn, id_Trip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && trip == null) {
			response.sendRedirect(request.getServletPath() + "/tripManagement");
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("trip", trip);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.MANAGER_EDITTRIP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		TripDAO tripDAO = new TripDAO();
		String idTrip = request.getParameter("id");
		int id_Trip = Integer.parseInt(idTrip);
		String departure = new String(request.getParameter("departure").getBytes("ISO-8859-1"), "UTF-8");
		String destination = new String(request.getParameter("destination").getBytes("ISO-8859-1"), "UTF-8");
		String departure_time = new String(request.getParameter("departure_time").getBytes("ISO-8859-1"), "UTF-8");
		String price = new String(request.getParameter("price").getBytes("ISO-8859-1"), "UTF-8");
		String num_seat = new String(request.getParameter("num_seat").getBytes("ISO-8859-1"), "UTF-8");
		String trip_board = new String(request.getParameter("trip_board").getBytes("ISO-8859-1"), "UTF-8");
		int priceM = Integer.parseInt(price);
		int numSeat = Integer.parseInt(num_seat);

		String errStr = null;

		try {
			tripDAO.updateTrip(conn, departure, destination, departure_time, priceM, numSeat, trip_board, id_Trip);
		} catch (SQLException e) {
			e.printStackTrace();
			errStr = e.getMessage();
		}

		request.setAttribute("errorString", errStr);

		if (errStr != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher(Router.MANAGER_TRIPMANAGEMENT);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/tripManagement");
		}
	}

}
