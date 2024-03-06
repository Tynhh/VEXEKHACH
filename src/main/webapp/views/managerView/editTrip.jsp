<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sửa Thông Tin Chuyến Xe</title>
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
		<div class="text">Sửa Thông Tin Chuyến Xe</div>

		<div class="content">
			<p style="color: red;">${ errorString }</p>
			<form action="${ pageContext.request.contextPath }/editTrip"
				method="POST">
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="simpleinput">Id</label> <input
							value="${ trip.id }" type="text" id="simpleinput"
							class="form-control" name="id">
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="simpleinput">Điểm đi</label> <input
							value="${ trip.departure }" type="text" id="simpleinput"
							class="form-control" name="departure">
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="simpleinput">Điểm đến</label> <input
							value="${ trip.destination }" type="text" id="simpleinput"
							class="form-control" name="destination">
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="simpleinput">Thời gian</label> <input
							value="${ trip.departure_time }" required type="text"
							id="simpleinput" class="form-control" name="departure_time">
					</div>
				</div>
				<br>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="simpleinput">Giá</label> <input
							value="${ trip.price }" required type="text" id="simpleinput"
							class="form-control" name="price">
					</div>
				</div>
				<br>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="simpleinput">Loại xe</label> <input
							value="${ trip.num_seat }" required type="text" id="simpleinput"
							class="form-control" name="num_seat">
					</div>
				</div>
				<br>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="simpleinput">Biển số</label> <input
							value="${ trip.trip_board }" required type="text"
							id="simpleinput" class="form-control" name="trip_board">
					</div>
				</div>
				<br>
				<button class="btn btn-success">Cập nhật</button>
				<a class="btn btn-primary"
					href="${ pageContext.request.contextPath }/tripManagement">Hủy</a>
			</form>
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
</body>
</html>