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
<title>Thêm Chuyến Xe</title>
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
		<div class="text">Thêm chuyến xe</div>

		<div class="content">
			<form action="${ pageContext.request.contextPath }/addTrip"
				method="POST">
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="simpleinput">Điểm đi</label> <input required
							type="text" id="simpleinput" class="form-control"
							name="departure">
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="simpleinput">Điểm đến</label> <input required
							type="text" id="simpleinput" class="form-control"
							name="destination">
					</div>
				</div>
				<br>
				<div class="form-row">
					<div class="col-3 custom_flex">
						<label for="simpleinput">Thời gian</label> <input name="departure_time" class="form-control" type="date"
							required>
					</div>
				</div>
				<br>
				<div class="form-group col-md-4">
					<label for="simpleinput">Giá</label> <input required type="text"
						id="simpleinput" class="form-control" name="price">
				</div>
				<br>
				<div class="form-group col-md-4">
					<label for="simpleinput">Loại xe</label> <input required
						type="text" id="simpleinput" class="form-control"
						name="num_seat">
				</div>
				<br>
				<div class="form-group col-md-4">
					<label for="simpleinput">Biển số</label> <input required
						type="text" id="simpleinput" class="form-control"
						name="trip_board">
				</div>
				<br>
				<p style="color: red;">${ errorString }</p>
				<br>
				<button class="btn btn-success">Thêm</button>
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
	<script type="text/javascript" src="lib.js"></script>
	<script type="text/javascript">
    	function testConfirmDialog(maso_monhoc) {
    		var result = confirm("Bạn chắc chắn muốn xóa môn học này?");
    		
    		if (result) {
    			window.location.href = "deleteMonHoc?maso_monhoc=" + maso_monhoc;
    		} else {
    			return false;
    		}
    	};
    	function Search() {
    		let searchContent = document.getElementById("searchContent").value;
    		
    		if (searchContent != null) {
    			window.location.href = "searchListMonHoc?searchContent=" + searchContent;
    		}
    	};
    </script>
</body>
</html>