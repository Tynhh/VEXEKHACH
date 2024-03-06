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
<title>Quản Lý Chuyến Xe</title>
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
		<div class="text">Danh Sách Các Chuyến Xe</div>
		<div class="area-feat">
			<a class="btn btn-success" href="addTrip">Thêm Chuyến Xe</a>
		</div>
		<div class="content">
			<div style="width: 50%;" class="d-flex">
				<input id="searchContent" class="form-control me-1" type="search"
					placeholder="Nhập biển số xe" aria-label="Search">
				<a onclick="Search();" class="btn btn-primary" type="submit">Search</a>
			</div>
			<br>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Điểm đi</th>
						<th scope="col">Điểm đến</th>
						<th scope="col">Thời gian</th>
						<th scope="col">Giá</th>
						<th scope="col">Loại xe</th>
						<th scope="col">Biển số</th>
						<th scope="col">Garage id</th>
						<th>Cập nhật</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ listTrips }" >
						<tr>
							<td>${ item.id }</td>
							<td>${ item.departure }</td>
							<td>${ item.destination }</td>
							<td>${ item.departure_time }</td>
							<td>${ item.price }</td>
							<td>${ item.num_seat }</td>
							<td>${ item.trip_board }</td>
							<td>${ item.getGarageID() }</td>
							<td><a class="btn btn-primary"
								href="editTrip?id=${ item.id }">Cập
									nhập</a></td>
							<td><a class="btn btn-danger" href="#"
								onclick="testConfirmDialog('${ item.id }');">Xóa</a>
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
    </script>
	<script type="text/javascript" src="lib.js"></script>
	<script type="text/javascript">
    	function testConfirmDialog(id) {
    		var result = confirm("Bạn chắc chắn muốn xóa chuyến xe này?");
    		
    		if (result) {
    			window.location.href = "deleteTrip?id=" + id;
    		} else {
    			return false;
    		}
    	};
    	function Search() {
    		let searchContent = document.getElementById("searchContent").value;
    		
    		if (searchContent != null) {
    			window.location.href = "searchListTrips?searchContent=" + searchContent;
    		}
    	};
    </script>
</body>
</html>