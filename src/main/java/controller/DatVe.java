package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import utils.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.ChuyenDAO;
import DAO.CustomerDAO;
import DAO.ScheduleDAO;
import DAO.SeatDAO;
import model.Customer;
import model.Schedule;
import model.Seat;

/**
 * Servlet implementation class TimGhe
 */
@WebServlet("/dat_ve")
public class DatVe extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatVe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Connection con = MyUtils.getStoredConnection(request);
		ChuyenDAO c = new ChuyenDAO();
	
		boolean hasError = false;
		String errorString = null;
		//String idChuyen = (String) session.getAttribute("idChuyen");
		String idChuyen= request.getParameter("inputIdChuyenXe");
		System.out.println("id"+ idChuyen);
		/*
		 * byte[] bytes1 = idChuyen.getBytes(StandardCharsets.ISO_8859_1); idChuyen =
		 * new String(bytes1, StandardCharsets.UTF_8);
		 */
		
		String inputTripBoard= request.getParameter("inputTripBoard");
		byte[] bytes2 = inputTripBoard.getBytes(StandardCharsets.ISO_8859_1);
		inputTripBoard = new String(bytes2, StandardCharsets.UTF_8);
		
		String idGhe1= request.getParameter("seatID1");
		byte[] bytes3 = idGhe1.getBytes(StandardCharsets.ISO_8859_1);
		idGhe1 = new String(bytes3, StandardCharsets.UTF_8);
		session.setAttribute("idGhe1", idGhe1);
		String idGhe2= request.getParameter("seatID2");
		if(idGhe2 != null) {
			byte[] bytes4 = idGhe2.getBytes(StandardCharsets.ISO_8859_1);
			idGhe2 = new String(bytes4, StandardCharsets.UTF_8);
			session.setAttribute("idGhe2", idGhe2);
		}
		
		String idGhe3= request.getParameter("seatID3");
		if(idGhe3 != null) {
			byte[] bytes5 = idGhe3.getBytes(StandardCharsets.ISO_8859_1);
			idGhe3 = new String(bytes5, StandardCharsets.UTF_8);
			session.setAttribute("idGhe3", idGhe3);
		}
		
		String priceTrip= request.getParameter("priceTrip");
		System.out.println("priceTrip"+ priceTrip);
		/*
		 * byte[] bytes6 = priceTrip.getBytes(StandardCharsets.ISO_8859_1); priceTrip =
		 * new String(bytes6, StandardCharsets.UTF_8);
		 */
		
		String diemDon= request.getParameter("checkbox_"+idChuyen);
		byte[] bytes7 = diemDon.getBytes(StandardCharsets.ISO_8859_1);
		diemDon = new String(bytes7, StandardCharsets.UTF_8);
		
		String diemTra= request.getParameter("checkbox"+idChuyen);
		byte[] bytes8 = diemTra.getBytes(StandardCharsets.ISO_8859_1);
		diemTra = new String(bytes8, StandardCharsets.UTF_8);
		
		String tenKh= request.getParameter("nameUser"+idChuyen);
		byte[] bytes9 = tenKh.getBytes(StandardCharsets.ISO_8859_1);
		tenKh = new String(bytes9, StandardCharsets.UTF_8);
		
		String phoneUser= request.getParameter("phoneUser"+idChuyen);
		byte[] bytes10 = phoneUser.getBytes(StandardCharsets.ISO_8859_1);
		phoneUser = new String(bytes10, StandardCharsets.UTF_8);
		
		String email= request.getParameter("emailUser"+idChuyen);
		byte[] bytes11 = email.getBytes(StandardCharsets.ISO_8859_1);
		email = new String(bytes11, StandardCharsets.UTF_8);
		
		String pass = MyUtils.generatePassword(8);
		
		Customer user = null;
		try {
			if(idGhe1 !=null && idChuyen != null && diemDon != null && diemTra != null && tenKh !=null && phoneUser !=null && email != null) {
				ScheduleDAO sc = new ScheduleDAO();
				
				String _diemDon = sc.getDiemDon(con,diemDon).toString();
				String _diemTra =sc.getDiemDon(con,diemTra).toString();

				c.addKhachHang(con, tenKh, phoneUser, email, pass);
				session.setAttribute("tenKh", tenKh);
				session.setAttribute("phoneUser",phoneUser);
				session.setAttribute("email", email);
				session.setAttribute("_diemDon", _diemDon);
				session.setAttribute("_diemTra",_diemTra);

				try {
					// Tìm user trong DB.
					user = CustomerDAO.findUser(con, phoneUser);
					int idUser = user.getId();
					if (idChuyen != null && idGhe1 != null && String.valueOf(idUser) != null) {
//						int id = Integer.parseInt(idGhe);
						int idchuyen = Integer.parseInt(idChuyen);
						int idDiemDon = Integer.parseInt(diemDon);
						//int idDiemTra = Integer.parseInt(diemTra);
						Seat numberChairSeat1 = null;
						Seat numberChairSeat2 = null;
						Seat numberChairSeat3 = null;
						
						try {
							SeatDAO seatDAO = new SeatDAO();
							String noiDung = "";
							//lay seat de them vao ticket
							Seat seat = new Seat();
							int _nbSeats = 0;
							String priceSeat = "";
							//kiem tra tung seat hop le thi se them chuyen
							if(idGhe1!=null) {
								seat = seatDAO.getIdSeat(con, idGhe1);
								int idSeat = seat.getId();		
								if(String.valueOf(idSeat) != null) {
									seatDAO.updateStatusSeat(con,idSeat);
									c.addChuyen(con, idchuyen, idSeat,idDiemDon, idUser);
									numberChairSeat1 = seatDAO.getChairByIdSeat(con, idGhe1);
									session.setAttribute("numberChairSeat1",numberChairSeat1);
								}
								 _nbSeats =Integer.parseInt(seatDAO.getNumberSeat(con,idChuyen));
								 priceSeat = String.valueOf(_nbSeats * Integer.parseInt(priceTrip));
								 noiDung = "Chuyến số: " + idChuyen +"\nBiển số" + inputTripBoard + "\nGhế số: " + numberChairSeat1.getNumber_chair() + " " + " "+ "\nĐịa điểm đón: " + _diemDon + "\nĐịa điểm trả: " + _diemTra + "\nGìa vé: " + priceSeat + ".000đ"  
										+ "\nTài khoản để đăng nhập để kiểm tra vé là: Tên đăng nhập: " + phoneUser +" " + "\nMật khẩu: "+ pass;
							}
							if(idGhe2 != null) {
								seat = seatDAO.getIdSeat(con, idGhe2);
								int idSeat2 = seat.getId();
								if(String.valueOf(idSeat2) != null) {
									seatDAO.updateStatusSeat(con,idSeat2);
									c.addChuyen(con, idchuyen, idSeat2,idDiemDon, idUser);
									numberChairSeat2 = seatDAO.getChairByIdSeat(con, idGhe2);
									session.setAttribute("numberChairSeat2",numberChairSeat2);
								}
								 _nbSeats =Integer.parseInt(seatDAO.getNumberSeat(con,idChuyen));
								 priceSeat = String.valueOf(_nbSeats * Integer.parseInt(priceTrip));
								 noiDung = "Chuyến số: " + idChuyen +"\nBiển số" + inputTripBoard + "\nGhế số: " + numberChairSeat1.getNumber_chair() + " "+numberChairSeat2.getNumber_chair() +  " "+ "\nĐịa điểm đón: " + _diemDon + "\nĐịa điểm trả: " + _diemTra + "\nGìa vé: " + priceSeat + ".000đ"  
										+ "\nTài khoản để đăng nhập để kiểm tra vé là: Tên đăng nhập: " + phoneUser +" " + "\nMật khẩu: "+ pass;
							}
							
							if(idGhe3 != null) {
								seat = seatDAO.getIdSeat(con, idGhe3);
								int idSeat3 = seat.getId();
								if(String.valueOf(idSeat3) != null) {
									seatDAO.updateStatusSeat(con,idSeat3);
									c.addChuyen(con, idchuyen, idSeat3,idDiemDon, idUser);
									numberChairSeat3 = seatDAO.getChairByIdSeat(con, idGhe3);
									session.setAttribute("numberChairSeat3",numberChairSeat3);
								}
								 _nbSeats =Integer.parseInt(seatDAO.getNumberSeat(con,idChuyen));
								 priceSeat = String.valueOf(_nbSeats * Integer.parseInt(priceTrip));
								 noiDung = "Chuyến số: " + idChuyen +"\nBiển số" + inputTripBoard + "\nGhế số: " + numberChairSeat1.getNumber_chair() + " "+numberChairSeat2.getNumber_chair() + " "+numberChairSeat3.getNumber_chair() + " "+ "\nĐịa điểm đón: " + _diemDon + "\nĐịa điểm trả: " + _diemTra + "\nGìa vé: " + priceSeat + ".000đ"  
										+ "\nTài khoản để đăng nhập để kiểm tra vé là: Tên đăng nhập: " + phoneUser +" " + "\nMật khẩu: "+ pass;
							}
							
							System.out.println("priceTrip"+ priceSeat);
								
								
								SendEmail.getInstant().guiMail(email, noiDung);
								String mes = "Email của quý khách đã gửi thành công!";
								request.setAttribute("mes", mes);
								response.sendRedirect(request.getContextPath() + Router.THONG_BAO);
								
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							response.sendRedirect(request.getContextPath() + Router.THONG_BAO);
						}
						
						
					}else{
						errorString = "Có lỗi";
						response.sendRedirect(request.getContextPath() + Router.PAGE_BUY_TICKET);
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					hasError = true;
					errorString = e.getMessage();
				}
			}
			else {
				errorString = "Vui lòng nhập thông tin đầy đủ";
				session.setAttribute("errorString", errorString);
				response.sendRedirect(request.getContextPath()  + Router.PAGE_BUY_TICKET);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			hasError = true;
			errorString = e.getMessage();
		}		
	}

}
