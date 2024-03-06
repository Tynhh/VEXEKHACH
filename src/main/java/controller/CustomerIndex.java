package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.TripDAO;

/**
 * Servlet implementation class CustomerIndex
 */
@WebServlet(name = "getData", urlPatterns = { "/getData" })
public class CustomerIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> list_departure = new ArrayList<String>();
		ArrayList<String> list_destination = new ArrayList<String>();
		
		Connection conn = MyUtils.getStoredConnection(request);
		list_departure = TripDAO.getListDeparture(conn);
		list_destination = TripDAO.getListDestination(conn);
		
		request.setAttribute("list_departure", list_departure);
		request.setAttribute("list_destination", list_destination);
		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
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
