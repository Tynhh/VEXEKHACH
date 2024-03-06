package controller.ADMIN;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import DAO.GarageDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Garage;
import utils.MyUtils;
import utils.Router;

/**
 * Servlet implementation class GarageAcctiveServlet
 */
@WebServlet(urlPatterns = { "/garageacctive" })
public class GarageAcctiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GarageAcctiveServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		List<Garage> list = null;
		GarageDAO garageDAO = new GarageDAO();
		try {
			list = garageDAO.listGaragesActivate(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.setAttribute("listGaragesActivate", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.ADMIN_GARAGEMANAGEMENT);
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
