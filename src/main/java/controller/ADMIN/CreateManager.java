package controller.ADMIN;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.GarageDAO;
import DAO.ManagerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Garage;
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class CreateManager
 */
@WebServlet(urlPatterns = { "/createManager" })
public class CreateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateManager() {
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
		GarageDAO garageDAO = new GarageDAO();
		String idGarage = request.getParameter("id");
		int id_Garage = Integer.parseInt(idGarage);
		Garage garage = null;
		String errorString = null;
		try {
			garage = garageDAO.getInfoGarage(conn, idGarage);
			System.out.println("99999999999999999999999999999999999");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && garage == null) {
			response.sendRedirect(request.getServletPath() + "/garageacctive");
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("garage", garage);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.ADMIN_CREATEMANAGER);
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
		String id = request.getParameter("id");
		int garage_id = Integer.parseInt(id);
		//String fullname = new String(request.getParameter("fullname").getBytes("UTF-8"));
		String fullname = request.getParameter("fullname"); 
		byte[] bytes1 = fullname.getBytes(StandardCharsets.ISO_8859_1);
		fullname = new String(bytes1, StandardCharsets.UTF_8);
		
		//String phone_number = new String(request.getParameter("phone_number").getBytes("ISO-8859-1"), "UTF-8");
		String phone_number = request.getParameter("phone_number"); 
		byte[] bytes2 = phone_number.getBytes(StandardCharsets.ISO_8859_1);
		phone_number = new String(bytes2, StandardCharsets.UTF_8);
	
		//String email = new String(request.getParameter("email").getBytes("ISO-8859-1"), "UTF-8");
		String email = request.getParameter("email"); 
		byte[] bytes3 = email.getBytes(StandardCharsets.ISO_8859_1);
		email = new String(bytes3, StandardCharsets.UTF_8);
		
		//String password = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password"); 
		byte[] bytes4 = password.getBytes(StandardCharsets.ISO_8859_1);
		password = new String(bytes4, StandardCharsets.UTF_8);
		
		ManagerDAO managerDAO = new ManagerDAO();
		String errorString = null;

		try {
			int checkManaID = 0;
			checkManaID = managerDAO.insertManager(conn, fullname, phone_number, email, password, garage_id);
			if (checkManaID == 1) {
				errorString = "Email này đã tồn tại, vui lòng nhập Email khác!";
			}
			if (checkManaID == 2) {
				errorString = "Số điện thoại này đã tồn tại, vui lòng nhập số điện thoại khác!";
			}
			if (checkManaID == 3) {
				errorString = "Số điện thoại và Email này đã tồn tại, vui lòng nhập Số điện thoại và Email khác!";
			}
			// DAO.NotifiDAO.DoneSave(true);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
			// DAO.NotifiDAO.DoneSave(false);
		}
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			GarageDAO garageDAO = new GarageDAO();
			System.out.println(errorString);
			String idGarage = request.getParameter("id");
			Garage garage = null;
			garage = garageDAO.getInfoGarage(conn, idGarage);
			request.setAttribute("garage", garage);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.ADMIN_CREATEMANAGER);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher(Router.ADMIN_GARAGEMANAGEMENT);
			dispatcher.forward(request, response);
		}

	}

}
