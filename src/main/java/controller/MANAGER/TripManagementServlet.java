package controller.MANAGER;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import DAO.TripDAO;
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

/**
 * Servlet implementation class TripManagementServlet
 */
@WebServlet(name = "tripManagement", urlPatterns = { "/tripManagement" })
public class TripManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TripManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Connection conn = null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		List<Trip> list = null;
		TripDAO tripDAO = new TripDAO();
		String userManager = (String) session.getAttribute("userManager");
		try {
			list = tripDAO.listTrips(conn, userManager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.setAttribute("listTrips", list);
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher(Router.MANAGER_TRIPMANAGEMENT);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
