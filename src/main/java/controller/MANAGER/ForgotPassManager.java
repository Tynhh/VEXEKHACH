package controller.MANAGER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.ManagerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Manager;
import utils.MyUtils;
import utils.Router;
import utils.SendEmail;

/**
 * Servlet implementation class ForgotPassManager
 */
@WebServlet("/forgotPassManager")
public class ForgotPassManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPassManager() {
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
		String numberPhone = request.getParameter("numberPhoneForgotPassword");

		Manager manager = null;
		boolean hasError = false;
		String errorString = null;
		String notifiString = null;

		if (numberPhone == null || numberPhone.length() == 0) {
			hasError = true;
			errorString = "Required number phone and password!";
			System.out.println("111111111111111");
		} else {
			try {
				// Tìm user trong DB.
				manager = ManagerDAO.findManagerByPhone(conn, numberPhone);
				System.out.println("222222222222222222");
				if (manager == null) {
					hasError = true;
					errorString = "Number phone invalid";
					System.out.println("33333333333333333");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				System.out.println("44444444444");
				errorString = e.getMessage();
			}
		}
		// Trong trường hợp có lỗi,
		if (hasError) {
			manager = new Manager();
			manager.setPhone_number(numberPhone);

			// Lưu các thông tin vào request attribute trước khi forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("manager", manager);
			System.out.println("5555555555555555555");
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher(Router.LOGIN_MANAGER);

			dispatcher.forward(request, response);
		} else {
			try {
				// Cập nhật password trong DB.
				errorString = "Yêu cầu đặt lại mật khẩu thành công, vui lòng kiểm tra email của bạn !";
				request.setAttribute("errorString", errorString);
				String pass = MyUtils.generatePassword(8);
				ManagerDAO.updatePassword(conn, pass, numberPhone);
				manager = ManagerDAO.findManagerByPhone(conn, numberPhone);
				String noiDung = "Xin chào " + manager.getFullname()
						+ " đây là mật khẩu mới của bạn, vui lòng không cung cấp thông tin này cho bất kỳ ai khác.\n Mật khẩu mới của bạn là: "
						+ pass;
				SendEmail.getInstant().guiMailManager(manager.getEmail(), noiDung);
				String mes = "Email của quý khách đã gửi thành công!";
				request.setAttribute("mes", mes);
				notifiString = "Yêu cầu lấy lại mật khẩu thành công, vui lòng kiểm tra email của bạn!";
				request.setAttribute("notifi", notifiString);
				// response.sendRedirect(request.getContextPath() + "/managerHome");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(Router.LOGIN_MANAGER);
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
				response.sendRedirect(request.getContextPath() + Router.LOGIN_MANAGER);
			}
		}
	}

}
