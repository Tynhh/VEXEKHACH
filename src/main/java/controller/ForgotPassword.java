package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import utils.MyUtils;
import utils.Router;
import utils.SendEmail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.CustomerDAO;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		//String numberPhone = request.getParameter("numberPhoneForgotPassword");
		String numberPhone= request.getParameter("numberPhoneForgotPassword");
		byte[] bytes2 = numberPhone.getBytes(StandardCharsets.ISO_8859_1);
		numberPhone = new String(bytes2, StandardCharsets.UTF_8);
		Customer user = null;
		boolean hasError = false;
		String errorString = null;
		
		if (numberPhone == null || numberPhone.length() == 0) {
			hasError = true;
			errorString = "Required number phone and password!";
		} else {
			try {
				// Tìm user trong DB.
				user = CustomerDAO.findUser(conn, numberPhone);
				
				if (user == null) {
					hasError = true;
					errorString = "Number phone invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		// Trong trường hợp có lỗi,
		if (hasError) {
			user = new Customer();
			user.setPhone_number(numberPhone);

			// Lưu các thông tin vào request attribute trước khi forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher(Router.LOGIN_NOTIFY);
			
			dispatcher.forward(request, response);
		}
		else {
			try {
				// Cập nhật password trong DB.
				String pass = MyUtils.generatePassword(8);
				CustomerDAO.updatePassword(conn, pass,numberPhone);
				user = CustomerDAO.findUser(conn, numberPhone);
				String noiDung = "Xin chào "  + user.getFullname() + " chúng tôi vừa cập nhật lại mật khẩu cho bạn, mật khẩu mới là: "  + pass;
				SendEmail.getInstant().guiMail(user.getEmail(), noiDung);
				String mes = "Email của quý khách đã gửi thành công!";
				request.setAttribute("mes", mes);
				response.sendRedirect(request.getContextPath() + Router.THONG_BAO);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
				response.sendRedirect(request.getContextPath() + Router.LOGIN_NOTIFY);
			}
		}
		
	}

}
