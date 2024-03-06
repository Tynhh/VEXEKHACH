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
 * Servlet implementation class GarageDesistServlet
 */
@WebServlet(urlPatterns = { "/garageDesist" })
public class GarageDesistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GarageDesistServlet() {
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
			list = garageDAO.listGaragesDesist(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.setAttribute("listGaragesDesist", list);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(Router.ADMIN_GARAGEDESIST);
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
