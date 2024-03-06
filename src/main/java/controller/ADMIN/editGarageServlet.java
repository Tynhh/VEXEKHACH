package controller.ADMIN;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.GarageDAO;
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
 * Servlet implementation class editGarageServlet
 */
@WebServlet(urlPatterns = { "/editGarage" })
public class editGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editGarageServlet() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.ADMIN_EDITGARAGE);
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
		GarageDAO garageDAO = new GarageDAO();
		String idGarage = request.getParameter("id");
		int id_Garage = Integer.parseInt(idGarage);
		System.out.println(id_Garage);
		//String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"), "UTF-8");
		String fullname = request.getParameter("fullname"); 
		byte[] bytes1 = fullname.getBytes(StandardCharsets.ISO_8859_1);
		fullname = new String(bytes1, StandardCharsets.UTF_8);
		
		//String address = new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
		String address = request.getParameter("address"); 
		byte[] bytes2 = address.getBytes(StandardCharsets.ISO_8859_1);
		address = new String(bytes2, StandardCharsets.UTF_8);
		
		//String description = new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8");
		String description = request.getParameter("description"); 
		byte[] bytes3 = description.getBytes(StandardCharsets.ISO_8859_1);
		description = new String(bytes3, StandardCharsets.UTF_8);
		

		String errStr = null;

		try {
			garageDAO.updateGarage(conn, id_Garage, fullname, address, description);
		} catch (SQLException e) {
			e.printStackTrace();
			errStr = e.getMessage();
		}

		request.setAttribute("errorString", errStr);

		if (errStr != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher(Router.ADMIN_GARAGEMANAGEMENT);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/garageacctive");
		}
	}

}
