package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Garage;
import model.Seat;
import model.Trip;
import utils.MyUtils;
import utils.Router;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.GarageDAO;
import DAO.SeatDAO;
import DAO.TripDAO;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		Customer loginedUser = MyUtils.getLoginedUser(session);

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		request.setAttribute("user", loginedUser);
	
		String phone = (String) session.getAttribute("phone");
		session.getAttribute("priceSeat");
		session.getAttribute("numberChairSeat1");
		session.getAttribute("numberChairSeat2");
		session.getAttribute("numberChairSeat3");
		
		TripDAO trDAO = new TripDAO();
		Trip tr = new Trip();
		
		GarageDAO grDAO = new GarageDAO();
		Garage xe = new Garage();
		
		SeatDAO seatDAO = new SeatDAO();
		Seat seat = new Seat();
		ArrayList<String> list = new ArrayList<String>();
		try {
			tr = trDAO.getTripByTicket(conn, phone);
			session.setAttribute("tr", tr);
			String idGarage = String.valueOf(tr.getGarageID());
			xe = grDAO.getGarage(conn, idGarage);
			session.setAttribute("xe", xe);
			
			list = seatDAO.getListNumberChair(conn, phone);
			session.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher(Router.USER_INFO_VIEW);
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
