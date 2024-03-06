<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Tài Khoản</title>
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
<style>
.Options a{
     text-decoration: none;
   
     
}
.Options{
  margin-top: 15px;
     }
.text__Customer{
cursor: pointer;
    margin-left: 25%;}
.text__Manager{
cursor: pointer;
}
.Options a{font-size:110%;font-weight:700;transition:border-bottom .5s;padding:3px 0}
.Options a:active,
.Options a:hover{border-bottom:2px solid #ccc}
.clearfix::after {
    content: " ";
    display: table;
    clear: both;
}
</style>
<body>
	

	<jsp:include page="/views/adminView/layout/sidebar.jsp" />  

	<section class="home">
		<div class="text" style="float:left;">Tài Khoản Manager</div>
		<div class="Options">
			<a class="text text__Customer" href="customerList">Customer</a>
			<a class="text text__Manager" href="managerList">Manager</a>
		</div>
		<div class="clearfix"></div>
<!-- 		<div class="area-feat" >
			<a class="btn btn-success" href="createManager">Thêm Tài Khoản</a>
		</div> -->
		<div class="content">
			<div style="width: 50%;" class="d-flex">
        		<input id="searchContent" class="form-control me-1" type="search" placeholder="Nhập Thông Tin" aria-label="Search">
        		<a onclick="Search();" class="btn btn-primary" type="submit">Search</a>
      		</div>
			<br>
			<table class="table table-striped table-hover">
				<thead>
				    <tr>
				
				      <th scope="col">Họ Tên</th>
				      <th scope="col">Số điện thoại</th>
				      <th scope="col">Email</th>
				      <th scope="col">Password</th>
				 	  <th scope="col">Id Garager</th>
				      <th>Cập nhật</th>
				      <th>Xóa</th>
				    </tr>
		  		</thead>
			  	<tbody>
			  	<c:forEach items="${ managerList }" var="manager" varStatus="loop">
				    <tr>
					     
					      <td>${ manager.fullname }</td>
					     <td>${ manager.phone_number }</td> 
					     <td>${ manager.email }</td>
					     <td>${ manager.password }</td>
					   <td>${ manager.garaid }</td>
					      <td>
					      	<a class="btn btn-primary" href="editManager?id=${manager.id}">Cập nhập</a>
					      </td>
					      <td>
					      	<a class="btn btn-danger" href="#" onclick="testConfirmDialog(${manager.id});">Xóa</a>
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
		
		if (str == 'null')
			{
			alert("Xoá Thành Công");
			window.location.href =  "managerList";
			}
		else if(str == 'error')
			{
			alert("Lỗi! Không Xoá Được");
			window.location.href =  "managerList";
			}
    </script>
    <script type="text/javascript" src="lib.js"></script>
    <script type="text/javascript">
    	function testConfirmDialog(id) {
    		var result = confirm("Bạn chắc chắn muốn xóa tài khoản này?");
    		
    		if (result) {
    			window.location.href = "deleteManager?id=" + id;
    		} else {
    			return false;
    		}
    	};
    	function Search() {
    		let searchContent = document.getElementById("searchContent").value;
    		
    		if (searchContent != null) {
    			window.location.href = "searchManager?searchContent=" + searchContent;
    		}
    	};
    </script>
</body>
</html>