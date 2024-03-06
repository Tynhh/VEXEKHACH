package controller.ADMIN;

import java.io.IOException;
import java.sql.Connection;

import DAO.AdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class CheckLoginAdminServlet
 */
@WebServlet(urlPatterns = { "/adminHome" })
public class CheckLoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLoginAdminServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.print(userName);
		System.out.print(password);
		Admin admin = null;
		boolean hasError = false;
		String errorString = null;
		if (userName == null || password == null) {
			hasError = true;
			errorString = "Required username and password!";
			// RequestDispatcher dispatcher =
			// this.getServletContext().getRequestDispatcher(Router.ADMIN_HOME);
			// dispatcher.forward(request, response);
		} else {
			try {
				admin = AdminDAO.findAdmin(conn, userName, password);
				if (admin == null) {
					hasError = true;
					errorString = "Username or password invalid";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		if (hasError) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.ADMIN_LOGIN);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.THONGKE);
			dispatcher.forward(request, response);
		}
	}

}
