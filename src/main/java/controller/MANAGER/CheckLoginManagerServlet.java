package controller.MANAGER;

import java.io.IOException;
import java.sql.Connection;

import DAO.ManagerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Manager;
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class CheckLoginManagerServlet
 */
@WebServlet(urlPatterns = { "/managerHome" })
public class CheckLoginManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLoginManagerServlet() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.LOGIN_MANAGER);
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
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		HttpSession session = request.getSession();
		// ManagerDAO managerDAO = new ManagerDAO();
		Manager manager = null;
		boolean hasError = false;
		String errorString = null;
		if (userName == null || password == null) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			try {
				manager = ManagerDAO.findManager(conn, userName, password);
				if (manager == null) {
					hasError = true;
					errorString = "Tài khoản hoặc mật khẩu không đúng!";
				} else {
					int check = ManagerDAO.checkDesist(conn, userName, password);
					if (check == 1) {
						errorString = "Tài khoản của bạn đã bị khóa!";
						hasError = true;
					}
					System.out.println(check);
					session.setAttribute("userManager", userName);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		if (hasError) {
			request.setAttribute("errorString", errorString);
			System.out.println(errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.LOGIN_MANAGER);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.MANAGER_HOME);
			dispatcher.forward(request, response);
		}
	}

}
