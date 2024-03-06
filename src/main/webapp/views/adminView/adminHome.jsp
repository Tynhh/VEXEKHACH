<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HomePage</title>
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


	<jsp:include page="/views/adminView/layout/sidebar.jsp" />

	<section class="home">
		<div class="text">Danh Sách Môn Học</div>
		<div class="area-feat">
			<a class="btn btn-success" href="createMonHoc">Thêm môn học</a>
		</div>
		<div class="content">
			<div style="width: 50%;" class="d-flex">
				<input id="searchContent" class="form-control me-1" type="search"
					placeholder="Nhập Mã môn học hoặc Tên môn học" aria-label="Search">
				<a onclick="Search();" class="btn btn-primary" type="submit">Search</a>
			</div>
			<br>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Mã số môn học</th>
						<th scope="col">Tên môn học</th>
						<th scope="col">Số tín chỉ</th>
						<th>Cập nhật</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="2%"><br></td>
						<td><strong>MS</strong><br></td>
						<td><strong>Họ và Tên</strong></td>
						<td><strong>Tên hãng xe</strong><br></td>
						<td><strong>Số điện thoại</strong><br></td>
						<td><strong>Email</strong><br></td>
						<td><strong>Password</strong><br></td>
						<td><strong>Mô tả</strong><br></td>
						<td><strong>Thông tin khác</strong><br></td>
					</tr>
					<tr>
						<td width="2%"><input type="checkbox" class="action"
							name="remove_tutor" value="item"></td>
						<td>01</td>
						<td>Mai Hải Đăng</td>
						<td>Nhà Xe Hải Đăng</td>
						<td>0345888999</td>
						<td>20110244@student.hcmute.edu.vn</td>
						<td>maihaidang</td>
						<td>acbhx</td>
						<td>không có</td>
					</tr>
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