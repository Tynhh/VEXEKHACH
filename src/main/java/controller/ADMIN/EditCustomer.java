package controller.ADMIN;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connect_db.MySQLConnUtils;
import connect_db.SQLServerConnUtils_SQLJDBC;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 * Servlet implementation class EditCustomer
 */
@WebServlet(urlPatterns = { "/editCustomer" })
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCustomer() {
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
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String idStr = (String) request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);			
		} catch (Exception e) {
		}

		Customer mh = null;

		String errorString = null;

		try {
			mh = DAO.CustomerDAO.findCustomer(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		if (errorString != null && mh == null) {
			response.sendRedirect(request.getServletPath() + "/customerList");
			return;
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", mh);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/views/adminView/editCustomer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String idStr = (String) request.getParameter("id");
		String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"), "UTF-8");
		String phone_number = new String(request.getParameter("phone_number").getBytes("ISO-8859-1"), "UTF-8");
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");

		int id = 0;

		try {
			id = Integer.parseInt(idStr);

		} catch (Exception e) {
		}

		Customer mh = new Customer(id, fullname, phone_number, email, password);

		String errorString = "'null'";

		try {
			DAO.CustomerDAO.updateCustomer(conn, mh);
		
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
			errorString = "'Lỗi! vui lòng xem lại.'";
			
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", mh);

	//	if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/views/adminView/editCustomer.jsp");
			dispatcher.forward(request, response);
	//	}

	//	else {
		//	response.sendRedirect(request.getContextPath() + "/customerList");
	//	}
	}

}
