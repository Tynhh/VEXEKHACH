<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="model.Trip"%> <%@page
import="model.Garage"%> <%@page import="model.Seat"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="../assets/user/css/chitietve.css"
    />
    <link rel="stylesheet" type="text/css" href="../assets/user/css/util.css" />
  </head>
  <body>
    <div id="chitietve" class="bg" style="width: 1000px; margin: auto">
      <h1 align="center">Chi tiết đặt chỗ</h1>
      <hr />
      <table>
        <tr>
          <td id="td1" style="width: 200px">Công ty: ${xe.fullname}</td>
          <td id="td2">Mô tả: ${xe.description}</td>
        </tr>
        <tr>
          <td id="td1" style="width: 200px">Biển số xe: ${tr.trip_board}</td>
        </tr>
        <tr>
          <td id="">Điểm đón: Bến xe miền đông ${tr.departure}</td>
          <td id="">Điểm trả: Ngã 3 Tam Quan ${tr.destination}</td>
        </tr>
        <tr>
          <td id="td1">Giờ khởi hành:</td>
          <td id="td2">${tr.departure_time}</td>
          <td></td>
        </tr>
        <tr>
          <td id="td1">Số lượng vé: ${list.size()}</td>
          <td id="td2"></td>
        </tr>
        <tr>
          <td id="td1">Giá vé: ${tr.price*list.size()}.000</td>
          <td id="td2"></td>
        </tr>
        <tr>
          <td id="td1">Mã ghế: ${list[0]}, ${list[1]},${list[2]}</td>
          <td id="td2"></td>
        </tr>
      </table>
      <hr />
    </div>
  </body>
</html>
