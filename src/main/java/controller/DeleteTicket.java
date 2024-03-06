package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connect_db.MySQLConnUtils;

/**
 * Servlet implementation class DeleteTicket
 */
@WebServlet(urlPatterns = { "/deleteTicket" })
public class DeleteTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 String idStr =  new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
	        String seat = (String)request.getParameter("seat");
	        String custom = (String)request.getParameter("custom");

	        int id = 0;
	        int idseat = 0;
	        int idcustom = 0;
	       
	        try {
	            id = Integer.parseInt(idStr);
	            idseat = Integer.parseInt(seat);
	            idcustom = Integer.parseInt(custom);
	        } catch (Exception e) {
	        	System.out.println("Lỗi ID 1:  "+ id);
	            
	        }
	
	        String errorString = "'null'";
	       
	        try {
	            DAO.TicketDAO.deleteTicket(conn, id,idseat,idcustom);
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	            errorString = "'error1'";
	        }
	        request.setAttribute("errorString", errorString);
	        RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/quanlyve");
			dispatcher.forward(request, response);
	       // response.sendRedirect(request.getContextPath() + "/quanlyve");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
