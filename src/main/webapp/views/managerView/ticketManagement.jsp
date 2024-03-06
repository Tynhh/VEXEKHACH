<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="utils.Router"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Vé</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<!----======== CSS ======== -->
<link rel="stylesheet" href="assets/admin/css/style.css">

<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<body>


	<jsp:include page="/views/managerView/layout/sidebar.jsp" />

	<section class="home">
		<div class="text">Danh Sách Vé</div>
		<div class="area-feat">
	
			<a class="btn btn-success" href= "exportTicket">Tải Xuống</a>
		</div>
		<div class="content">
			<div style="width: 50%;" class="d-flex">
				<input id="searchContent" class="form-control me-1" type="search"
					placeholder="Nhập số điện thoại" aria-label="Search">
				<a onclick="Search();" class="btn btn-primary" type="submit">Search</a>
			</div>
			<br>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Họ Tên</th>
						<th scope="col">Số điện thoại</th>
						<th scope="col">Điểm đón</th>
						<th scope="col">Điểm đến</th>
						<th scope="col">Số ghế</th>
						<th scope="col">Biển số xe</th>
						<th scope="col">Thời gian</th>
						<th scope="col">Giá</th>
						<th scope="col">Huỷ Vé</th>
					</tr>
				</thead>
					<tbody>
			  	<c:forEach items="${ ticketList }" var="ticket" varStatus="loop">
				    <tr>
					      
					      <td>${ticket.tripid }</td>
					     <td>${ ticket.fullname }</td> 
					     <td>${ ticket.phonenumber }</td>
					     <td>${ ticket.starts }</td>
					     <td>${ ticket.musty }</td>
					   <td>${ ticket.numberchair }</td>
					   <td>${ ticket.tripbroad }</td>
					   <td>${ ticket.startstime }</td>
					   <td>${ ticket.price }</td>
					      <td>
					      	<a class="btn btn-danger" href="#" onclick="testConfirmDialog(${ticket.tripid},${ticket.seatid},${ticket.customerid});">Huỷ</a>
					      </td>
				    </tr>
				</c:forEach>
			  	</tbody>
			</table>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script>
        const body = document.querySelector('body'),
	    sidebar = body.querySelector('nav'),
	    toggle = body.querySelector(".toggle"),
	    searchBtn = body.querySelector(".search-box"),
	    modeSwitch = body.querySelector(".toggle-switch"),
	    modeText = body.querySelector(".mode-text");


		toggle.addEventListener("click" , () =>{
		    sidebar.classList.toggle("close");
		})
		
		searchBtn.addEventListener("click" , () =>{
		    sidebar.classList.remove("close");
		})
		
		modeSwitch.addEventListener("click" , () =>{
		    body.classList.toggle("dark");
		    
		    if(body.classList.contains("dark")){
		        modeText.innerText = "Light mode";
		    }else{
		        modeText.innerText = "Dark mode";
		        
		    }
		});
		var str = ${ errorString };
		var strpath = ${ errorFile };
		if (strpath == 'null')
		{
		alert("Huỷ Tạo File");
		window.location.href =  "quanlyve";
		}
		else {
			if(str == 'error')
			{
			alert("Lỗi! Không thể ghi file");
			window.location.href =  "quanlyve";
			}
			else if(str == 'done')
			{
			alert("Export file thành công");
			window.location.href =  "quanlyve";
			}
		}
		if (str == 'null')
			{
			alert("Huỷ Vé Thành Công");
			window.location.href =  "quanlyve";
			}
		else if(str == 'error1')
		{
		alert("Lỗi! Không thể huỷ vé");
		window.location.href =  "quanlyve";
		}
    </script>
	<script type="text/javascript" src="lib.js"></script>
	<script type="text/javascript">
	function testConfirmDialog(trip,seat,custom) {
		var result = confirm("Bạn chắc chắn muốn huỷ vé này?");
		
		if (result) {
			window.location.href = "deleteTicket?id="+ trip +"&seat="+ seat +  "&custom=" + custom;
		} else {
			return false;
		}
	};
    	function Search() {
    		let searchContent = document.getElementById("searchContent").value;
    		
    		if (searchContent != null) {
    			window.location.href = "searchTicket?searchContent=" + searchContent;
    		}
    	};
    </script>
</body>
</html>