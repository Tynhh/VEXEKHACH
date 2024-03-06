package controller.MANAGER;

import java.io.IOException;
import java.sql.Connection;

import DAO.SeatDAO;
import DAO.TripDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class AddTripServlet
 */
@WebServlet(urlPatterns = { "/addTrip" })
public class AddTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTripServlet() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.MANAGER_ADDTRIP);
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
		HttpSession session = request.getSession();
		String departure = new String(request.getParameter("departure").getBytes("ISO-8859-1"), "UTF-8");
		String destination = new String(request.getParameter("destination").getBytes("ISO-8859-1"), "UTF-8");
		String departure_time = new String(request.getParameter("departure_time").getBytes("ISO-8859-1"), "UTF-8");
		String price = new String(request.getParameter("price").getBytes("ISO-8859-1"), "UTF-8");
		String num_seat = new String(request.getParameter("num_seat").getBytes("ISO-8859-1"), "UTF-8");
		String trip_board = new String(request.getParameter("trip_board").getBytes("ISO-8859-1"), "UTF-8");
		String userManager = (String) session.getAttribute("userManager");
		int priceM = Integer.parseInt(price);
		int numSeat = Integer.parseInt(num_seat);
		TripDAO tripDAO = new TripDAO();
		SeatDAO seatDAO = new SeatDAO();
		String errorString = null;
		int numSeat1 = Integer.parseInt(num_seat);
		try {
			int checkTripID = 0;
			checkTripID = tripDAO.addTrip(conn, departure, destination, departure_time, priceM, numSeat1, trip_board,
					userManager);
			int tripId = 0;
			tripId = tripDAO.getIdTrip(conn, trip_board, departure_time);
			if (checkTripID == 0) {
				if (numSeat1 == 16) {
					for (int i = 1; i < 8; i += 2) {
						int a = i;
						int b = i + 1;
						String ghe1 = "A" + a;
						String ghe2 = "A" + b;
						String ghe3 = "B" + a;
						String ghe4 = "B" + b;
						seatDAO.insertSeat(conn, ghe1, tripId);
						seatDAO.insertSeat(conn, ghe2, tripId);
						seatDAO.insertSeat(conn, ghe3, tripId);
						seatDAO.insertSeat(conn, ghe4, tripId);
					}
				} else {
					for (int i = 1; i < 8; i += 2) {
						int a = i;
						int b = i + 1;
						String ghe1 = "A" + a;
						String ghe2 = "A" + b;
						String ghe3 = "B" + a;
						String ghe4 = "B" + b;
						String ghe5 = "C" + a;
						String ghe6 = "C" + b;
						seatDAO.insertSeat(conn, ghe1, tripId);
						seatDAO.insertSeat(conn, ghe2, tripId);
						seatDAO.insertSeat(conn, ghe3, tripId);
						seatDAO.insertSeat(conn, ghe4, tripId);
						seatDAO.insertSeat(conn, ghe5, tripId);
						seatDAO.insertSeat(conn, ghe6, tripId);
					}
				}
			} else {
				errorString = "Tồn tại chuyến xe này rồi, vui lòng kiểm tra lại thông tin!";
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			errorString = e.getMessage();
		}
		System.out.println(errorString);
		if (errorString != null) {
			System.out.println(errorString);
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.MANAGER_ADDTRIP);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/tripManagement");
		}
	}

}
