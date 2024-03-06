package controller;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import javax.swing.JFrame;

import connect_db.MySQLConnUtils;
import connect_db.SQLServerConnUtils_SQLJDBC;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(urlPatterns = { "/exportTicket"})
/**
 * Servlet implementation class ExportTicket
 */
public class ExportTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportTicket() {
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
		JFrame filesave = new JFrame();
		FileDialog fd = new FileDialog(filesave, "Choose a file", FileDialog.SAVE);	
		fd.setDirectory("C:\\");
		fd.setFile("*.csv");
	
		fd.setVisible(true);
		String path = fd.getDirectory()+fd.getFile();
		System.out.println("File ...  "+path);
		String errorfile = "'done'";
		if (fd.getFile() == null)
		{
			 errorfile = "'null'";
		}
		
		File myObj = new File(path);
		HttpSession session = request.getSession();
		String userManager = (String) session.getAttribute("userManager");
		String errorString = "'done'";
		try {
			DAO.TicketDAO.getData(conn, myObj,userManager);
			
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = "'error'";
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("errorFile",errorfile);
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/quanlyve");
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
