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
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class CreateGarageServlet
 */
@WebServlet(urlPatterns = { "/createGarage" })
public class CreateGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGarageServlet() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.ADMIN_CREATEGARAGE);
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
		
		//String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"), "UTF-8");
		String fullname = request.getParameter("fullname"); 
		System.out.print(fullname);
		byte[] bytes1 = fullname.getBytes(StandardCharsets.ISO_8859_1);
		fullname = new String(bytes1, StandardCharsets.UTF_8);
		System.out.print(fullname);
		
		//String address = new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
		String address = request.getParameter("address"); 
		byte[] bytes2 = address.getBytes(StandardCharsets.ISO_8859_1);
		address = new String(bytes2, StandardCharsets.UTF_8);
		
		//String description = new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8");
		
		String description = request.getParameter("description"); 
		byte[] bytes3 = description.getBytes(StandardCharsets.ISO_8859_1);
		description = new String(bytes3, StandardCharsets.UTF_8);
		GarageDAO garageDAO = new GarageDAO();
		String errorString = null;

		try {
			garageDAO.insertGarage(conn, fullname, address, description);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("errorString", errorString);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher(Router.ADMIN_GARAGEMANAGEMENT);
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/garageacctive");
		}
	}

}
