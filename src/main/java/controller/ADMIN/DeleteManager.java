package controller.ADMIN;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connect_db.MySQLConnUtils;
import connect_db.SQLServerConnUtils_SQLJDBC;

/**
 * Servlet implementation class DeleteManager
 */
@WebServlet(urlPatterns = { "/deleteManager" })
public class DeleteManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManager() {
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
		
        String idStr = (String)request.getParameter("id");

        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        Manager mg = null;
 
        String errorString = "'null'";

        try {
            DAO.ManagerDAO.deleteManager(conn, id);
         
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
            errorString = "'error'";
        }
        request.setAttribute("errorString", errorString);
        RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/views/adminView/accountManager.jsp");
		dispatcher.forward(request, response);
     //   response.sendRedirect(request.getContextPath() + "/managerList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
