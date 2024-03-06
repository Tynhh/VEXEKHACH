package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Schedule;
import model.Seat;
import model.Trip;
import utils.MyUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.ScheduleDAO;
import DAO.SeatDAO;
import DAO.TripDAO;

/**
 * Servlet implementation class FilterTripServlet
 */
@WebServlet(urlPatterns = { "/filterTrip" })
public class FilterTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterTripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filter1 = request.getParameter("filter_time1");
		String filter2 = request.getParameter("filter_time2");
		String filter3 = request.getParameter("filter_time3");
		String filter4 = request.getParameter("filter_time4");
		String minStr = request.getParameter("min");
		String maxStr = request.getParameter("max");
		
//		System.out.println(filter1);
//		System.out.println(filter2);
//		System.out.println(filter3);
//		System.out.println(filter4);
//		System.out.println(minStr);
//		System.out.println(maxStr);
		
		int filter_time1 = Integer.parseInt(filter1);
		int filter_time2 = Integer.parseInt(filter2);
		int filter_time3 = Integer.parseInt(filter3);
		int filter_time4 = Integer.parseInt(filter4);
		int min = Integer.parseInt(minStr);
		int max = Integer.parseInt(maxStr);
		
		HttpSession session = request.getSession();
		String departure = (String) session.getAttribute("departure");
		String destination = (String) session.getAttribute("destination");
		String date = (String) session.getAttribute("departure_time");
		
		ArrayList<Trip> list_trip = new ArrayList<Trip>();
		Connection conn = MyUtils.getStoredConnection(request);
		
		list_trip = TripDAO.getListTripFilter(conn, 
				departure, destination, date,
				filter_time1, filter_time2, filter_time3, filter_time4,
				min, max
				);
		
		for (int i = 0; i < list_trip.size(); i++)
		{
			int trip_id = list_trip.get(i).getId();
			int garage_id = list_trip.get(i).garage.getId();
			ArrayList<Seat> list_seat = new ArrayList<Seat>();
			ArrayList<Schedule> list_musty = new ArrayList<Schedule>();
			
			list_seat = SeatDAO.getListSeat(conn, trip_id);
			list_trip.get(i).setList_seat(list_seat);
			
			list_musty = ScheduleDAO.getListSchedule(conn, garage_id);
			list_trip.get(i).setList_musty(list_musty);
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		for (int i = 0; i < list_trip.size(); i++) {
			out.println("<form action=\"/Web_Dat_Ve_Xe_Khach/dat_ve\" method=\"POST\" style=\"margin-bottom: 32px;\" id =\""+list_trip.get(i).getId()+"\">");
			
			out.println("<div class=\"tab-pane fade show active\" id=\"all" + list_trip.get(i).getId() + "\" role=\"tabpanel\" aria-labelledby=\"pills-home-tab" + list_trip.get(i).getId() + "\">\r\n"
					+ "	<div class=\"vexe\">\r\n"
					+ "		<div class=\"card__top\" style=\"font-size: small\">\r\n"
					+ "			<div class=\"card__right\">\r\n"
					+ "				<img src=\"assets/user/images/xe2.jpg\" alt=\"\">\r\n"
					+ "	\r\n"
					+ "				<div class=\"div\">\r\n"
					+ "					<div class=\"div__content\" style=\"font-size: 16px\">\r\n"
					+ "						<h3 style=\"font-size: 20px\">"+ list_trip.get(i).garage.getFullname() +"</h3>\r\n"
					+ "						<p class=\"content__1\">" + list_trip.get(i).getPrice() + " 000 VNĐ</p>\r\n"
					+ "					</div>\r\n"
					+ "					<p>Giường nằm " + list_trip.get(i).getNum_seat() +" chỗ</p>\r\n"
					+ "					<i class=\"fa fa-map-pin\">" + list_trip.get(i).getDeparture_time() + "</i><br> <i\r\n"
					+ "						class=\"fa fa-map-marker-alt\"></i>\r\n"
					+ "				</div>\r\n"
					+ "	\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"collasp\">\r\n"
					+ "				<div class=\"card__link\">\r\n"
					+ "					<a data-toggle=\"collapse\" href=\"#collapseExample" + list_trip.get(i).getId() + "\"\r\n"
					+ "						role=\"button\" aria-expanded=\"false\"\r\n"
					+ "						aria-controls=\"collapseExample" + list_trip.get(i).getId() + "\"> Thông tin chi tiết <i\r\n"
					+ "						class=\"fa fa-angle-down\"></i>\r\n"
					+ "					</a>\r\n"
					+ "				</div>\r\n"
					+ "				<div class=\"button\">\r\n"
					+ "					<button data-toggle=\"collapse\"\r\n"
					+ "						onclick=\"chonXe('#scroll11',800,'chuyendi','" + list_trip.get(i).getId() + "','" + list_trip.get(i).getId() + "')\" aria-expanded=\"false\"\r\n"
					+ "						aria-controls=\"collapseChonChuyen" + list_trip.get(i).getId() + "\" name=\"idChuyenXe\"\r\n"
					+ "						value=\"" + list_trip.get(i).getId() + "\" type=\"button\"  data-target=\"#collapseChonChuyen" + list_trip.get(i).getId() + "\">Chọn chuyến</button>\r\n"
					+ "					<input class=\"form-check-input\" type=\"hidden\"\r\n"
					+ "						value=\"" + list_trip.get(i).getId() + "\"\r\n"
					+ "						name=\"inputIdChuyenXe\" id=\"inputIdChuyenXe\"> \r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "</div>");
			
			out.println("<div class=\"card__bottom\">\r\n"
					+ "				<div class=\"collapse\" id=\"collapseChonChuyen" + list_trip.get(i).getId() + "\">\r\n"
					+ "					<div class=\"card card-body\">\r\n"
					+ "						<div class=\"project\">\r\n"
					+ "							<ul class=\"nav nav-pills mb-3 nav-tabs\" id=\"pills-tab" + list_trip.get(i).getId() + "\"\r\n"
					+ "								role=\"tablist\">\r\n"
					+ "	\r\n"
					+ "								<li class=\"nav-item \" role=\"presentation\"><a\r\n"
					+ "									class=\"nav-link active nav-link_1\" id=\"pills-img-tab" + list_trip.get(i).getId() + "\"\r\n"
					+ "									data-toggle=\"pill\" href=\"#img" + list_trip.get(i).getId() + "\" role=\"tab\"\r\n"
					+ "									aria-controls=\"pills-img\" aria-selected=\"true\"><input\r\n"
					+ "										class=\"form-check-input\" type=\"hidden\"\r\n"
					+ "										name=\"inlineRadioOptions\" id=\"inlineRadio" + list_trip.get(i).getId() + "\"\r\n"
					+ "										value=\"option" + list_trip.get(i).getId() + "\" checked> <label\r\n"
					+ "										class=\"form-check-label line-connect\" for=\"inlineRadio" + list_trip.get(i).getId() + "\">1.Chỗ\r\n"
					+ "											mong muốn -></label></a></li>\r\n"
					+ "	\r\n"
					+ "								<li class=\"nav-item\" role=\"presentation\"><a\r\n"
					+ "									class=\"nav-link nav-link_" + list_trip.get(i).getId() + "\" id=\"pills-cmt-tab" + list_trip.get(i).getId() + "\"\r\n"
					+ "									data-toggle=\"pill\" href=\"#pills-cmt" + list_trip.get(i).getId() + "\" role=\"tab\"\r\n"
					+ "									aria-controls=\"pills-cmt\" aria-selected=\"false\"><input\r\n"
					+ "										class=\"form-check-input\" type=\"hidden\"\r\n"
					+ "										name=\"inlineRadioOptions\" id=\"inlineRadio" + list_trip.get(i).getId() + "\"\r\n"
					+ "										value=\"option" + list_trip.get(i).getId() + "\"> <label class=\"form-check-label\"\r\n"
					+ "										for=\"inlineRadio" + list_trip.get(i).getId() + "\">2.Điểm đón trả -></label> </a></li>\r\n"
					+ "								<li class=\"nav-item \" role=\"presentation\"><a\r\n"
					+ "									class=\"nav-link nav-link_" + list_trip.get(i).getId() + "\" id=\"pills-travel-tab" + list_trip.get(i).getId() + "\"\r\n"
					+ "									data-toggle=\"pill\" href=\"#pills-travel" + list_trip.get(i).getId() + "\" role=\"tab\"\r\n"
					+ "									aria-controls=\"pills-travel\" aria-selected=\"false\"><input\r\n"
					+ "										class=\"form-check-input\" type=\"hidden\"\r\n"
					+ "										name=\"inlineRadioOptions\" id=\"inlineRadio" + list_trip.get(i).getId() + "\"\r\n"
					+ "										value=\"option" + list_trip.get(i).getId() + "\"> <label class=\"form-check-label\"\r\n"
					+ "										for=\"inlineRadio" + list_trip.get(i).getId() + "\">3.Nhập thông tin </label></a></li>\r\n"
					+ "	\r\n"
					+ "							</ul>\r\n"
					+ "	\r\n"
					+ "							<div class=\"tab-content\" id=\"pills-tabContent\">\r\n"
					+ "								<div class=\"tab-pane fade show active\" id=\"img" + list_trip.get(i).getId() + "\"\r\n"
					+ "									role=\"tabpanel\" aria-labelledby=\"pills-img-tab" + list_trip.get(i).getId() + "\">\r\n"
					+ "									\r\n"
					+ "									<div class=\"SeatSelectionOnline__SeatSelection-sc-167eirc-0 hqRXwu\">\r\n"
					+ "	                                                     	<div class=\"seat-groups\">\r\n"
					+ "	                                                         	<div class=\"note\">Chú thích</div>\r\n"
					+ "	                                                         	<div class=\"seat-info\">\r\n"
					+ "	                                                                 <div\r\n"
					+ "	                                                                   class=\"SeatThumbnail__SeatContainer-sc-1ooosi9-0 oWlko seat-thumbnail\"\r\n"
					+ "	                                                                   color=\"#b8b8b8\"\r\n"
					+ "	                                                                 >\r\n"
					+ "	                                                                   <svg\r\n"
					+ "	                                                                     width=\"32\"\r\n"
					+ "	                                                                     height=\"40\"\r\n"
					+ "	                                                                     viewBox=\"0 0 28 40\"\r\n"
					+ "	                                                                     fill=\"none\"\r\n"
					+ "	                                                                     xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "	                                                                   >\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"2.75\"\r\n"
					+ "	                                                                       y=\"2.75\"\r\n"
					+ "	                                                                       width=\"22.5\"\r\n"
					+ "	                                                                       height=\"34.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"5.75\"\r\n"
					+ "	                                                                       y=\"27.75\"\r\n"
					+ "	                                                                       width=\"16.5\"\r\n"
					+ "	                                                                       height=\"6.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-selected\"\r\n"
					+ "	                                                                       d=\"M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-disabled\"\r\n"
					+ "	                                                                       d=\"M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                   </svg>\r\n"
					+ "	                                                                 </div>\r\n"
					+ "	                                                                 <span class=\"seat-name\">Còn trống</span>\r\n"
					+ "	                                                               </div>\r\n"
					+ "	                                                               <div class=\"seat-info\">\r\n"
					+ "	                                                                 <div\r\n"
					+ "	                                                                   class=\"SeatThumbnail__SeatContainer-sc-1ooosi9-0" + list_trip.get(i).getId() + " daMVvn seat-thumbnail\"\r\n"
					+ "	                                                                   disabled=\"\"\r\n"
					+ "	                                                                 >\r\n"
					+ "	                                                                   <svg\r\n"
					+ "	                                                                     width=\"32\"\r\n"
					+ "	                                                                     height=\"40\"\r\n"
					+ "	                                                                     viewBox=\"0 0 28 40\"\r\n"
					+ "	                                                                     fill=\"none\"\r\n"
					+ "	                                                                     xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "	                                                                   >\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"2.75\"\r\n"
					+ "	                                                                       y=\"2.75\"\r\n"
					+ "	                                                                       width=\"22.5\"\r\n"
					+ "	                                                                       height=\"34.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"5.75\"\r\n"
					+ "	                                                                       y=\"27.75\"\r\n"
					+ "	                                                                       width=\"16.5\"\r\n"
					+ "	                                                                       height=\"6.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-selected\"\r\n"
					+ "	                                                                       d=\"M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-disabled\"\r\n"
					+ "	                                                                       d=\"M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                   </svg>\r\n"
					+ "	                                                                 </div>\r\n"
					+ "	                                                                 <span class=\"seat-name\">Ghế đã bán</span>\r\n"
					+ "	                                                               </div>\r\n"
					+ "	                                                               <div class=\"seat-info\">\r\n"
					+ "	                                                                 <div\r\n"
					+ "	                                                                   class=\"SeatThumbnail__SeatContainer-sc-1ooosi9-0 dLgsTe seat-thumbnail\"\r\n"
					+ "	                                                                 >\r\n"
					+ "	                                                                   <svg\r\n"
					+ "	                                                                     width=\"32\"\r\n"
					+ "	                                                                     height=\"40\"\r\n"
					+ "	                                                                     viewBox=\"0 0 28 40\"\r\n"
					+ "	                                                                     fill=\"none\"\r\n"
					+ "	                                                                     xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "	                                                                   >\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"2.75\"\r\n"
					+ "	                                                                       y=\"2.75\"\r\n"
					+ "	                                                                       width=\"22.5\"\r\n"
					+ "	                                                                       height=\"34.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <rect\r\n"
					+ "	                                                                       x=\"5.75\"\r\n"
					+ "	                                                                       y=\"27.75\"\r\n"
					+ "	                                                                       width=\"16.5\"\r\n"
					+ "	                                                                       height=\"6.5\"\r\n"
					+ "	                                                                       rx=\"2.25\"\r\n"
					+ "	                                                                       fill=\"#FFF\"\r\n"
					+ "	                                                                       stroke=\"#B8B8B8\"\r\n"
					+ "	                                                                       stroke-width=\"1.5\"\r\n"
					+ "	                                                                       stroke-linejoin=\"round\"\r\n"
					+ "	                                                                     ></rect>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-selected\"\r\n"
					+ "	                                                                       d=\"M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                     <path\r\n"
					+ "	                                                                       class=\"icon-disabled\"\r\n"
					+ "	                                                                       d=\"M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z\"\r\n"
					+ "	                                                                       fill=\"transparent\"\r\n"
					+ "	                                                                     ></path>\r\n"
					+ "	                                                                   </svg>\r\n"
					+ "	                                                                 </div>\r\n"
					+ "	                                                                 <span class=\"seat-name\">Đang chọn</span>\r\n"
					+ "	                                                               </div>\r\n"
					+ "	                                                             </div>\r\n"
					+ "	                                                             <div class=\"SeatTemplate-sc-1ilqewh-0 llUipg seat-template\">\r\n"
					+ "	                                                               <div class=\"coach-container\">\r\n"
					+ "	                                                                 <div class=\"coach\">\r\n"
					+ "	                                                                   <table>\r\n"
					+ "	                                                                     <tbody>\r\n"
					+ "	                                                                       	<tr class=\"coach-row\">\r\n"
					+ "	                                                                         <td class=\"seat\">\r\n"
					+ "	                                                                           <div\r\n"
					+ "	                                                                             class=\"Seat__SeatContainer-sc-6hr0u8-0 buebkj seat-container\"\r\n"
					+ "	                                                                             data-disabled=\"true\"\r\n"
					+ "	                                                                             disabled=\"\"\r\n"
					+ "	                                                                           >\r\n"
					+ "	                                                                             <svg\r\n"
					+ "	                                                                               width=\"24\"\r\n"
					+ "	                                                                               height=\"24\"\r\n"
					+ "	                                                                               viewBox=\"0 0 24 24\"\r\n"
					+ "	                                                                               fill=\"none\"\r\n"
					+ "	                                                                               xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "	                                                                             >\r\n"
					+ "	                                                                               <path\r\n"
					+ "	                                                                                 d=\"M12.305 24h-.61c-.035-.004-.07-.01-.105-.012a11.783 11.783 0 0 1-2.117-.261 12.027 12.027 0 0 1-6.958-4.394A11.933 11.933 0 0 1 .027 12.78L0 12.411v-.822c.005-.042.013-.084.014-.127a11.845 11.845 0 0 1 1.102-4.508 12.007 12.007 0 0 1 2.847-3.852A11.935 11.935 0 0 1 11.728.003c.947-.022 1.883.07 2.81.27 1.22.265 2.369.71 3.447 1.335a11.991 11.991 0 0 1 3.579 3.164 11.876 11.876 0 0 1 2.073 4.317c.178.712.292 1.434.334 2.168.008.146.02.292.029.439v.609c-.004.03-.011.06-.012.089a11.81 11.81 0 0 1-1.05 4.521 12.02 12.02 0 0 1-1.92 2.979 12.046 12.046 0 0 1-6.395 3.812c-.616.139-1.24.23-1.872.265-.149.008-.297.02-.446.03zm8.799-13.416c-.527-3.976-4.078-7.808-9.1-7.811-5.02-.003-8.583 3.823-9.11 7.809h.09c.64-.035 1.278-.092 1.912-.195.815-.131 1.614-.326 2.378-.639.625-.255 1.239-.54 1.855-.816.82-.368 1.673-.593 2.575-.62a7.123 7.123 0 0 1 1.947.187c.585.146 1.136.382 1.68.634.57.264 1.14.526 1.733.736 1.2.424 2.442.62 3.706.7.11.006.222.01.334.015zm-10.95 10.471v-.094c0-1.437 0-2.873-.002-4.31 0-.141-.011-.284-.035-.423a2.787 2.787 0 0 0-.775-1.495c-.564-.582-1.244-.896-2.067-.892-1.414.007-2.827.002-4.24.002h-.09a9.153 9.153 0 0 0 3.125 5.256 9.15 9.15 0 0 0 4.083 1.956zm3.689.001c1.738-.36 3.25-1.137 4.528-2.355 1.4-1.334 2.287-2.956 2.685-4.855l-.077-.003h-4.362c-.237 0-.47.038-.695.112-.667.22-1.188.635-1.588 1.206a2.673 2.673 0 0 0-.494 1.59c.008 1.4.003 2.801.003 4.202v.103zM12.05 14.22c1.215-.035 2.204-1.083 2.165-2.275-.039-1.223-1.095-2.215-2.29-2.166-1.211.05-2.2 1.108-2.15 2.302.051 1.191 1.108 2.186 2.275 2.139z\"\r\n"
					+ "	                                                                                 fill=\"#858585\"\r\n"
					+ "	                                                                               ></path>\r\n"
					+ "	                                                                             </svg>\r\n"
					+ "	                                                                           </div>\r\n"
					+ "	                                                                         </td>\r\n"
					+ "	                                                                       	</tr>");
			
			int indexSeat = 1;
			for (int j = 0; j < list_trip.get(i).list_seat.size(); j++)
			{
				if (indexSeat % 4 == 1) {
					out.println("<tr class=\"coach-row\">");
				}
				
				String classPB = "";
				if (list_trip.get(i).list_seat.get(j).getStatus() == 1) {
					classPB = "ArHJS";
				} else {
					classPB = "K20TTDL";
				}
				
				out.println("<td class=\"seat " + list_trip.get(i).list_seat.get(j).getId() + " " + list_trip.get(i).list_seat.get(j).getNumber_chair() + " " + classPB + "\" onclick=\"clickSeatFunction('" + list_trip.get(i).list_seat.get(j).getId() + "','" + list_trip.get(i).getId() + "')\">\r\n"
						+ "	<div\r\n"
						+ "	class=\"Seat__SeatContainer-sc-6hr0u8-0 iaQDbI seat-container " + list_trip.get(i).getId() + "\"\r\n"
						+ "	data-disabled=\"true\"\r\n"
						+ "	disabled=\"\"\r\n"
						+ "	color=\"#b8b8b8\"\r\n"
						+ "	>\r\n"
						+ "	<svg\r\n"
						+ "		width=\"32\"\r\n"
						+ "		height=\"40\"\r\n"
						+ "		viewBox=\"0 0 28 40\"\r\n"
						+ "		fill=\"none\"\r\n"
						+ "		xmlns=\"http://www.w3.org/2000/svg\"\r\n"
						+ "		style=\"width: 27px; height: 40px\"\r\n"
						+ "	>\r\n"
						+ "		<rect\r\n"
						+ "		x=\"2.75\"\r\n"
						+ "		y=\"2.75\"\r\n"
						+ "		width=\"22.5\"\r\n"
						+ "		height=\"34.5\"\r\n"
						+ "		rx=\"2.25\"\r\n"
						+ "		fill=\"#FFF\"\r\n"
						+ "		stroke=\"#B8B8B8\"\r\n"
						+ "		stroke-width=\"1.5\"\r\n"
						+ "		stroke-linejoin=\"round\"\r\n"
						+ "		></rect>\r\n"
						+ "		<rect\r\n"
						+ "		x=\"5.75\"\r\n"
						+ "		y=\"27.75\"\r\n"
						+ "		width=\"16.5\"\r\n"
						+ "		height=\"6.5\"\r\n"
						+ "		rx=\"2.25\"\r\n"
						+ "		fill=\"#FFF\"\r\n"
						+ "		stroke=\"#B8B8B8\"\r\n"
						+ "		stroke-width=\"1.5\"\r\n"
						+ "		stroke-linejoin=\"round\"\r\n"
						+ "		></rect>\r\n"
						+ "		<path\r\n"
						+ "		class=\"icon-selected\"\r\n"
						+ "		d=\"M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z\"\r\n"
						+ "		fill=\"transparent\"\r\n"
						+ "		></path>\r\n"
						+ "		<path\r\n"
						+ "		class=\"icon-disabled\"\r\n"
						+ "		d=\"M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z\"\r\n"
						+ "		fill=\"transparent\"\r\n"
						+ "		></path>\r\n"
						+ "	</svg>\r\n"
						+ "	</div>\r\n"
						+ "</td>");
				
				if (indexSeat % 4 == 2) {
					out.println("<td class=\"\">\r\n"
							+ "	<div\r\n"
							+ "	  class=\"Seat__SeatContainer-sc-6hr0u8-0 buebkj seat-container\"\r\n"
							+ "	  data-disabled=\"true\"\r\n"
							+ "	  disabled=\"\"\r\n"
							+ "	></div>\r\n"
							+ "</td>");
				}
				
				if (indexSeat % 4 == 0) {
					out.println("</tr>");
				}
				
				indexSeat++;
			}
			
			out.println("						</tbody>\r\n"
					+ "					</table>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "<div id=\"seat_result" + list_trip.get(i).getId() + "\"></div>");
			
			out.println("<div style=\"border-top: 1px solid;\">\r\n"
					+ "										<div class=\"line\"\r\n"
					+ "											style=\"display: block; border-bottom: 10px;\"></div>\r\n"
					+ "										<div\r\n"
					+ "											style=\"display: flex; justify-content: flex-end; margin-top: 10px;\">\r\n"
					+ "											<p\r\n"
					+ "												style=\"margin-right: 16px; margin-bottom: 0; margin-top: 5px;\">Tổng\r\n"
					+ "												cộng: 0đ</p>\r\n"
					+ "											<button type=\"button\" class=\"btn btn-primary btnNext\"  onclick=\"btnNext('" + list_trip.get(i).getId() + "',0)\">Tiếp\r\n"
					+ "												tục</button>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "	\r\n"
					+ "								<div class=\"tab-pane fade\" id=\"pills-cmt" + list_trip.get(i).getId() + "\" role=\"tabpanel\"\r\n"
					+ "									aria-labelledby=\"pills-cmt-tab" + list_trip.get(i).getId() + "\">\r\n"
					+ "									<div class=\"row\">\r\n"
					+ "										<div class=\"row\">\r\n"
					+ "											<div class=\"col-12\">\r\n"
					+ "												<div class=\"card animate__animated animate__zoomIn\">\r\n"
					+ "													<div class=\"card-body\">\r\n"
					+ "														<p class=\"card-text\">Lưu ý Các mốc thời gian\r\n"
					+ "															đón, trả bên dưới là thời gian dự kiến. Lịch này có\r\n"
					+ "															thể thay đổi tùy tình hình thưc tế.</p>\r\n"
					+ "														<div class=\"card__2\">\r\n"
					+ "															<div class=\"card__right1\">\r\n"
					+ "																<h6>Điểm đón</h6>\r\n"
					+ "																<ul>");
			
			if (list_trip.get(i).getDeparture() == list_trip.get(i).garage.getAddress()) {
				for (int k = 0; k < list_trip.get(i).list_musty.size(); k++)
				{
					if (list_trip.get(i).list_musty.get(k).getStatus() == 1) {
						out.println("<li class=\"form-check\" style=\"display: flex\">\r\n"
								+ "	<input class=\"form-check-input\" type=\"radio\"\r\n"
								+ "	name=\"checkbox_" + list_trip.get(i).getId() + "\" id=\"checkbox_" + list_trip.get(i).getId() + "\" value=\"" + list_trip.get(i).list_musty.get(k).getId() + "\"> \r\n"
								+ "	<label class=\"form-check-label\" for=\"exampleRadios1\" style=\"font-size: 16px\">\r\n"
								+ "		" + list_trip.get(i).list_musty.get(k).getMusty() + " \r\n"
								+ "	</label>\r\n"
								+ "</li>");
					}
				}
			} else {
				for (int k = 0; k < list_trip.get(i).list_musty.size(); k++)
				{
					if (list_trip.get(i).list_musty.get(k).getStatus() == 0) {
						out.println("<li class=\"form-check\" style=\"display: flex\">\r\n"
								+ "	<input class=\"form-check-input\" type=\"radio\"\r\n"
								+ "	name=\"checkbox_" + list_trip.get(i).getId() + "\" id=\"checkbox_" + list_trip.get(i).getId() + "\" value=\"" + list_trip.get(i).list_musty.get(k).getId() + "\"> \r\n"
								+ "	<label class=\"form-check-label\" for=\"exampleRadios1\" style=\"font-size: 16px\">\r\n"
								+ "		" + list_trip.get(i).list_musty.get(k).getMusty() + " \r\n"
								+ "	</label>\r\n"
								+ "</li>");
					}
				}
			}
			
			out.println("</ul>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "<div class=\"card__left2\">\r\n"
					+ "	<h6>Điểm trả</h6>\r\n"
					+ "\r\n"
					+ "	<ul>");
			
			if (list_trip.get(i).getDeparture() == list_trip.get(i).garage.getAddress()) {
				for (int k = 0; k < list_trip.get(i).list_musty.size(); k++)
				{
					if (list_trip.get(i).list_musty.get(k).getStatus() == 0) {
						out.println("<li class=\"form-check\" style=\"display: flex\">\r\n"
								+ "	<input class=\"form-check-input\" type=\"radio\"\r\n"
								+ "	name=\"checkbox_" + list_trip.get(i).getId() + "\" id=\"checkbox_" + list_trip.get(i).getId() + "\" value=\"" + list_trip.get(i).list_musty.get(k).getId() + "\"> \r\n"
								+ "	<label class=\"form-check-label\" for=\"exampleRadios1\" style=\"font-size: 16px\">\r\n"
								+ "		" + list_trip.get(i).list_musty.get(k).getMusty() + " \r\n"
								+ "	</label>\r\n"
								+ "</li>");
					}
				}
			} else {
				for (int k = 0; k < list_trip.get(i).list_musty.size(); k++)
				{
					if (list_trip.get(i).list_musty.get(k).getStatus() == 1) {
						out.println("<li class=\"form-check\" style=\"display: flex\">\r\n"
								+ "	<input class=\"form-check-input\" type=\"radio\"\r\n"
								+ "	name=\"checkbox_" + list_trip.get(i).getId() + "\" id=\"checkbox_" + list_trip.get(i).getId() + "\" value=\"" + list_trip.get(i).list_musty.get(k).getId() + "\"> \r\n"
								+ "	<label class=\"form-check-label\" for=\"exampleRadios1\" style=\"font-size: 16px\">\r\n"
								+ "		" + list_trip.get(i).list_musty.get(k).getMusty() + " \r\n"
								+ "	</label>\r\n"
								+ "</li>");
					}
				}
			}
			
			out.println("</ul>\r\n"
					+ "															</div>\r\n"
					+ "	\r\n"
					+ "														</div>\r\n"
					+ "	\r\n"
					+ "													</div>\r\n"
					+ "												</div>\r\n"
					+ "	\r\n"
					+ "												<div style=\"border-top: 1px solid;\">\r\n"
					+ "	\r\n"
					+ "													<div\r\n"
					+ "														style=\"display: flex; align-items: center; justify-content: space-between; margin-top: 20px;\">\r\n"
					+ "														<button type=\"button\"\r\n"
					+ "															class=\"btn btn-secondary btnPrevious\" onclick=\"btnPrevious('" + list_trip.get(i).getId() + "',0)\">Quay\r\n"
					+ "															lại</button>\r\n"
					+ "														<div style=\"display: flex;\">\r\n"
					+ "															<!-- <p\r\n"
					+ "																style=\"margin-right: 16px; margin-bottom: 0; margin-top: 10px;\">Tổng\r\n"
					+ "																cộng: 0đ</p> -->\r\n"
					+ "															<button type=\"button\"\r\n"
					+ "																class=\"btn btn-primary btnNext\" style=\"\" onclick=\"btnNext('" + list_trip.get(i).getId() + "',1)\" >Tiếp\r\n"
					+ "																tục</button>\r\n"
					+ "														</div>\r\n"
					+ "													</div>\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"
					+ "	\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "	\r\n"
					+ "								<div class=\"tab-pane fade\" id=\"pills-travel" + list_trip.get(i).getId() + "\"\r\n"
					+ "									role=\"tabpanel\" aria-labelledby=\"pills-travel-tab" + list_trip.get(i).getId() + "\">\r\n"
					+ "									<div class=\"row\">\r\n"
					+ "										<div class=\"col-12\">\r\n"
					+ "											<div class=\"card animate__animated animate__zoomIn\">\r\n"
					+ "												<div class=\"card-body\">\r\n"
					+ "													<p>Chúng tôi chỉ dùng thông tin của bạn trong\r\n"
					+ "														việc ghi nhận vé.</p>\r\n"
					+ "	\r\n"
					+ "													<div>\r\n"
					+ "														<div class=\"form-group \">\r\n"
					+ "															<input type=\"text\" class=\"form-control top inputName\"\r\n"
					+ "																id=\"inputName" + list_trip.get(i).getId() + "\" placeholder=\"First and Last name \"\r\n"
					+ "																name=\"nameUser" + list_trip.get(i).getId() + "\" value=\"\" required=\"required\" onclick=\"onClickGetID('" + list_trip.get(i).getId() + "')\">\r\n"
					+ "															<div>\r\n"
					+ "																<p id=\"errorUserName" + list_trip.get(i).getId() + "\" class=\"errorUserName\"></p>\r\n"
					+ "															</div>\r\n"
					+ "														</div>\r\n"
					+ "	\r\n"
					+ "														<div class=\"form-group \">\r\n"
					+ "															<input type=\"text\"\r\n"
					+ "																class=\"form-control top inputPhone\"\r\n"
					+ "																id=\"inputPhone" + list_trip.get(i).getId() + "\" placeholder=\"Number phone \"\r\n"
					+ "																name=\"phoneUser" + list_trip.get(i).getId() + "\" value=\"\" required=\"required\" onclick=\"onClickGetID('" + list_trip.get(i).getId() + "')\">\r\n"
					+ "	\r\n"
					+ "															<p id=\"errorNumberPhone\"></p>\r\n"
					+ "	\r\n"
					+ "														</div>\r\n"
					+ "	\r\n"
					+ "														<div class=\"form-group \">\r\n"
					+ "															<input type=\"text\" class=\"form-control top inputEmail\"\r\n"
					+ "																id=\"inputEmail" + list_trip.get(i).getId() + "\"\r\n"
					+ "																placeholder=\"Email (abc@gmail.com)\"\r\n"
					+ "																name=\"emailUser" + list_trip.get(i).getId() + "\" value=\"\" required=\"required\" onclick=\"onClickGetID('" + list_trip.get(i).getId() + "')\">\r\n"
					+ "															<div>\r\n"
					+ "																<p id=\"errorUserEmail\"></p>\r\n"
					+ "															</div>\r\n"
					+ "														</div>\r\n"
					+ "														<div class=\"form-group \">\r\n"
					+ "															<input type=\"text\" class=\"form-control top\"\r\n"
					+ "																id=\"inputOther\" aria-describedby=\"otherHelp\"\r\n"
					+ "																placeholder=\"Note\" name=\"noteUser\" value=\"\">\r\n"
					+ "															<!-- <div>\r\n"
					+ "															<p id=\"error4\"></p>\r\n"
					+ "														</div> -->\r\n"
					+ "														</div>\r\n"
					+ "														<p>Bằng việc nhấn nút Tiếp Tục, bạn đồng ý với\r\n"
					+ "															Chính sách bảo mật thông tin và Quy chế</p>\r\n"
					+ "													</div>\r\n"
					+ "												</div>\r\n"
					+ "												<div style=\"border-top: 1px solid;\">\r\n"
					+ "	\r\n"
					+ "													<div class=\"line\"\r\n"
					+ "														style=\"display: block; border-bottom: 10px;\"></div>\r\n"
					+ "													<div\r\n"
					+ "														style=\"display: flex; align-items: center; justify-content: space-between;\">\r\n"
					+ "														<button type=\"button\"\r\n"
					+ "															class=\"btn btn-secondary btnPrevious\"\r\n"
					+ "															style=\"margin-top: 20px\" onclick=\"btnPrevious('" + list_trip.get(i).getId() + "',1)\">Quay lại</button>\r\n"
					+ "														<div style=\"display: flex; margin-top: 10px;\">\r\n"
					+ "															<p\r\n"
					+ "																style=\"margin-right: 16px; margin-bottom: 0; margin-top: 5px;\">Tổng\r\n"
					+ "																cộng: " + list_trip.get(i).getPrice() + " 000 VNĐ</p>\r\n"
					+ "															<button type=\"submit\" class=\"btn btn-primary\">Xác\r\n"
					+ "																nhận</button>\r\n"
					+ "														</div>\r\n"
					+ "	\r\n"
					+ "													</div>\r\n"
					+ "												</div>\r\n"
					+ "											</div>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "			</div>");
			
			out.println("</form>");
		}
		out.close();
	}

}
